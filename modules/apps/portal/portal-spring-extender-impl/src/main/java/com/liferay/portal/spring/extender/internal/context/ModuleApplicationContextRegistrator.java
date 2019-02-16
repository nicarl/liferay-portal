/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.spring.extender.internal.context;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.bean.BeanLocatorImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.spring.extender.internal.bean.ApplicationContextServicePublisher;
import com.liferay.portal.spring.extender.internal.bundle.CompositeResourceLoaderBundle;
import com.liferay.portal.spring.extender.internal.classloader.BundleResolverClassLoader;

import java.beans.Introspector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleWiring;

import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Miguel Pastor
 */
public class ModuleApplicationContextRegistrator {

	public ModuleApplicationContextRegistrator(
		Bundle extendeeBundle, Bundle extenderBundle) {

		_extendeeBundle = extendeeBundle;
		_extenderBundle = extenderBundle;
	}

	protected void start() throws Exception {
		try {
			ConfigurableApplicationContext configurableApplicationContext =
				_createApplicationContext(_extenderBundle, _extendeeBundle);

			_registerBeanLocator(
				_extendeeBundle, configurableApplicationContext);

			_configurableApplicationContext = configurableApplicationContext;

			_applicationContextServicePublisher =
				new ApplicationContextServicePublisher(
					_configurableApplicationContext,
					_extendeeBundle.getBundleContext());

			_applicationContextServicePublisher.register();
		}
		catch (Exception e) {
			_log.error(
				"Unable to start " + _extendeeBundle.getSymbolicName(), e);

			throw e;
		}
	}

	protected void stop() throws Exception {
		_cleanInstropectionCaches(_extendeeBundle);

		_applicationContextServicePublisher.unregister();

		PortletBeanLocatorUtil.setBeanLocator(
			_extendeeBundle.getSymbolicName(), null);

		_configurableApplicationContext.close();

		_configurableApplicationContext = null;
	}

	private void _cleanInstropectionCaches(Bundle bundle) {
		BundleWiring bundleWiring = bundle.adapt(BundleWiring.class);

		CachedIntrospectionResults.clearClassLoader(
			bundleWiring.getClassLoader());

		Introspector.flushCaches();
	}

	private ConfigurableApplicationContext _createApplicationContext(
			Bundle extender, Bundle extendee)
		throws RuntimeException {

		String[] beanDefinitionFileNames = _getBeanDefinitionFileNames(
			extendee);

		if (ArrayUtil.isEmpty(beanDefinitionFileNames)) {
			return null;
		}

		ClassLoader classLoader = new BundleResolverClassLoader(
			extendee, extender);

		Bundle compositeResourceLoaderBundle =
			new CompositeResourceLoaderBundle(extendee, extender);

		ModuleApplicationContext moduleApplicationContext =
			new ModuleApplicationContext(
				compositeResourceLoaderBundle, classLoader,
				beanDefinitionFileNames);

		moduleApplicationContext.addBeanFactoryPostProcessor(
			new ModuleBeanFactoryPostProcessor(
				classLoader, extendee.getBundleContext()));

		moduleApplicationContext.refresh();

		return moduleApplicationContext;
	}

	private String[] _getBeanDefinitionFileNames(Bundle bundle) {
		List<String> beanDefinitionFileNames = new ArrayList<>();

		Dictionary<String, String> headers = bundle.getHeaders(
			StringPool.BLANK);

		String liferayService = headers.get("Liferay-Service");

		if (liferayService != null) {
			beanDefinitionFileNames.add("META-INF/spring/parent");
		}

		String springContext = headers.get("Liferay-Spring-Context");

		if (springContext != null) {
			Collections.addAll(
				beanDefinitionFileNames, springContext.split(","));
		}

		return beanDefinitionFileNames.toArray(
			new String[beanDefinitionFileNames.size()]);
	}

	private void _registerBeanLocator(
		Bundle bundle, ApplicationContext applicationContext) {

		BundleWiring bundleWiring = bundle.adapt(BundleWiring.class);

		PortletBeanLocatorUtil.setBeanLocator(
			bundle.getSymbolicName(),
			new BeanLocatorImpl(
				bundleWiring.getClassLoader(), applicationContext));
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ModuleApplicationContextRegistrator.class);

	private ApplicationContextServicePublisher
		_applicationContextServicePublisher;
	private ConfigurableApplicationContext _configurableApplicationContext;
	private final Bundle _extendeeBundle;
	private final Bundle _extenderBundle;

}
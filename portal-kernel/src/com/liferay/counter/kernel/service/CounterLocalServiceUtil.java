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

package com.liferay.counter.kernel.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the local service utility for Counter. This utility wraps
 * <code>com.liferay.counter.service.impl.CounterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CounterLocalService
 * @generated
 */
@ProviderType
public class CounterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.counter.service.impl.CounterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the counter to the database. Also notifies the appropriate model listeners.
	 *
	 * @param counter the counter
	 * @return the counter that was added
	 */
	public static com.liferay.counter.kernel.model.Counter addCounter(
		com.liferay.counter.kernel.model.Counter counter) {

		return getService().addCounter(counter);
	}

	/**
	 * Creates a new counter with the primary key. Does not add the counter to the database.
	 *
	 * @param name the primary key for the new counter
	 * @return the new counter
	 */
	public static com.liferay.counter.kernel.model.Counter createCounter(
		String name) {

		return getService().createCounter(name);
	}

	/**
	 * Deletes the counter from the database. Also notifies the appropriate model listeners.
	 *
	 * @param counter the counter
	 * @return the counter that was removed
	 */
	public static com.liferay.counter.kernel.model.Counter deleteCounter(
		com.liferay.counter.kernel.model.Counter counter) {

		return getService().deleteCounter(counter);
	}

	/**
	 * Deletes the counter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param name the primary key of the counter
	 * @return the counter that was removed
	 * @throws PortalException if a counter with the primary key could not be found
	 */
	public static com.liferay.counter.kernel.model.Counter deleteCounter(
			String name)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCounter(name);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.counter.model.impl.CounterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.counter.model.impl.CounterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.counter.kernel.model.Counter fetchCounter(
		String name) {

		return getService().fetchCounter(name);
	}

	/**
	 * Returns the counter with the primary key.
	 *
	 * @param name the primary key of the counter
	 * @return the counter
	 * @throws PortalException if a counter with the primary key could not be found
	 */
	public static com.liferay.counter.kernel.model.Counter getCounter(
			String name)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCounter(name);
	}

	/**
	 * Returns a range of all the counters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.counter.model.impl.CounterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of counters
	 * @param end the upper bound of the range of counters (not inclusive)
	 * @return the range of counters
	 */
	public static java.util.List<com.liferay.counter.kernel.model.Counter>
		getCounters(int start, int end) {

		return getService().getCounters(start, end);
	}

	/**
	 * Returns the number of counters.
	 *
	 * @return the number of counters
	 */
	public static int getCountersCount() {
		return getService().getCountersCount();
	}

	public static java.util.List<String> getNames() {
		return getService().getNames();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static long increment() {
		return getService().increment();
	}

	public static long increment(String name) {
		return getService().increment(name);
	}

	public static long increment(String name, int size) {
		return getService().increment(name, size);
	}

	public static void rename(String oldName, String newName) {
		getService().rename(oldName, newName);
	}

	public static void reset(String name) {
		getService().reset(name);
	}

	public static void reset(String name, long size) {
		getService().reset(name, size);
	}

	/**
	 * Updates the counter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param counter the counter
	 * @return the counter that was updated
	 */
	public static com.liferay.counter.kernel.model.Counter updateCounter(
		com.liferay.counter.kernel.model.Counter counter) {

		return getService().updateCounter(counter);
	}

	public static CounterLocalService getService() {
		if (_service == null) {
			_service = (CounterLocalService)PortalBeanLocatorUtil.locate(
				CounterLocalService.class.getName());
		}

		return _service;
	}

	private static CounterLocalService _service;

}
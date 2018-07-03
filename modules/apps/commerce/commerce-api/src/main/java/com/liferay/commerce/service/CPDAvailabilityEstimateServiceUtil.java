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

package com.liferay.commerce.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for CPDAvailabilityEstimate. This utility wraps
 * {@link com.liferay.commerce.service.impl.CPDAvailabilityEstimateServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Alessio Antonio Rendina
 * @see CPDAvailabilityEstimateService
 * @see com.liferay.commerce.service.base.CPDAvailabilityEstimateServiceBaseImpl
 * @see com.liferay.commerce.service.impl.CPDAvailabilityEstimateServiceImpl
 * @generated
 */
@ProviderType
public class CPDAvailabilityEstimateServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.commerce.service.impl.CPDAvailabilityEstimateServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.commerce.model.CPDAvailabilityEstimate fetchCPDAvailabilityEstimateByCPDefinitionId(
		long cpDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .fetchCPDAvailabilityEstimateByCPDefinitionId(cpDefinitionId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.commerce.model.CPDAvailabilityEstimate updateCPDAvailabilityEstimate(
		long cpdAvailabilityEstimateId, long cpDefinitionId,
		long commerceAvailabilityEstimateId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateCPDAvailabilityEstimate(cpdAvailabilityEstimateId,
			cpDefinitionId, commerceAvailabilityEstimateId, serviceContext);
	}

	public static CPDAvailabilityEstimateService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CPDAvailabilityEstimateService, CPDAvailabilityEstimateService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CPDAvailabilityEstimateService.class);

		ServiceTracker<CPDAvailabilityEstimateService, CPDAvailabilityEstimateService> serviceTracker =
			new ServiceTracker<CPDAvailabilityEstimateService, CPDAvailabilityEstimateService>(bundle.getBundleContext(),
				CPDAvailabilityEstimateService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
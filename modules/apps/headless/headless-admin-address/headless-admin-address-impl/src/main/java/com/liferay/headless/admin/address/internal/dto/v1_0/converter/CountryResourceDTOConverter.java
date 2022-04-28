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

package com.liferay.headless.admin.address.internal.dto.v1_0.converter;

import com.liferay.headless.admin.address.dto.v1_0.Country;
import com.liferay.headless.admin.address.dto.v1_0.Region;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.dto.converter.DTOConverterContext;
import com.liferay.portal.vulcan.util.TransformUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Drew Brokke
 */
@Component(
	property = "dto.class.name=com.liferay.portal.kernel.model.Country",
	service = {CountryResourceDTOConverter.class, DTOConverter.class}
)
public class CountryResourceDTOConverter
	implements DTOConverter<com.liferay.portal.kernel.model.Country, Country> {

	@Override
	public String getContentType() {
		return Country.class.getSimpleName();
	}

	@Override
	public com.liferay.portal.kernel.model.Country getObject(
			String externalReferenceCode)
		throws Exception {

		return _countryService.getCountry(
			GetterUtil.getLong(externalReferenceCode));
	}

	@Override
	public Country toDTO(com.liferay.portal.kernel.model.Country object)
		throws Exception {

		return DTOConverter.super.toDTO(object);
	}

	@Override
	public Country toDTO(
			DTOConverterContext dtoConverterContext,
			com.liferay.portal.kernel.model.Country serviceBuilderCountry)
		throws Exception {

		return new Country() {
			{
				a2 = serviceBuilderCountry.getA2();
				a3 = serviceBuilderCountry.getA3();
				active = serviceBuilderCountry.getActive();
				billingAllowed = serviceBuilderCountry.getBillingAllowed();
				groupFilterEnabled =
					serviceBuilderCountry.getGroupFilterEnabled();
				id = serviceBuilderCountry.getCountryId();

				String idd = serviceBuilderCountry.getIdd();

				if (Validator.isNotNull(idd)) {
					setIdd(Integer.valueOf(idd));
				}

				name = serviceBuilderCountry.getName();
				number = Integer.valueOf(serviceBuilderCountry.getNumber());
				position = serviceBuilderCountry.getPosition();
				regions = TransformUtil.transformToArray(
					_regionService.getRegions(
						serviceBuilderCountry.getCountryId()),
					serviceBuilderRegion -> _toRegion(serviceBuilderRegion),
					Region.class);
				shippingAllowed = serviceBuilderCountry.getShippingAllowed();
				subjectToVAT = serviceBuilderCountry.getSubjectToVAT();
				title_i18n = serviceBuilderCountry.getLanguageIdToTitleMap();
				zipRequired = serviceBuilderCountry.getZipRequired();
			}
		};
	}

	private Region _toRegion(
		com.liferay.portal.kernel.model.Region serviceBuilderRegion) {

		return new Region() {
			{
				active = serviceBuilderRegion.getActive();
				countryId = serviceBuilderRegion.getCountryId();
				id = serviceBuilderRegion.getRegionId();
				name = serviceBuilderRegion.getName();
				regionCode = serviceBuilderRegion.getRegionCode();
				title_i18n = serviceBuilderRegion.getLanguageIdToTitleMap();
			}
		};
	}

	@Reference
	private CountryService _countryService;

	@Reference
	private RegionService _regionService;

}
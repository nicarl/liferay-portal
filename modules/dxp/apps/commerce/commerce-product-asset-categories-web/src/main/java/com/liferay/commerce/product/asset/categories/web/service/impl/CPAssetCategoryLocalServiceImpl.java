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

package com.liferay.commerce.product.asset.categories.web.service.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceWrapper;
import com.liferay.commerce.product.service.CPDisplayLayoutLocalService;
import com.liferay.commerce.product.service.CPFriendlyURLEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marco Leo
 */
@Component(immediate = true, service = ServiceWrapper.class)
public class CPAssetCategoryLocalServiceImpl
	extends AssetCategoryLocalServiceWrapper {

	public CPAssetCategoryLocalServiceImpl() {
		super(null);
	}

	@Override
	public AssetCategory addCategory(
			long userId, long groupId, long parentCategoryId,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			long vocabularyId, String[] categoryProperties,
			ServiceContext serviceContext)
		throws PortalException {

		AssetCategory assetCategory = super.addCategory(
			userId, groupId, parentCategoryId, titleMap, descriptionMap,
			vocabularyId, categoryProperties, serviceContext);

		String layoutUuid = (String)serviceContext.getAttribute("layoutUuid");

		String urlTitleMapAsXML = (String)serviceContext.getAttribute(
			"urlTitleMapAsXML");

		Map<Locale, String> urlTitleMap = LocalizationUtil.getLocalizationMap(
			urlTitleMapAsXML);

		urlTitleMap = _getUniqueUrlTitles(assetCategory, urlTitleMap);

		// Commerce product display layout

		_cpDisplayLayoutLocalService.addCPDisplayLayout(
			AssetCategory.class, assetCategory.getCategoryId(), layoutUuid,
			serviceContext);

		// Commerce product friendly URL

		_cpFriendlyURLEntryLocalService.addCPFriendlyURLEntries(
			groupId, serviceContext.getCompanyId(), AssetCategory.class,
			assetCategory.getCategoryId(), urlTitleMap);

		return assetCategory;
	}

	@Override
	public AssetCategory updateCategory(
			long userId, long categoryId, long parentCategoryId,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			long vocabularyId, String[] categoryProperties,
			ServiceContext serviceContext)
		throws PortalException {

		AssetCategory assetCategory = super.updateCategory(
			userId, categoryId, parentCategoryId, titleMap, descriptionMap,
			vocabularyId, categoryProperties, serviceContext);

		String layoutUuid = (String)serviceContext.getAttribute("layoutUuid");

		Map<Locale, String> urlTitleMap = LocalizationUtil.getLocalizationMap(
			serviceContext.getRequest(), "urlTitleMapAsXML");

		// Commerce product display layout

		_cpDisplayLayoutLocalService.addCPDisplayLayout(
			AssetCategory.class, assetCategory.getCategoryId(), layoutUuid,
			serviceContext);

		// Commerce product friendly URL

		_cpFriendlyURLEntryLocalService.addCPFriendlyURLEntries(
			serviceContext.getScopeGroupId(), serviceContext.getCompanyId(),
			AssetCategory.class, assetCategory.getCategoryId(), urlTitleMap);

		return assetCategory;
	}

	private Map<Locale, String> _getUniqueUrlTitles(
			AssetCategory assetCategory, Map<Locale, String> urlTitleMap)
		throws PortalException {

		Map<Locale, String> newUrlTitleMap = new HashMap<>();

		Map<Locale, String> titleMap = assetCategory.getTitleMap();

		long classNameId = _classNameLocalService.getClassNameId(
			AssetCategory.class);

		for (Map.Entry<Locale, String> titleEntry : titleMap.entrySet()) {
			String urlTitle = urlTitleMap.get(titleEntry.getKey());

			if (Validator.isNull(urlTitle)) {
				urlTitle = titleEntry.getValue();
			}

			String languageId = LanguageUtil.getLanguageId(titleEntry.getKey());

			urlTitle = _cpFriendlyURLEntryLocalService.buildUrlTitle(
				assetCategory.getGroupId(), assetCategory.getCompanyId(),
				classNameId, assetCategory.getCategoryId(), languageId,
				urlTitle);

			newUrlTitleMap.put(titleEntry.getKey(), urlTitle);
		}

		return newUrlTitleMap;
	}

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private CPDisplayLayoutLocalService _cpDisplayLayoutLocalService;

	@Reference
	private CPFriendlyURLEntryLocalService _cpFriendlyURLEntryLocalService;

}
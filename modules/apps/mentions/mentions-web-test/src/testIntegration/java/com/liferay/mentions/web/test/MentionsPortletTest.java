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

package com.liferay.mentions.web.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.mentions.constants.MentionsPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.test.portlet.MockLiferayResourceRequest;
import com.liferay.portal.kernel.test.portlet.MockLiferayResourceResponse;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

import javax.portlet.Portlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.portlet.MockResourceResponse;

/**
 * @author Cristina González
 */
@RunWith(Arquillian.class)
public class MentionsPortletTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();
	}

	@Test
	public void testServletResponse() throws Exception {
		MVCPortlet mvcPortlet = (MVCPortlet)_portlet;

		MockResourceResponse mockResourceResponse = new MockResourceResponse();

		mvcPortlet.serveResource(
			_getMockLiferayResourceRequest(), mockResourceResponse);

		HttpServletResponse httpServletResponse =
			mockResourceResponse.getHttpServletResponse();

		Assert.assertEquals(
			ContentTypes.APPLICATION_JSON,
			httpServletResponse.getContentType());
	}

	private MockLiferayResourceRequest _getMockLiferayResourceRequest()
		throws PortalException {

		ThemeDisplay themeDisplay = _getThemeDisplay();

		MockResourceRequest mockResourceRequest = new MockResourceRequest(
			themeDisplay);

		mockResourceRequest.setAttribute(WebKeys.THEME_DISPLAY, themeDisplay);

		return mockResourceRequest;
	}

	private ThemeDisplay _getThemeDisplay() throws PortalException {
		ThemeDisplay themeDisplay = new ThemeDisplay();

		themeDisplay.setCompany(
			_companyLocalService.getCompany(_group.getCompanyId()));
		themeDisplay.setSiteGroupId(_group.getGroupId());
		themeDisplay.setUser(TestPropsValues.getUser());

		return themeDisplay;
	}

	@Inject
	private CompanyLocalService _companyLocalService;

	@DeleteAfterTestRun
	private Group _group;

	@Inject(filter = "javax.portlet.name=" + MentionsPortletKeys.MENTIONS)
	private Portlet _portlet;

	private static class MockResourceRequest
		extends MockLiferayResourceRequest {

		public MockResourceRequest(ThemeDisplay themeDisplay) {
			_themeDisplay = themeDisplay;
		}

		@Override
		public HttpServletRequest getHttpServletRequest() {
			MockHttpServletRequest mockHttpServletRequest =
				new MockHttpServletRequest();

			mockHttpServletRequest.setAttribute(
				WebKeys.THEME_DISPLAY, _themeDisplay);

			return mockHttpServletRequest;
		}

		private final ThemeDisplay _themeDisplay;

	}

	private static class MockResourceResponse
		extends MockLiferayResourceResponse {

		public MockResourceResponse() {
			_mockHttpServletResponse = new MockHttpServletResponse();
		}

		@Override
		public HttpServletResponse getHttpServletResponse() {
			return _mockHttpServletResponse;
		}

		private final MockHttpServletResponse _mockHttpServletResponse;

	}

}
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

package com.liferay.commerce.product.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.product.model.CPDefinitionLink;
import com.liferay.commerce.product.model.CPDefinitionLinkModel;
import com.liferay.commerce.product.model.CPDefinitionLinkSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CPDefinitionLink service. Represents a row in the &quot;CPDefinitionLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CPDefinitionLinkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDefinitionLinkImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPDefinitionLinkImpl
 * @see CPDefinitionLink
 * @see CPDefinitionLinkModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CPDefinitionLinkModelImpl extends BaseModelImpl<CPDefinitionLink>
	implements CPDefinitionLinkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp definition link model instance should use the {@link CPDefinitionLink} interface instead.
	 */
	public static final String TABLE_NAME = "CPDefinitionLink";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "CPDefinitionLinkId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "CPDefinitionId1", Types.BIGINT },
			{ "CPDefinitionId2", Types.BIGINT },
			{ "priority", Types.DOUBLE },
			{ "type_", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPDefinitionLinkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("CPDefinitionId1", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CPDefinitionId2", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("priority", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table CPDefinitionLink (uuid_ VARCHAR(75) null,CPDefinitionLinkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,CPDefinitionId1 LONG,CPDefinitionId2 LONG,priority DOUBLE,type_ VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table CPDefinitionLink";
	public static final String ORDER_BY_JPQL = " ORDER BY cpDefinitionLink.priority ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CPDefinitionLink.priority ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.product.model.CPDefinitionLink"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.product.model.CPDefinitionLink"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.product.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.product.model.CPDefinitionLink"),
			true);
	public static final long CPDEFINITIONID1_COLUMN_BITMASK = 1L;
	public static final long CPDEFINITIONID2_COLUMN_BITMASK = 2L;
	public static final long COMPANYID_COLUMN_BITMASK = 4L;
	public static final long GROUPID_COLUMN_BITMASK = 8L;
	public static final long TYPE_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long PRIORITY_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CPDefinitionLink toModel(CPDefinitionLinkSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CPDefinitionLink model = new CPDefinitionLinkImpl();

		model.setUuid(soapModel.getUuid());
		model.setCPDefinitionLinkId(soapModel.getCPDefinitionLinkId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCPDefinitionId1(soapModel.getCPDefinitionId1());
		model.setCPDefinitionId2(soapModel.getCPDefinitionId2());
		model.setPriority(soapModel.getPriority());
		model.setType(soapModel.getType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CPDefinitionLink> toModels(
		CPDefinitionLinkSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CPDefinitionLink> models = new ArrayList<CPDefinitionLink>(soapModels.length);

		for (CPDefinitionLinkSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.product.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.product.model.CPDefinitionLink"));

	public CPDefinitionLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CPDefinitionLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCPDefinitionLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CPDefinitionLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPDefinitionLink.class;
	}

	@Override
	public String getModelClassName() {
		return CPDefinitionLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("CPDefinitionLinkId", getCPDefinitionLinkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("CPDefinitionId1", getCPDefinitionId1());
		attributes.put("CPDefinitionId2", getCPDefinitionId2());
		attributes.put("priority", getPriority());
		attributes.put("type", getType());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long CPDefinitionLinkId = (Long)attributes.get("CPDefinitionLinkId");

		if (CPDefinitionLinkId != null) {
			setCPDefinitionLinkId(CPDefinitionLinkId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long CPDefinitionId1 = (Long)attributes.get("CPDefinitionId1");

		if (CPDefinitionId1 != null) {
			setCPDefinitionId1(CPDefinitionId1);
		}

		Long CPDefinitionId2 = (Long)attributes.get("CPDefinitionId2");

		if (CPDefinitionId2 != null) {
			setCPDefinitionId2(CPDefinitionId2);
		}

		Double priority = (Double)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCPDefinitionLinkId() {
		return _CPDefinitionLinkId;
	}

	@Override
	public void setCPDefinitionLinkId(long CPDefinitionLinkId) {
		_CPDefinitionLinkId = CPDefinitionLinkId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCPDefinitionId1() {
		return _CPDefinitionId1;
	}

	@Override
	public void setCPDefinitionId1(long CPDefinitionId1) {
		_columnBitmask |= CPDEFINITIONID1_COLUMN_BITMASK;

		if (!_setOriginalCPDefinitionId1) {
			_setOriginalCPDefinitionId1 = true;

			_originalCPDefinitionId1 = _CPDefinitionId1;
		}

		_CPDefinitionId1 = CPDefinitionId1;
	}

	public long getOriginalCPDefinitionId1() {
		return _originalCPDefinitionId1;
	}

	@JSON
	@Override
	public long getCPDefinitionId2() {
		return _CPDefinitionId2;
	}

	@Override
	public void setCPDefinitionId2(long CPDefinitionId2) {
		_columnBitmask |= CPDEFINITIONID2_COLUMN_BITMASK;

		if (!_setOriginalCPDefinitionId2) {
			_setOriginalCPDefinitionId2 = true;

			_originalCPDefinitionId2 = _CPDefinitionId2;
		}

		_CPDefinitionId2 = CPDefinitionId2;
	}

	public long getOriginalCPDefinitionId2() {
		return _originalCPDefinitionId2;
	}

	@JSON
	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		_columnBitmask = -1L;

		_priority = priority;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				CPDefinitionLink.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CPDefinitionLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CPDefinitionLink toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CPDefinitionLink)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CPDefinitionLinkImpl cpDefinitionLinkImpl = new CPDefinitionLinkImpl();

		cpDefinitionLinkImpl.setUuid(getUuid());
		cpDefinitionLinkImpl.setCPDefinitionLinkId(getCPDefinitionLinkId());
		cpDefinitionLinkImpl.setGroupId(getGroupId());
		cpDefinitionLinkImpl.setCompanyId(getCompanyId());
		cpDefinitionLinkImpl.setUserId(getUserId());
		cpDefinitionLinkImpl.setUserName(getUserName());
		cpDefinitionLinkImpl.setCreateDate(getCreateDate());
		cpDefinitionLinkImpl.setModifiedDate(getModifiedDate());
		cpDefinitionLinkImpl.setCPDefinitionId1(getCPDefinitionId1());
		cpDefinitionLinkImpl.setCPDefinitionId2(getCPDefinitionId2());
		cpDefinitionLinkImpl.setPriority(getPriority());
		cpDefinitionLinkImpl.setType(getType());

		cpDefinitionLinkImpl.resetOriginalValues();

		return cpDefinitionLinkImpl;
	}

	@Override
	public int compareTo(CPDefinitionLink cpDefinitionLink) {
		int value = 0;

		if (getPriority() < cpDefinitionLink.getPriority()) {
			value = -1;
		}
		else if (getPriority() > cpDefinitionLink.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CPDefinitionLink)) {
			return false;
		}

		CPDefinitionLink cpDefinitionLink = (CPDefinitionLink)obj;

		long primaryKey = cpDefinitionLink.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CPDefinitionLinkModelImpl cpDefinitionLinkModelImpl = this;

		cpDefinitionLinkModelImpl._originalUuid = cpDefinitionLinkModelImpl._uuid;

		cpDefinitionLinkModelImpl._originalGroupId = cpDefinitionLinkModelImpl._groupId;

		cpDefinitionLinkModelImpl._setOriginalGroupId = false;

		cpDefinitionLinkModelImpl._originalCompanyId = cpDefinitionLinkModelImpl._companyId;

		cpDefinitionLinkModelImpl._setOriginalCompanyId = false;

		cpDefinitionLinkModelImpl._setModifiedDate = false;

		cpDefinitionLinkModelImpl._originalCPDefinitionId1 = cpDefinitionLinkModelImpl._CPDefinitionId1;

		cpDefinitionLinkModelImpl._setOriginalCPDefinitionId1 = false;

		cpDefinitionLinkModelImpl._originalCPDefinitionId2 = cpDefinitionLinkModelImpl._CPDefinitionId2;

		cpDefinitionLinkModelImpl._setOriginalCPDefinitionId2 = false;

		cpDefinitionLinkModelImpl._originalType = cpDefinitionLinkModelImpl._type;

		cpDefinitionLinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CPDefinitionLink> toCacheModel() {
		CPDefinitionLinkCacheModel cpDefinitionLinkCacheModel = new CPDefinitionLinkCacheModel();

		cpDefinitionLinkCacheModel.uuid = getUuid();

		String uuid = cpDefinitionLinkCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cpDefinitionLinkCacheModel.uuid = null;
		}

		cpDefinitionLinkCacheModel.CPDefinitionLinkId = getCPDefinitionLinkId();

		cpDefinitionLinkCacheModel.groupId = getGroupId();

		cpDefinitionLinkCacheModel.companyId = getCompanyId();

		cpDefinitionLinkCacheModel.userId = getUserId();

		cpDefinitionLinkCacheModel.userName = getUserName();

		String userName = cpDefinitionLinkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cpDefinitionLinkCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cpDefinitionLinkCacheModel.createDate = createDate.getTime();
		}
		else {
			cpDefinitionLinkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cpDefinitionLinkCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cpDefinitionLinkCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cpDefinitionLinkCacheModel.CPDefinitionId1 = getCPDefinitionId1();

		cpDefinitionLinkCacheModel.CPDefinitionId2 = getCPDefinitionId2();

		cpDefinitionLinkCacheModel.priority = getPriority();

		cpDefinitionLinkCacheModel.type = getType();

		String type = cpDefinitionLinkCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			cpDefinitionLinkCacheModel.type = null;
		}

		return cpDefinitionLinkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", CPDefinitionLinkId=");
		sb.append(getCPDefinitionLinkId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", CPDefinitionId1=");
		sb.append(getCPDefinitionId1());
		sb.append(", CPDefinitionId2=");
		sb.append(getCPDefinitionId2());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.product.model.CPDefinitionLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPDefinitionLinkId</column-name><column-value><![CDATA[");
		sb.append(getCPDefinitionLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPDefinitionId1</column-name><column-value><![CDATA[");
		sb.append(getCPDefinitionId1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPDefinitionId2</column-name><column-value><![CDATA[");
		sb.append(getCPDefinitionId2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CPDefinitionLink.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CPDefinitionLink.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _CPDefinitionLinkId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _CPDefinitionId1;
	private long _originalCPDefinitionId1;
	private boolean _setOriginalCPDefinitionId1;
	private long _CPDefinitionId2;
	private long _originalCPDefinitionId2;
	private boolean _setOriginalCPDefinitionId2;
	private double _priority;
	private String _type;
	private String _originalType;
	private long _columnBitmask;
	private CPDefinitionLink _escapedModel;
}
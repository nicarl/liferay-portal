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

package com.liferay.commerce.vat.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.vat.model.CommerceVatNumber;
import com.liferay.commerce.vat.model.CommerceVatNumberModel;
import com.liferay.commerce.vat.model.CommerceVatNumberSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CommerceVatNumber service. Represents a row in the &quot;CommerceVatNumber&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CommerceVatNumberModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceVatNumberImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceVatNumberImpl
 * @see CommerceVatNumber
 * @see CommerceVatNumberModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommerceVatNumberModelImpl extends BaseModelImpl<CommerceVatNumber>
	implements CommerceVatNumberModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce vat number model instance should use the {@link CommerceVatNumber} interface instead.
	 */
	public static final String TABLE_NAME = "CommerceVatNumber";
	public static final Object[][] TABLE_COLUMNS = {
			{ "commerceVatNumberId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "vatNumber", Types.VARCHAR },
			{ "valid", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceVatNumberId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("vatNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("valid", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table CommerceVatNumber (commerceVatNumberId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,vatNumber VARCHAR(75) null,valid BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table CommerceVatNumber";
	public static final String ORDER_BY_JPQL = " ORDER BY commerceVatNumber.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CommerceVatNumber.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.vat.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.vat.model.CommerceVatNumber"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.vat.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.vat.model.CommerceVatNumber"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.vat.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.vat.model.CommerceVatNumber"),
			true);
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static final long CLASSPK_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long CREATEDATE_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceVatNumber toModel(CommerceVatNumberSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommerceVatNumber model = new CommerceVatNumberImpl();

		model.setCommerceVatNumberId(soapModel.getCommerceVatNumberId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setVatNumber(soapModel.getVatNumber());
		model.setValid(soapModel.getValid());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceVatNumber> toModels(
		CommerceVatNumberSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommerceVatNumber> models = new ArrayList<CommerceVatNumber>(soapModels.length);

		for (CommerceVatNumberSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.vat.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.vat.model.CommerceVatNumber"));

	public CommerceVatNumberModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceVatNumberId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceVatNumberId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceVatNumberId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceVatNumber.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceVatNumber.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commerceVatNumberId", getCommerceVatNumberId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("vatNumber", getVatNumber());
		attributes.put("valid", getValid());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commerceVatNumberId = (Long)attributes.get("commerceVatNumberId");

		if (commerceVatNumberId != null) {
			setCommerceVatNumberId(commerceVatNumberId);
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

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String vatNumber = (String)attributes.get("vatNumber");

		if (vatNumber != null) {
			setVatNumber(vatNumber);
		}

		Boolean valid = (Boolean)attributes.get("valid");

		if (valid != null) {
			setValid(valid);
		}
	}

	@JSON
	@Override
	public long getCommerceVatNumberId() {
		return _commerceVatNumberId;
	}

	@Override
	public void setCommerceVatNumberId(long commerceVatNumberId) {
		_commerceVatNumberId = commerceVatNumberId;
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
		_companyId = companyId;
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
		_columnBitmask = -1L;

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

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	@Override
	public String getVatNumber() {
		if (_vatNumber == null) {
			return "";
		}
		else {
			return _vatNumber;
		}
	}

	@Override
	public void setVatNumber(String vatNumber) {
		_vatNumber = vatNumber;
	}

	@JSON
	@Override
	public boolean getValid() {
		return _valid;
	}

	@JSON
	@Override
	public boolean isValid() {
		return _valid;
	}

	@Override
	public void setValid(boolean valid) {
		_valid = valid;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CommerceVatNumber.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceVatNumber toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommerceVatNumber)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceVatNumberImpl commerceVatNumberImpl = new CommerceVatNumberImpl();

		commerceVatNumberImpl.setCommerceVatNumberId(getCommerceVatNumberId());
		commerceVatNumberImpl.setGroupId(getGroupId());
		commerceVatNumberImpl.setCompanyId(getCompanyId());
		commerceVatNumberImpl.setUserId(getUserId());
		commerceVatNumberImpl.setUserName(getUserName());
		commerceVatNumberImpl.setCreateDate(getCreateDate());
		commerceVatNumberImpl.setModifiedDate(getModifiedDate());
		commerceVatNumberImpl.setClassNameId(getClassNameId());
		commerceVatNumberImpl.setClassPK(getClassPK());
		commerceVatNumberImpl.setVatNumber(getVatNumber());
		commerceVatNumberImpl.setValid(getValid());

		commerceVatNumberImpl.resetOriginalValues();

		return commerceVatNumberImpl;
	}

	@Override
	public int compareTo(CommerceVatNumber commerceVatNumber) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				commerceVatNumber.getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof CommerceVatNumber)) {
			return false;
		}

		CommerceVatNumber commerceVatNumber = (CommerceVatNumber)obj;

		long primaryKey = commerceVatNumber.getPrimaryKey();

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
		CommerceVatNumberModelImpl commerceVatNumberModelImpl = this;

		commerceVatNumberModelImpl._originalGroupId = commerceVatNumberModelImpl._groupId;

		commerceVatNumberModelImpl._setOriginalGroupId = false;

		commerceVatNumberModelImpl._setModifiedDate = false;

		commerceVatNumberModelImpl._originalClassNameId = commerceVatNumberModelImpl._classNameId;

		commerceVatNumberModelImpl._setOriginalClassNameId = false;

		commerceVatNumberModelImpl._originalClassPK = commerceVatNumberModelImpl._classPK;

		commerceVatNumberModelImpl._setOriginalClassPK = false;

		commerceVatNumberModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceVatNumber> toCacheModel() {
		CommerceVatNumberCacheModel commerceVatNumberCacheModel = new CommerceVatNumberCacheModel();

		commerceVatNumberCacheModel.commerceVatNumberId = getCommerceVatNumberId();

		commerceVatNumberCacheModel.groupId = getGroupId();

		commerceVatNumberCacheModel.companyId = getCompanyId();

		commerceVatNumberCacheModel.userId = getUserId();

		commerceVatNumberCacheModel.userName = getUserName();

		String userName = commerceVatNumberCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceVatNumberCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceVatNumberCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceVatNumberCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceVatNumberCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceVatNumberCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceVatNumberCacheModel.classNameId = getClassNameId();

		commerceVatNumberCacheModel.classPK = getClassPK();

		commerceVatNumberCacheModel.vatNumber = getVatNumber();

		String vatNumber = commerceVatNumberCacheModel.vatNumber;

		if ((vatNumber != null) && (vatNumber.length() == 0)) {
			commerceVatNumberCacheModel.vatNumber = null;
		}

		commerceVatNumberCacheModel.valid = getValid();

		return commerceVatNumberCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{commerceVatNumberId=");
		sb.append(getCommerceVatNumberId());
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
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", vatNumber=");
		sb.append(getVatNumber());
		sb.append(", valid=");
		sb.append(getValid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.vat.model.CommerceVatNumber");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commerceVatNumberId</column-name><column-value><![CDATA[");
		sb.append(getCommerceVatNumberId());
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
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vatNumber</column-name><column-value><![CDATA[");
		sb.append(getVatNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valid</column-name><column-value><![CDATA[");
		sb.append(getValid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CommerceVatNumber.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CommerceVatNumber.class
		};
	private long _commerceVatNumberId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private String _vatNumber;
	private boolean _valid;
	private long _columnBitmask;
	private CommerceVatNumber _escapedModel;
}
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

package com.liferay.object.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.object.model.ObjectAction;
import com.liferay.object.model.ObjectActionModel;
import com.liferay.petra.string.StringBundler;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ObjectAction service. Represents a row in the &quot;ObjectAction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ObjectActionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ObjectActionImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see ObjectActionImpl
 * @generated
 */
@JSON(strict = true)
public class ObjectActionModelImpl
	extends BaseModelImpl<ObjectAction> implements ObjectActionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a object action model instance should use the <code>ObjectAction</code> interface instead.
	 */
	public static final String TABLE_NAME = "ObjectAction";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"objectActionId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"objectDefinitionId", Types.BIGINT}, {"active_", Types.BOOLEAN},
		{"conditionExpression", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"name", Types.VARCHAR}, {"objectActionExecutorKey", Types.VARCHAR},
		{"objectActionTriggerKey", Types.VARCHAR}, {"parameters", Types.CLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("objectActionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("objectDefinitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("conditionExpression", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("objectActionExecutorKey", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("objectActionTriggerKey", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("parameters", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ObjectAction (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,objectActionId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,objectDefinitionId LONG,active_ BOOLEAN,conditionExpression VARCHAR(75) null,description VARCHAR(75) null,name VARCHAR(75) null,objectActionExecutorKey VARCHAR(75) null,objectActionTriggerKey VARCHAR(75) null,parameters TEXT null)";

	public static final String TABLE_SQL_DROP = "drop table ObjectAction";

	public static final String ORDER_BY_JPQL =
		" ORDER BY objectAction.objectActionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ObjectAction.objectActionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ACTIVE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long OBJECTACTIONTRIGGERKEY_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long OBJECTDEFINITIONID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long OBJECTACTIONID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public ObjectActionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _objectActionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setObjectActionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _objectActionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ObjectAction.class;
	}

	@Override
	public String getModelClassName() {
		return ObjectAction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ObjectAction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ObjectAction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ObjectAction, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ObjectAction)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ObjectAction, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ObjectAction, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ObjectAction)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ObjectAction, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ObjectAction, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ObjectAction, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ObjectAction, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ObjectAction, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ObjectAction, Object>>();
		Map<String, BiConsumer<ObjectAction, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ObjectAction, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", ObjectAction::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<ObjectAction, Long>)ObjectAction::setMvccVersion);
		attributeGetterFunctions.put("uuid", ObjectAction::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<ObjectAction, String>)ObjectAction::setUuid);
		attributeGetterFunctions.put(
			"objectActionId", ObjectAction::getObjectActionId);
		attributeSetterBiConsumers.put(
			"objectActionId",
			(BiConsumer<ObjectAction, Long>)ObjectAction::setObjectActionId);
		attributeGetterFunctions.put("companyId", ObjectAction::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ObjectAction, Long>)ObjectAction::setCompanyId);
		attributeGetterFunctions.put("userId", ObjectAction::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<ObjectAction, Long>)ObjectAction::setUserId);
		attributeGetterFunctions.put("userName", ObjectAction::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ObjectAction, String>)ObjectAction::setUserName);
		attributeGetterFunctions.put("createDate", ObjectAction::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ObjectAction, Date>)ObjectAction::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ObjectAction::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ObjectAction, Date>)ObjectAction::setModifiedDate);
		attributeGetterFunctions.put(
			"objectDefinitionId", ObjectAction::getObjectDefinitionId);
		attributeSetterBiConsumers.put(
			"objectDefinitionId",
			(BiConsumer<ObjectAction, Long>)
				ObjectAction::setObjectDefinitionId);
		attributeGetterFunctions.put("active", ObjectAction::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<ObjectAction, Boolean>)ObjectAction::setActive);
		attributeGetterFunctions.put(
			"conditionExpression", ObjectAction::getConditionExpression);
		attributeSetterBiConsumers.put(
			"conditionExpression",
			(BiConsumer<ObjectAction, String>)
				ObjectAction::setConditionExpression);
		attributeGetterFunctions.put(
			"description", ObjectAction::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<ObjectAction, String>)ObjectAction::setDescription);
		attributeGetterFunctions.put("name", ObjectAction::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<ObjectAction, String>)ObjectAction::setName);
		attributeGetterFunctions.put(
			"objectActionExecutorKey",
			ObjectAction::getObjectActionExecutorKey);
		attributeSetterBiConsumers.put(
			"objectActionExecutorKey",
			(BiConsumer<ObjectAction, String>)
				ObjectAction::setObjectActionExecutorKey);
		attributeGetterFunctions.put(
			"objectActionTriggerKey", ObjectAction::getObjectActionTriggerKey);
		attributeSetterBiConsumers.put(
			"objectActionTriggerKey",
			(BiConsumer<ObjectAction, String>)
				ObjectAction::setObjectActionTriggerKey);
		attributeGetterFunctions.put("parameters", ObjectAction::getParameters);
		attributeSetterBiConsumers.put(
			"parameters",
			(BiConsumer<ObjectAction, String>)ObjectAction::setParameters);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getObjectActionId() {
		return _objectActionId;
	}

	@Override
	public void setObjectActionId(long objectActionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_objectActionId = objectActionId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getObjectDefinitionId() {
		return _objectDefinitionId;
	}

	@Override
	public void setObjectDefinitionId(long objectDefinitionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_objectDefinitionId = objectDefinitionId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalObjectDefinitionId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("objectDefinitionId"));
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_active = active;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalActive() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("active_"));
	}

	@JSON
	@Override
	public String getConditionExpression() {
		if (_conditionExpression == null) {
			return "";
		}
		else {
			return _conditionExpression;
		}
	}

	@Override
	public void setConditionExpression(String conditionExpression) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_conditionExpression = conditionExpression;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public String getObjectActionExecutorKey() {
		if (_objectActionExecutorKey == null) {
			return "";
		}
		else {
			return _objectActionExecutorKey;
		}
	}

	@Override
	public void setObjectActionExecutorKey(String objectActionExecutorKey) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_objectActionExecutorKey = objectActionExecutorKey;
	}

	@JSON
	@Override
	public String getObjectActionTriggerKey() {
		if (_objectActionTriggerKey == null) {
			return "";
		}
		else {
			return _objectActionTriggerKey;
		}
	}

	@Override
	public void setObjectActionTriggerKey(String objectActionTriggerKey) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_objectActionTriggerKey = objectActionTriggerKey;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalObjectActionTriggerKey() {
		return getColumnOriginalValue("objectActionTriggerKey");
	}

	@JSON
	@Override
	public String getParameters() {
		if (_parameters == null) {
			return "";
		}
		else {
			return _parameters;
		}
	}

	@Override
	public void setParameters(String parameters) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_parameters = parameters;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ObjectAction.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ObjectAction.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ObjectAction toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ObjectAction>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ObjectActionImpl objectActionImpl = new ObjectActionImpl();

		objectActionImpl.setMvccVersion(getMvccVersion());
		objectActionImpl.setUuid(getUuid());
		objectActionImpl.setObjectActionId(getObjectActionId());
		objectActionImpl.setCompanyId(getCompanyId());
		objectActionImpl.setUserId(getUserId());
		objectActionImpl.setUserName(getUserName());
		objectActionImpl.setCreateDate(getCreateDate());
		objectActionImpl.setModifiedDate(getModifiedDate());
		objectActionImpl.setObjectDefinitionId(getObjectDefinitionId());
		objectActionImpl.setActive(isActive());
		objectActionImpl.setConditionExpression(getConditionExpression());
		objectActionImpl.setDescription(getDescription());
		objectActionImpl.setName(getName());
		objectActionImpl.setObjectActionExecutorKey(
			getObjectActionExecutorKey());
		objectActionImpl.setObjectActionTriggerKey(getObjectActionTriggerKey());
		objectActionImpl.setParameters(getParameters());

		objectActionImpl.resetOriginalValues();

		return objectActionImpl;
	}

	@Override
	public ObjectAction cloneWithOriginalValues() {
		ObjectActionImpl objectActionImpl = new ObjectActionImpl();

		objectActionImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		objectActionImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		objectActionImpl.setObjectActionId(
			this.<Long>getColumnOriginalValue("objectActionId"));
		objectActionImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		objectActionImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		objectActionImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		objectActionImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		objectActionImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		objectActionImpl.setObjectDefinitionId(
			this.<Long>getColumnOriginalValue("objectDefinitionId"));
		objectActionImpl.setActive(
			this.<Boolean>getColumnOriginalValue("active_"));
		objectActionImpl.setConditionExpression(
			this.<String>getColumnOriginalValue("conditionExpression"));
		objectActionImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		objectActionImpl.setName(this.<String>getColumnOriginalValue("name"));
		objectActionImpl.setObjectActionExecutorKey(
			this.<String>getColumnOriginalValue("objectActionExecutorKey"));
		objectActionImpl.setObjectActionTriggerKey(
			this.<String>getColumnOriginalValue("objectActionTriggerKey"));
		objectActionImpl.setParameters(
			this.<String>getColumnOriginalValue("parameters"));

		return objectActionImpl;
	}

	@Override
	public int compareTo(ObjectAction objectAction) {
		long primaryKey = objectAction.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ObjectAction)) {
			return false;
		}

		ObjectAction objectAction = (ObjectAction)object;

		long primaryKey = objectAction.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ObjectAction> toCacheModel() {
		ObjectActionCacheModel objectActionCacheModel =
			new ObjectActionCacheModel();

		objectActionCacheModel.mvccVersion = getMvccVersion();

		objectActionCacheModel.uuid = getUuid();

		String uuid = objectActionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			objectActionCacheModel.uuid = null;
		}

		objectActionCacheModel.objectActionId = getObjectActionId();

		objectActionCacheModel.companyId = getCompanyId();

		objectActionCacheModel.userId = getUserId();

		objectActionCacheModel.userName = getUserName();

		String userName = objectActionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			objectActionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			objectActionCacheModel.createDate = createDate.getTime();
		}
		else {
			objectActionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			objectActionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			objectActionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		objectActionCacheModel.objectDefinitionId = getObjectDefinitionId();

		objectActionCacheModel.active = isActive();

		objectActionCacheModel.conditionExpression = getConditionExpression();

		String conditionExpression = objectActionCacheModel.conditionExpression;

		if ((conditionExpression != null) &&
			(conditionExpression.length() == 0)) {

			objectActionCacheModel.conditionExpression = null;
		}

		objectActionCacheModel.description = getDescription();

		String description = objectActionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			objectActionCacheModel.description = null;
		}

		objectActionCacheModel.name = getName();

		String name = objectActionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			objectActionCacheModel.name = null;
		}

		objectActionCacheModel.objectActionExecutorKey =
			getObjectActionExecutorKey();

		String objectActionExecutorKey =
			objectActionCacheModel.objectActionExecutorKey;

		if ((objectActionExecutorKey != null) &&
			(objectActionExecutorKey.length() == 0)) {

			objectActionCacheModel.objectActionExecutorKey = null;
		}

		objectActionCacheModel.objectActionTriggerKey =
			getObjectActionTriggerKey();

		String objectActionTriggerKey =
			objectActionCacheModel.objectActionTriggerKey;

		if ((objectActionTriggerKey != null) &&
			(objectActionTriggerKey.length() == 0)) {

			objectActionCacheModel.objectActionTriggerKey = null;
		}

		objectActionCacheModel.parameters = getParameters();

		String parameters = objectActionCacheModel.parameters;

		if ((parameters != null) && (parameters.length() == 0)) {
			objectActionCacheModel.parameters = null;
		}

		return objectActionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ObjectAction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ObjectAction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ObjectAction, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((ObjectAction)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ObjectAction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ObjectAction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ObjectAction, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ObjectAction)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ObjectAction>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					ObjectAction.class, ModelWrapper.class);

	}

	private long _mvccVersion;
	private String _uuid;
	private long _objectActionId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _objectDefinitionId;
	private boolean _active;
	private String _conditionExpression;
	private String _description;
	private String _name;
	private String _objectActionExecutorKey;
	private String _objectActionTriggerKey;
	private String _parameters;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ObjectAction, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ObjectAction)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("objectActionId", _objectActionId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("objectDefinitionId", _objectDefinitionId);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("conditionExpression", _conditionExpression);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put(
			"objectActionExecutorKey", _objectActionExecutorKey);
		_columnOriginalValues.put(
			"objectActionTriggerKey", _objectActionTriggerKey);
		_columnOriginalValues.put("parameters", _parameters);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("active_", "active");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("uuid_", 2L);

		columnBitmasks.put("objectActionId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("objectDefinitionId", 256L);

		columnBitmasks.put("active_", 512L);

		columnBitmasks.put("conditionExpression", 1024L);

		columnBitmasks.put("description", 2048L);

		columnBitmasks.put("name", 4096L);

		columnBitmasks.put("objectActionExecutorKey", 8192L);

		columnBitmasks.put("objectActionTriggerKey", 16384L);

		columnBitmasks.put("parameters", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ObjectAction _escapedModel;

}
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

package com.liferay.commerce.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CommerceShipment service. Represents a row in the &quot;CommerceShipment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.model.impl.CommerceShipmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.model.impl.CommerceShipmentImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceShipment
 * @see com.liferay.commerce.model.impl.CommerceShipmentImpl
 * @see com.liferay.commerce.model.impl.CommerceShipmentModelImpl
 * @generated
 */
@ProviderType
public interface CommerceShipmentModel extends BaseModel<CommerceShipment>,
	GroupedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce shipment model instance should use the {@link CommerceShipment} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce shipment.
	 *
	 * @return the primary key of this commerce shipment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce shipment.
	 *
	 * @param primaryKey the primary key of this commerce shipment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the commerce shipment ID of this commerce shipment.
	 *
	 * @return the commerce shipment ID of this commerce shipment
	 */
	public long getCommerceShipmentId();

	/**
	 * Sets the commerce shipment ID of this commerce shipment.
	 *
	 * @param commerceShipmentId the commerce shipment ID of this commerce shipment
	 */
	public void setCommerceShipmentId(long commerceShipmentId);

	/**
	 * Returns the group ID of this commerce shipment.
	 *
	 * @return the group ID of this commerce shipment
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this commerce shipment.
	 *
	 * @param groupId the group ID of this commerce shipment
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this commerce shipment.
	 *
	 * @return the company ID of this commerce shipment
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce shipment.
	 *
	 * @param companyId the company ID of this commerce shipment
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce shipment.
	 *
	 * @return the user ID of this commerce shipment
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce shipment.
	 *
	 * @param userId the user ID of this commerce shipment
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce shipment.
	 *
	 * @return the user uuid of this commerce shipment
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce shipment.
	 *
	 * @param userUuid the user uuid of this commerce shipment
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce shipment.
	 *
	 * @return the user name of this commerce shipment
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce shipment.
	 *
	 * @param userName the user name of this commerce shipment
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce shipment.
	 *
	 * @return the create date of this commerce shipment
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce shipment.
	 *
	 * @param createDate the create date of this commerce shipment
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce shipment.
	 *
	 * @return the modified date of this commerce shipment
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce shipment.
	 *
	 * @param modifiedDate the modified date of this commerce shipment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the site group ID of this commerce shipment.
	 *
	 * @return the site group ID of this commerce shipment
	 */
	public long getSiteGroupId();

	/**
	 * Sets the site group ID of this commerce shipment.
	 *
	 * @param siteGroupId the site group ID of this commerce shipment
	 */
	public void setSiteGroupId(long siteGroupId);

	/**
	 * Returns the shipment organization ID of this commerce shipment.
	 *
	 * @return the shipment organization ID of this commerce shipment
	 */
	public long getShipmentOrganizationId();

	/**
	 * Sets the shipment organization ID of this commerce shipment.
	 *
	 * @param shipmentOrganizationId the shipment organization ID of this commerce shipment
	 */
	public void setShipmentOrganizationId(long shipmentOrganizationId);

	/**
	 * Returns the shipment user ID of this commerce shipment.
	 *
	 * @return the shipment user ID of this commerce shipment
	 */
	public long getShipmentUserId();

	/**
	 * Sets the shipment user ID of this commerce shipment.
	 *
	 * @param shipmentUserId the shipment user ID of this commerce shipment
	 */
	public void setShipmentUserId(long shipmentUserId);

	/**
	 * Returns the shipment user uuid of this commerce shipment.
	 *
	 * @return the shipment user uuid of this commerce shipment
	 */
	public String getShipmentUserUuid();

	/**
	 * Sets the shipment user uuid of this commerce shipment.
	 *
	 * @param shipmentUserUuid the shipment user uuid of this commerce shipment
	 */
	public void setShipmentUserUuid(String shipmentUserUuid);

	/**
	 * Returns the commerce address ID of this commerce shipment.
	 *
	 * @return the commerce address ID of this commerce shipment
	 */
	public long getCommerceAddressId();

	/**
	 * Sets the commerce address ID of this commerce shipment.
	 *
	 * @param commerceAddressId the commerce address ID of this commerce shipment
	 */
	public void setCommerceAddressId(long commerceAddressId);

	/**
	 * Returns the commerce shipping method ID of this commerce shipment.
	 *
	 * @return the commerce shipping method ID of this commerce shipment
	 */
	public long getCommerceShippingMethodId();

	/**
	 * Sets the commerce shipping method ID of this commerce shipment.
	 *
	 * @param commerceShippingMethodId the commerce shipping method ID of this commerce shipment
	 */
	public void setCommerceShippingMethodId(long commerceShippingMethodId);

	/**
	 * Returns the shipping option name of this commerce shipment.
	 *
	 * @return the shipping option name of this commerce shipment
	 */
	@AutoEscape
	public String getShippingOptionName();

	/**
	 * Sets the shipping option name of this commerce shipment.
	 *
	 * @param shippingOptionName the shipping option name of this commerce shipment
	 */
	public void setShippingOptionName(String shippingOptionName);

	/**
	 * Returns the carrier of this commerce shipment.
	 *
	 * @return the carrier of this commerce shipment
	 */
	@AutoEscape
	public String getCarrier();

	/**
	 * Sets the carrier of this commerce shipment.
	 *
	 * @param carrier the carrier of this commerce shipment
	 */
	public void setCarrier(String carrier);

	/**
	 * Returns the tracking number of this commerce shipment.
	 *
	 * @return the tracking number of this commerce shipment
	 */
	@AutoEscape
	public String getTrackingNumber();

	/**
	 * Sets the tracking number of this commerce shipment.
	 *
	 * @param trackingNumber the tracking number of this commerce shipment
	 */
	public void setTrackingNumber(String trackingNumber);

	/**
	 * Returns the status of this commerce shipment.
	 *
	 * @return the status of this commerce shipment
	 */
	public int getStatus();

	/**
	 * Sets the status of this commerce shipment.
	 *
	 * @param status the status of this commerce shipment
	 */
	public void setStatus(int status);

	/**
	 * Returns the shipping date of this commerce shipment.
	 *
	 * @return the shipping date of this commerce shipment
	 */
	public Date getShippingDate();

	/**
	 * Sets the shipping date of this commerce shipment.
	 *
	 * @param shippingDate the shipping date of this commerce shipment
	 */
	public void setShippingDate(Date shippingDate);

	/**
	 * Returns the expected date of this commerce shipment.
	 *
	 * @return the expected date of this commerce shipment
	 */
	public Date getExpectedDate();

	/**
	 * Sets the expected date of this commerce shipment.
	 *
	 * @param expectedDate the expected date of this commerce shipment
	 */
	public void setExpectedDate(Date expectedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CommerceShipment commerceShipment);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceShipment> toCacheModel();

	@Override
	public CommerceShipment toEscapedModel();

	@Override
	public CommerceShipment toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
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

package com.liferay.commerce.discount.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.discount.model.CommerceDiscountUserSegmentRel;
import com.liferay.commerce.discount.service.CommerceDiscountUserSegmentRelLocalService;
import com.liferay.commerce.discount.service.persistence.CommerceDiscountPersistence;
import com.liferay.commerce.discount.service.persistence.CommerceDiscountRelPersistence;
import com.liferay.commerce.discount.service.persistence.CommerceDiscountRulePersistence;
import com.liferay.commerce.discount.service.persistence.CommerceDiscountUsageEntryPersistence;
import com.liferay.commerce.discount.service.persistence.CommerceDiscountUserSegmentRelPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce discount user segment rel local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.discount.service.impl.CommerceDiscountUserSegmentRelLocalServiceImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see com.liferay.commerce.discount.service.impl.CommerceDiscountUserSegmentRelLocalServiceImpl
 * @see com.liferay.commerce.discount.service.CommerceDiscountUserSegmentRelLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class CommerceDiscountUserSegmentRelLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CommerceDiscountUserSegmentRelLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.commerce.discount.service.CommerceDiscountUserSegmentRelLocalServiceUtil} to access the commerce discount user segment rel local service.
	 */

	/**
	 * Adds the commerce discount user segment rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceDiscountUserSegmentRel the commerce discount user segment rel
	 * @return the commerce discount user segment rel that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceDiscountUserSegmentRel addCommerceDiscountUserSegmentRel(
		CommerceDiscountUserSegmentRel commerceDiscountUserSegmentRel) {
		commerceDiscountUserSegmentRel.setNew(true);

		return commerceDiscountUserSegmentRelPersistence.update(commerceDiscountUserSegmentRel);
	}

	/**
	 * Creates a new commerce discount user segment rel with the primary key. Does not add the commerce discount user segment rel to the database.
	 *
	 * @param commerceDiscountUserSegmentRelId the primary key for the new commerce discount user segment rel
	 * @return the new commerce discount user segment rel
	 */
	@Override
	@Transactional(enabled = false)
	public CommerceDiscountUserSegmentRel createCommerceDiscountUserSegmentRel(
		long commerceDiscountUserSegmentRelId) {
		return commerceDiscountUserSegmentRelPersistence.create(commerceDiscountUserSegmentRelId);
	}

	/**
	 * Deletes the commerce discount user segment rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceDiscountUserSegmentRelId the primary key of the commerce discount user segment rel
	 * @return the commerce discount user segment rel that was removed
	 * @throws PortalException if a commerce discount user segment rel with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceDiscountUserSegmentRel deleteCommerceDiscountUserSegmentRel(
		long commerceDiscountUserSegmentRelId) throws PortalException {
		return commerceDiscountUserSegmentRelPersistence.remove(commerceDiscountUserSegmentRelId);
	}

	/**
	 * Deletes the commerce discount user segment rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceDiscountUserSegmentRel the commerce discount user segment rel
	 * @return the commerce discount user segment rel that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceDiscountUserSegmentRel deleteCommerceDiscountUserSegmentRel(
		CommerceDiscountUserSegmentRel commerceDiscountUserSegmentRel) {
		return commerceDiscountUserSegmentRelPersistence.remove(commerceDiscountUserSegmentRel);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CommerceDiscountUserSegmentRel.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commerceDiscountUserSegmentRelPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.discount.model.impl.CommerceDiscountUserSegmentRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return commerceDiscountUserSegmentRelPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.discount.model.impl.CommerceDiscountUserSegmentRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return commerceDiscountUserSegmentRelPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return commerceDiscountUserSegmentRelPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return commerceDiscountUserSegmentRelPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public CommerceDiscountUserSegmentRel fetchCommerceDiscountUserSegmentRel(
		long commerceDiscountUserSegmentRelId) {
		return commerceDiscountUserSegmentRelPersistence.fetchByPrimaryKey(commerceDiscountUserSegmentRelId);
	}

	/**
	 * Returns the commerce discount user segment rel with the primary key.
	 *
	 * @param commerceDiscountUserSegmentRelId the primary key of the commerce discount user segment rel
	 * @return the commerce discount user segment rel
	 * @throws PortalException if a commerce discount user segment rel with the primary key could not be found
	 */
	@Override
	public CommerceDiscountUserSegmentRel getCommerceDiscountUserSegmentRel(
		long commerceDiscountUserSegmentRelId) throws PortalException {
		return commerceDiscountUserSegmentRelPersistence.findByPrimaryKey(commerceDiscountUserSegmentRelId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(commerceDiscountUserSegmentRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommerceDiscountUserSegmentRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceDiscountUserSegmentRelId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(commerceDiscountUserSegmentRelLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CommerceDiscountUserSegmentRel.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceDiscountUserSegmentRelId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(commerceDiscountUserSegmentRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommerceDiscountUserSegmentRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceDiscountUserSegmentRelId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return commerceDiscountUserSegmentRelLocalService.deleteCommerceDiscountUserSegmentRel((CommerceDiscountUserSegmentRel)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return commerceDiscountUserSegmentRelPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the commerce discount user segment rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.commerce.discount.model.impl.CommerceDiscountUserSegmentRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce discount user segment rels
	 * @param end the upper bound of the range of commerce discount user segment rels (not inclusive)
	 * @return the range of commerce discount user segment rels
	 */
	@Override
	public List<CommerceDiscountUserSegmentRel> getCommerceDiscountUserSegmentRels(
		int start, int end) {
		return commerceDiscountUserSegmentRelPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of commerce discount user segment rels.
	 *
	 * @return the number of commerce discount user segment rels
	 */
	@Override
	public int getCommerceDiscountUserSegmentRelsCount() {
		return commerceDiscountUserSegmentRelPersistence.countAll();
	}

	/**
	 * Updates the commerce discount user segment rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commerceDiscountUserSegmentRel the commerce discount user segment rel
	 * @return the commerce discount user segment rel that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceDiscountUserSegmentRel updateCommerceDiscountUserSegmentRel(
		CommerceDiscountUserSegmentRel commerceDiscountUserSegmentRel) {
		return commerceDiscountUserSegmentRelPersistence.update(commerceDiscountUserSegmentRel);
	}

	/**
	 * Returns the commerce discount local service.
	 *
	 * @return the commerce discount local service
	 */
	public com.liferay.commerce.discount.service.CommerceDiscountLocalService getCommerceDiscountLocalService() {
		return commerceDiscountLocalService;
	}

	/**
	 * Sets the commerce discount local service.
	 *
	 * @param commerceDiscountLocalService the commerce discount local service
	 */
	public void setCommerceDiscountLocalService(
		com.liferay.commerce.discount.service.CommerceDiscountLocalService commerceDiscountLocalService) {
		this.commerceDiscountLocalService = commerceDiscountLocalService;
	}

	/**
	 * Returns the commerce discount persistence.
	 *
	 * @return the commerce discount persistence
	 */
	public CommerceDiscountPersistence getCommerceDiscountPersistence() {
		return commerceDiscountPersistence;
	}

	/**
	 * Sets the commerce discount persistence.
	 *
	 * @param commerceDiscountPersistence the commerce discount persistence
	 */
	public void setCommerceDiscountPersistence(
		CommerceDiscountPersistence commerceDiscountPersistence) {
		this.commerceDiscountPersistence = commerceDiscountPersistence;
	}

	/**
	 * Returns the commerce discount rel local service.
	 *
	 * @return the commerce discount rel local service
	 */
	public com.liferay.commerce.discount.service.CommerceDiscountRelLocalService getCommerceDiscountRelLocalService() {
		return commerceDiscountRelLocalService;
	}

	/**
	 * Sets the commerce discount rel local service.
	 *
	 * @param commerceDiscountRelLocalService the commerce discount rel local service
	 */
	public void setCommerceDiscountRelLocalService(
		com.liferay.commerce.discount.service.CommerceDiscountRelLocalService commerceDiscountRelLocalService) {
		this.commerceDiscountRelLocalService = commerceDiscountRelLocalService;
	}

	/**
	 * Returns the commerce discount rel persistence.
	 *
	 * @return the commerce discount rel persistence
	 */
	public CommerceDiscountRelPersistence getCommerceDiscountRelPersistence() {
		return commerceDiscountRelPersistence;
	}

	/**
	 * Sets the commerce discount rel persistence.
	 *
	 * @param commerceDiscountRelPersistence the commerce discount rel persistence
	 */
	public void setCommerceDiscountRelPersistence(
		CommerceDiscountRelPersistence commerceDiscountRelPersistence) {
		this.commerceDiscountRelPersistence = commerceDiscountRelPersistence;
	}

	/**
	 * Returns the commerce discount rule local service.
	 *
	 * @return the commerce discount rule local service
	 */
	public com.liferay.commerce.discount.service.CommerceDiscountRuleLocalService getCommerceDiscountRuleLocalService() {
		return commerceDiscountRuleLocalService;
	}

	/**
	 * Sets the commerce discount rule local service.
	 *
	 * @param commerceDiscountRuleLocalService the commerce discount rule local service
	 */
	public void setCommerceDiscountRuleLocalService(
		com.liferay.commerce.discount.service.CommerceDiscountRuleLocalService commerceDiscountRuleLocalService) {
		this.commerceDiscountRuleLocalService = commerceDiscountRuleLocalService;
	}

	/**
	 * Returns the commerce discount rule persistence.
	 *
	 * @return the commerce discount rule persistence
	 */
	public CommerceDiscountRulePersistence getCommerceDiscountRulePersistence() {
		return commerceDiscountRulePersistence;
	}

	/**
	 * Sets the commerce discount rule persistence.
	 *
	 * @param commerceDiscountRulePersistence the commerce discount rule persistence
	 */
	public void setCommerceDiscountRulePersistence(
		CommerceDiscountRulePersistence commerceDiscountRulePersistence) {
		this.commerceDiscountRulePersistence = commerceDiscountRulePersistence;
	}

	/**
	 * Returns the commerce discount usage entry local service.
	 *
	 * @return the commerce discount usage entry local service
	 */
	public com.liferay.commerce.discount.service.CommerceDiscountUsageEntryLocalService getCommerceDiscountUsageEntryLocalService() {
		return commerceDiscountUsageEntryLocalService;
	}

	/**
	 * Sets the commerce discount usage entry local service.
	 *
	 * @param commerceDiscountUsageEntryLocalService the commerce discount usage entry local service
	 */
	public void setCommerceDiscountUsageEntryLocalService(
		com.liferay.commerce.discount.service.CommerceDiscountUsageEntryLocalService commerceDiscountUsageEntryLocalService) {
		this.commerceDiscountUsageEntryLocalService = commerceDiscountUsageEntryLocalService;
	}

	/**
	 * Returns the commerce discount usage entry persistence.
	 *
	 * @return the commerce discount usage entry persistence
	 */
	public CommerceDiscountUsageEntryPersistence getCommerceDiscountUsageEntryPersistence() {
		return commerceDiscountUsageEntryPersistence;
	}

	/**
	 * Sets the commerce discount usage entry persistence.
	 *
	 * @param commerceDiscountUsageEntryPersistence the commerce discount usage entry persistence
	 */
	public void setCommerceDiscountUsageEntryPersistence(
		CommerceDiscountUsageEntryPersistence commerceDiscountUsageEntryPersistence) {
		this.commerceDiscountUsageEntryPersistence = commerceDiscountUsageEntryPersistence;
	}

	/**
	 * Returns the commerce discount user segment rel local service.
	 *
	 * @return the commerce discount user segment rel local service
	 */
	public CommerceDiscountUserSegmentRelLocalService getCommerceDiscountUserSegmentRelLocalService() {
		return commerceDiscountUserSegmentRelLocalService;
	}

	/**
	 * Sets the commerce discount user segment rel local service.
	 *
	 * @param commerceDiscountUserSegmentRelLocalService the commerce discount user segment rel local service
	 */
	public void setCommerceDiscountUserSegmentRelLocalService(
		CommerceDiscountUserSegmentRelLocalService commerceDiscountUserSegmentRelLocalService) {
		this.commerceDiscountUserSegmentRelLocalService = commerceDiscountUserSegmentRelLocalService;
	}

	/**
	 * Returns the commerce discount user segment rel persistence.
	 *
	 * @return the commerce discount user segment rel persistence
	 */
	public CommerceDiscountUserSegmentRelPersistence getCommerceDiscountUserSegmentRelPersistence() {
		return commerceDiscountUserSegmentRelPersistence;
	}

	/**
	 * Sets the commerce discount user segment rel persistence.
	 *
	 * @param commerceDiscountUserSegmentRelPersistence the commerce discount user segment rel persistence
	 */
	public void setCommerceDiscountUserSegmentRelPersistence(
		CommerceDiscountUserSegmentRelPersistence commerceDiscountUserSegmentRelPersistence) {
		this.commerceDiscountUserSegmentRelPersistence = commerceDiscountUserSegmentRelPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.commerce.discount.model.CommerceDiscountUserSegmentRel",
			commerceDiscountUserSegmentRelLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.commerce.discount.model.CommerceDiscountUserSegmentRel");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceDiscountUserSegmentRelLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceDiscountUserSegmentRel.class;
	}

	protected String getModelClassName() {
		return CommerceDiscountUserSegmentRel.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = commerceDiscountUserSegmentRelPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.commerce.discount.service.CommerceDiscountLocalService.class)
	protected com.liferay.commerce.discount.service.CommerceDiscountLocalService commerceDiscountLocalService;
	@BeanReference(type = CommerceDiscountPersistence.class)
	protected CommerceDiscountPersistence commerceDiscountPersistence;
	@BeanReference(type = com.liferay.commerce.discount.service.CommerceDiscountRelLocalService.class)
	protected com.liferay.commerce.discount.service.CommerceDiscountRelLocalService commerceDiscountRelLocalService;
	@BeanReference(type = CommerceDiscountRelPersistence.class)
	protected CommerceDiscountRelPersistence commerceDiscountRelPersistence;
	@BeanReference(type = com.liferay.commerce.discount.service.CommerceDiscountRuleLocalService.class)
	protected com.liferay.commerce.discount.service.CommerceDiscountRuleLocalService commerceDiscountRuleLocalService;
	@BeanReference(type = CommerceDiscountRulePersistence.class)
	protected CommerceDiscountRulePersistence commerceDiscountRulePersistence;
	@BeanReference(type = com.liferay.commerce.discount.service.CommerceDiscountUsageEntryLocalService.class)
	protected com.liferay.commerce.discount.service.CommerceDiscountUsageEntryLocalService commerceDiscountUsageEntryLocalService;
	@BeanReference(type = CommerceDiscountUsageEntryPersistence.class)
	protected CommerceDiscountUsageEntryPersistence commerceDiscountUsageEntryPersistence;
	@BeanReference(type = CommerceDiscountUserSegmentRelLocalService.class)
	protected CommerceDiscountUserSegmentRelLocalService commerceDiscountUserSegmentRelLocalService;
	@BeanReference(type = CommerceDiscountUserSegmentRelPersistence.class)
	protected CommerceDiscountUserSegmentRelPersistence commerceDiscountUserSegmentRelPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}
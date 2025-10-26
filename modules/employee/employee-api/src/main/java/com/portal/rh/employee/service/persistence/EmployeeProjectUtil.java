/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.portal.rh.employee.model.EmployeeProject;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee project service. This utility wraps <code>com.portal.rh.employee.service.persistence.impl.EmployeeProjectPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProjectPersistence
 * @generated
 */
public class EmployeeProjectUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmployeeProject employeeProject) {
		getPersistence().clearCache(employeeProject);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EmployeeProject> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeProject> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeProject update(EmployeeProject employeeProject) {
		return getPersistence().update(employeeProject);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeProject update(
		EmployeeProject employeeProject, ServiceContext serviceContext) {

		return getPersistence().update(employeeProject, serviceContext);
	}

	/**
	 * Caches the employee project in the entity cache if it is enabled.
	 *
	 * @param employeeProject the employee project
	 */
	public static void cacheResult(EmployeeProject employeeProject) {
		getPersistence().cacheResult(employeeProject);
	}

	/**
	 * Caches the employee projects in the entity cache if it is enabled.
	 *
	 * @param employeeProjects the employee projects
	 */
	public static void cacheResult(List<EmployeeProject> employeeProjects) {
		getPersistence().cacheResult(employeeProjects);
	}

	/**
	 * Creates a new employee project with the primary key. Does not add the employee project to the database.
	 *
	 * @param employeeProjectId the primary key for the new employee project
	 * @return the new employee project
	 */
	public static EmployeeProject create(long employeeProjectId) {
		return getPersistence().create(employeeProjectId);
	}

	/**
	 * Removes the employee project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project that was removed
	 * @throws NoSuchEmployeeProjectException if a employee project with the primary key could not be found
	 */
	public static EmployeeProject remove(long employeeProjectId)
		throws com.portal.rh.employee.exception.NoSuchEmployeeProjectException {

		return getPersistence().remove(employeeProjectId);
	}

	public static EmployeeProject updateImpl(EmployeeProject employeeProject) {
		return getPersistence().updateImpl(employeeProject);
	}

	/**
	 * Returns the employee project with the primary key or throws a <code>NoSuchEmployeeProjectException</code> if it could not be found.
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project
	 * @throws NoSuchEmployeeProjectException if a employee project with the primary key could not be found
	 */
	public static EmployeeProject findByPrimaryKey(long employeeProjectId)
		throws com.portal.rh.employee.exception.NoSuchEmployeeProjectException {

		return getPersistence().findByPrimaryKey(employeeProjectId);
	}

	/**
	 * Returns the employee project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project, or <code>null</code> if a employee project with the primary key could not be found
	 */
	public static EmployeeProject fetchByPrimaryKey(long employeeProjectId) {
		return getPersistence().fetchByPrimaryKey(employeeProjectId);
	}

	/**
	 * Returns all the employee projects.
	 *
	 * @return the employee projects
	 */
	public static List<EmployeeProject> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee projects
	 * @param end the upper bound of the range of employee projects (not inclusive)
	 * @return the range of employee projects
	 */
	public static List<EmployeeProject> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee projects
	 * @param end the upper bound of the range of employee projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee projects
	 */
	public static List<EmployeeProject> findAll(
		int start, int end,
		OrderByComparator<EmployeeProject> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee projects
	 * @param end the upper bound of the range of employee projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee projects
	 */
	public static List<EmployeeProject> findAll(
		int start, int end,
		OrderByComparator<EmployeeProject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee projects from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee projects.
	 *
	 * @return the number of employee projects
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeProjectPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EmployeeProjectPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EmployeeProjectPersistence _persistence;

}
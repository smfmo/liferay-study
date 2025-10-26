/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeProjectLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProjectLocalService
 * @generated
 */
public class EmployeeProjectLocalServiceWrapper
	implements EmployeeProjectLocalService,
			   ServiceWrapper<EmployeeProjectLocalService> {

	public EmployeeProjectLocalServiceWrapper() {
		this(null);
	}

	public EmployeeProjectLocalServiceWrapper(
		EmployeeProjectLocalService employeeProjectLocalService) {

		_employeeProjectLocalService = employeeProjectLocalService;
	}

	/**
	 * Adds the employee project to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProject the employee project
	 * @return the employee project that was added
	 */
	@Override
	public com.portal.rh.employee.model.EmployeeProject addEmployeeProject(
		com.portal.rh.employee.model.EmployeeProject employeeProject) {

		return _employeeProjectLocalService.addEmployeeProject(employeeProject);
	}

	/**
	 * Creates a new employee project with the primary key. Does not add the employee project to the database.
	 *
	 * @param employeeProjectId the primary key for the new employee project
	 * @return the new employee project
	 */
	@Override
	public com.portal.rh.employee.model.EmployeeProject createEmployeeProject(
		long employeeProjectId) {

		return _employeeProjectLocalService.createEmployeeProject(
			employeeProjectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProjectLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee project from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProject the employee project
	 * @return the employee project that was removed
	 */
	@Override
	public com.portal.rh.employee.model.EmployeeProject deleteEmployeeProject(
		com.portal.rh.employee.model.EmployeeProject employeeProject) {

		return _employeeProjectLocalService.deleteEmployeeProject(
			employeeProject);
	}

	/**
	 * Deletes the employee project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project that was removed
	 * @throws PortalException if a employee project with the primary key could not be found
	 */
	@Override
	public com.portal.rh.employee.model.EmployeeProject deleteEmployeeProject(
			long employeeProjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProjectLocalService.deleteEmployeeProject(
			employeeProjectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProjectLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeProjectLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeProjectLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeProjectLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeProjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.portal.rh.employee.model.impl.EmployeeProjectModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeeProjectLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.portal.rh.employee.model.impl.EmployeeProjectModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeeProjectLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeProjectLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _employeeProjectLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.portal.rh.employee.model.EmployeeProject fetchEmployeeProject(
		long employeeProjectId) {

		return _employeeProjectLocalService.fetchEmployeeProject(
			employeeProjectId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeProjectLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee project with the primary key.
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project
	 * @throws PortalException if a employee project with the primary key could not be found
	 */
	@Override
	public com.portal.rh.employee.model.EmployeeProject getEmployeeProject(
			long employeeProjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProjectLocalService.getEmployeeProject(
			employeeProjectId);
	}

	/**
	 * Returns a range of all the employee projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.portal.rh.employee.model.impl.EmployeeProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee projects
	 * @param end the upper bound of the range of employee projects (not inclusive)
	 * @return the range of employee projects
	 */
	@Override
	public java.util.List<com.portal.rh.employee.model.EmployeeProject>
		getEmployeeProjects(int start, int end) {

		return _employeeProjectLocalService.getEmployeeProjects(start, end);
	}

	/**
	 * Returns the number of employee projects.
	 *
	 * @return the number of employee projects
	 */
	@Override
	public int getEmployeeProjectsCount() {
		return _employeeProjectLocalService.getEmployeeProjectsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeProjectLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeProjectLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProject the employee project
	 * @return the employee project that was updated
	 */
	@Override
	public com.portal.rh.employee.model.EmployeeProject updateEmployeeProject(
		com.portal.rh.employee.model.EmployeeProject employeeProject) {

		return _employeeProjectLocalService.updateEmployeeProject(
			employeeProject);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeProjectLocalService.getBasePersistence();
	}

	@Override
	public EmployeeProjectLocalService getWrappedService() {
		return _employeeProjectLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeProjectLocalService employeeProjectLocalService) {

		_employeeProjectLocalService = employeeProjectLocalService;
	}

	private EmployeeProjectLocalService _employeeProjectLocalService;

}
/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.portal.rh.employee.exception.NoSuchEmployeeProjectException;
import com.portal.rh.employee.model.EmployeeProject;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProjectUtil
 * @generated
 */
@ProviderType
public interface EmployeeProjectPersistence
	extends BasePersistence<EmployeeProject> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeProjectUtil} to access the employee project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the employee project in the entity cache if it is enabled.
	 *
	 * @param employeeProject the employee project
	 */
	public void cacheResult(EmployeeProject employeeProject);

	/**
	 * Caches the employee projects in the entity cache if it is enabled.
	 *
	 * @param employeeProjects the employee projects
	 */
	public void cacheResult(java.util.List<EmployeeProject> employeeProjects);

	/**
	 * Creates a new employee project with the primary key. Does not add the employee project to the database.
	 *
	 * @param employeeProjectId the primary key for the new employee project
	 * @return the new employee project
	 */
	public EmployeeProject create(long employeeProjectId);

	/**
	 * Removes the employee project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project that was removed
	 * @throws NoSuchEmployeeProjectException if a employee project with the primary key could not be found
	 */
	public EmployeeProject remove(long employeeProjectId)
		throws NoSuchEmployeeProjectException;

	public EmployeeProject updateImpl(EmployeeProject employeeProject);

	/**
	 * Returns the employee project with the primary key or throws a <code>NoSuchEmployeeProjectException</code> if it could not be found.
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project
	 * @throws NoSuchEmployeeProjectException if a employee project with the primary key could not be found
	 */
	public EmployeeProject findByPrimaryKey(long employeeProjectId)
		throws NoSuchEmployeeProjectException;

	/**
	 * Returns the employee project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeProjectId the primary key of the employee project
	 * @return the employee project, or <code>null</code> if a employee project with the primary key could not be found
	 */
	public EmployeeProject fetchByPrimaryKey(long employeeProjectId);

	/**
	 * Returns all the employee projects.
	 *
	 * @return the employee projects
	 */
	public java.util.List<EmployeeProject> findAll();

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
	public java.util.List<EmployeeProject> findAll(int start, int end);

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
	public java.util.List<EmployeeProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeProject>
			orderByComparator);

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
	public java.util.List<EmployeeProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeProject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee projects from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee projects.
	 *
	 * @return the number of employee projects
	 */
	public int countAll();

}
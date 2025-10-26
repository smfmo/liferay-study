/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeProject}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProject
 * @generated
 */
public class EmployeeProjectWrapper
	extends BaseModelWrapper<EmployeeProject>
	implements EmployeeProject, ModelWrapper<EmployeeProject> {

	public EmployeeProjectWrapper(EmployeeProject employeeProject) {
		super(employeeProject);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeProjectId", getEmployeeProjectId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("projectId", getProjectId());
		attributes.put("allocatedHours", getAllocatedHours());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeProjectId = (Long)attributes.get("employeeProjectId");

		if (employeeProjectId != null) {
			setEmployeeProjectId(employeeProjectId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Integer allocatedHours = (Integer)attributes.get("allocatedHours");

		if (allocatedHours != null) {
			setAllocatedHours(allocatedHours);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public EmployeeProject cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allocated hours of this employee project.
	 *
	 * @return the allocated hours of this employee project
	 */
	@Override
	public int getAllocatedHours() {
		return model.getAllocatedHours();
	}

	/**
	 * Returns the company ID of this employee project.
	 *
	 * @return the company ID of this employee project
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the employee ID of this employee project.
	 *
	 * @return the employee ID of this employee project
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee project ID of this employee project.
	 *
	 * @return the employee project ID of this employee project
	 */
	@Override
	public long getEmployeeProjectId() {
		return model.getEmployeeProjectId();
	}

	/**
	 * Returns the group ID of this employee project.
	 *
	 * @return the group ID of this employee project
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this employee project.
	 *
	 * @return the primary key of this employee project
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this employee project.
	 *
	 * @return the project ID of this employee project
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the allocated hours of this employee project.
	 *
	 * @param allocatedHours the allocated hours of this employee project
	 */
	@Override
	public void setAllocatedHours(int allocatedHours) {
		model.setAllocatedHours(allocatedHours);
	}

	/**
	 * Sets the company ID of this employee project.
	 *
	 * @param companyId the company ID of this employee project
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the employee ID of this employee project.
	 *
	 * @param employeeId the employee ID of this employee project
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee project ID of this employee project.
	 *
	 * @param employeeProjectId the employee project ID of this employee project
	 */
	@Override
	public void setEmployeeProjectId(long employeeProjectId) {
		model.setEmployeeProjectId(employeeProjectId);
	}

	/**
	 * Sets the group ID of this employee project.
	 *
	 * @param groupId the group ID of this employee project
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this employee project.
	 *
	 * @param primaryKey the primary key of this employee project
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this employee project.
	 *
	 * @param projectId the project ID of this employee project
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected EmployeeProjectWrapper wrap(EmployeeProject employeeProject) {
		return new EmployeeProjectWrapper(employeeProject);
	}

}
/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.service.impl;

import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.portal.rh.employee.exception.EmployeeNotFoundException;
import com.portal.rh.employee.model.*;
import com.portal.rh.employee.service.base.EmployeeProjectServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import java.util.List;

@Component(
	property = {
		"json.web.service.context.name=rh",
		"json.web.service.context.path=EmployeeProject"
	},
	service = AopService.class
)
public class EmployeeProjectServiceImpl extends EmployeeProjectServiceBaseImpl {

	public EmployeeProject addEmployeeToProject(long employeeId, long projectId, int horas,
												ServiceContext  serviceContext) throws PortalException {

		Employee employee = employeePersistence.fetchByPrimaryKey(employeeId);
		Project project = projectPersistence.fetchByPrimaryKey(projectId);

		if (employee == null) throw new EmployeeNotFoundException();
		if (project == null) throw new PortalException("Projeto inativo");

		long id = counterLocalService.increment();
		EmployeeProject rel = employeeProjectPersistence.create(id);

		rel.setEmployeeId(employeeId);
		rel.setProjectId(projectId);
		rel.setAllocatedHours(horas);
		rel.setGroupId(serviceContext.getScopeGroupId());
		rel.setCompanyId(serviceContext.getCompanyId());

		return employeeProjectPersistence.update(rel);
	}

	public List<Project> getProjectsByEmployee(long employeeId) {
		DSLQuery query = DSLQueryFactoryUtil
				.select(ProjectTable.INSTANCE)
				.from(ProjectTable.INSTANCE)
				.innerJoinON(
						EmployeeProjectTable.INSTANCE,
						EmployeeProjectTable.INSTANCE.projectId.eq(ProjectTable.INSTANCE.projectId)
				)
				.where(EmployeeProjectTable.INSTANCE.employeeId.eq(employeeId));
		return projectPersistence.dslQuery(query);
	}
}
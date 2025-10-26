/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeProjectService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProjectService
 * @generated
 */
public class EmployeeProjectServiceWrapper
	implements EmployeeProjectService, ServiceWrapper<EmployeeProjectService> {

	public EmployeeProjectServiceWrapper() {
		this(null);
	}

	public EmployeeProjectServiceWrapper(
		EmployeeProjectService employeeProjectService) {

		_employeeProjectService = employeeProjectService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeProjectService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeProjectService getWrappedService() {
		return _employeeProjectService;
	}

	@Override
	public void setWrappedService(
		EmployeeProjectService employeeProjectService) {

		_employeeProjectService = employeeProjectService;
	}

	private EmployeeProjectService _employeeProjectService;

}
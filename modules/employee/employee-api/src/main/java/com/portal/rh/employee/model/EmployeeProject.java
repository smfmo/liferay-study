/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the EmployeeProject service. Represents a row in the &quot;RH_EmployeeProject&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProjectModel
 * @generated
 */
@ImplementationClassName(
	"com.portal.rh.employee.model.impl.EmployeeProjectImpl"
)
@ProviderType
public interface EmployeeProject extends EmployeeProjectModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.portal.rh.employee.model.impl.EmployeeProjectImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EmployeeProject, Long>
		EMPLOYEE_PROJECT_ID_ACCESSOR = new Accessor<EmployeeProject, Long>() {

			@Override
			public Long get(EmployeeProject employeeProject) {
				return employeeProject.getEmployeeProjectId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EmployeeProject> getTypeClass() {
				return EmployeeProject.class;
			}

		};

}
/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.portal.rh.employee.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class EmployeeNotFoundException extends PortalException {

	public EmployeeNotFoundException() {
	}

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}

	public EmployeeNotFoundException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public EmployeeNotFoundException(Throwable throwable) {
		super(throwable);
	}

}
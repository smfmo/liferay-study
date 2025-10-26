/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.portal.rh.employee.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class DepartmentInactiveException extends PortalException {

	public DepartmentInactiveException() {
	}

	public DepartmentInactiveException(String msg) {
		super(msg);
	}

	public DepartmentInactiveException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public DepartmentInactiveException(Throwable throwable) {
		super(throwable);
	}

}
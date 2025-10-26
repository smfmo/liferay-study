/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.service.impl;

import com.liferay.portal.aop.AopService;

import com.portal.rh.employee.service.base.DepartmentLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.portal.rh.employee.model.Department",
	service = AopService.class
)
public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {
}
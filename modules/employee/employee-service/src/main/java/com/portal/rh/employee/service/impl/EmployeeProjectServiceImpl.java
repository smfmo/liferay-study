/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.service.impl;

import com.liferay.portal.aop.AopService;

import com.portal.rh.employee.service.base.EmployeeProjectServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=rh",
		"json.web.service.context.path=EmployeeProject"
	},
	service = AopService.class
)
public class EmployeeProjectServiceImpl extends EmployeeProjectServiceBaseImpl {
}
/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;RH_EmployeeProject&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProject
 * @generated
 */
public class EmployeeProjectTable extends BaseTable<EmployeeProjectTable> {

	public static final EmployeeProjectTable INSTANCE =
		new EmployeeProjectTable();

	public final Column<EmployeeProjectTable, Long> employeeProjectId =
		createColumn(
			"employeeProjectId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeProjectTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeProjectTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeProjectTable, Integer> allocatedHours =
		createColumn(
			"allocatedHours", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeProjectTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeProjectTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmployeeProjectTable() {
		super("RH_EmployeeProject", EmployeeProjectTable::new);
	}

}
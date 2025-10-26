/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;RH_Department&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Department
 * @generated
 */
public class DepartmentTable extends BaseTable<DepartmentTable> {

	public static final DepartmentTable INSTANCE = new DepartmentTable();

	public final Column<DepartmentTable, Long> departmentId = createColumn(
		"departmentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DepartmentTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DepartmentTable() {
		super("RH_Department", DepartmentTable::new);
	}

}
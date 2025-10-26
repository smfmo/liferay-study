/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.portal.rh.employee.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.portal.rh.employee.model.EmployeeProject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EmployeeProject in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeProjectCacheModel
	implements CacheModel<EmployeeProject>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeProjectCacheModel)) {
			return false;
		}

		EmployeeProjectCacheModel employeeProjectCacheModel =
			(EmployeeProjectCacheModel)object;

		if (employeeProjectId == employeeProjectCacheModel.employeeProjectId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeProjectId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{employeeProjectId=");
		sb.append(employeeProjectId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", allocatedHours=");
		sb.append(allocatedHours);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeProject toEntityModel() {
		EmployeeProjectImpl employeeProjectImpl = new EmployeeProjectImpl();

		employeeProjectImpl.setEmployeeProjectId(employeeProjectId);
		employeeProjectImpl.setEmployeeId(employeeId);
		employeeProjectImpl.setProjectId(projectId);
		employeeProjectImpl.setAllocatedHours(allocatedHours);
		employeeProjectImpl.setGroupId(groupId);
		employeeProjectImpl.setCompanyId(companyId);

		employeeProjectImpl.resetOriginalValues();

		return employeeProjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeProjectId = objectInput.readLong();

		employeeId = objectInput.readLong();

		projectId = objectInput.readLong();

		allocatedHours = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeProjectId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(projectId);

		objectOutput.writeInt(allocatedHours);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
	}

	public long employeeProjectId;
	public long employeeId;
	public long projectId;
	public int allocatedHours;
	public long groupId;
	public long companyId;

}
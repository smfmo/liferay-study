package com.portal.rh.employee.service.impl;

import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.portal.rh.employee.exception.DepartmentInactiveException;
import com.portal.rh.employee.exception.EmployeeNotFoundException;
import com.portal.rh.employee.exception.InvalidEmailException;
import com.portal.rh.employee.model.Department;
import com.portal.rh.employee.model.Employee;
import com.portal.rh.employee.model.EmployeeTable;
import com.portal.rh.employee.service.base.EmployeeLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

@Component(
	property = "model.class.name=com.portal.rh.employee.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {

	@Override
	public Employee addEmployee(String fullName, String email, long departmentId,
								boolean active, ServiceContext serviceContext) throws PortalException {

		validate(fullName, email, departmentId);

		long id = counterLocalService.increment();
		Employee employee = employeePersistence.create(id);

		User user = userLocalService.getUser(serviceContext.getUserId());

		employee.setFullName(fullName);
		employee.setEmail(email);
		employee.setDepartmentId(departmentId);
		employee.setActive(active);

		employee.setGroupId(serviceContext.getScopeGroupId());
		employee.setCompanyId(serviceContext.getCompanyId());
		employee.setUserId(user.getUserId());
		employee.setUserName(user.getFullName());
		employee.setCreateDate(serviceContext.getCreateDate());
		employee.setModifiedDate(serviceContext.getModifiedDate());

		return employeePersistence.update(employee);
	}

	@Override
	public Employee update(long employeeId, String fullName, String email,
						   long departmentId, boolean active, ServiceContext serviceContext) throws PortalException {

		validate(fullName, email, departmentId);

		Employee employeeExisting = findById(employeeId);

		employeeExisting.setFullName(fullName);
		employeeExisting.setEmail(email);
		employeeExisting.setDepartmentId(departmentId);
		employeeExisting.setActive(active);
		employeeExisting.setModifiedDate(serviceContext.getModifiedDate());

		return employeePersistence.update(employeeExisting);
	}

	public Employee findById(long employeeId) throws EmployeeNotFoundException {
		Employee employee = employeePersistence.fetchByPrimaryKey(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException("Funcionário não encontrado");
		}
		return employee;
	}

	@Override
	public Employee deleteEmployee(long employeeId) throws EmployeeNotFoundException {
		Employee employee = findById(employeeId);
		return employeePersistence.remove(employee);
	}

	public List<Employee> getByDepartmentAndActive(long departmentId, boolean active) {
		return employeePersistence.findByDepartmentAndActive(departmentId, active);
	}

	@Override
	public List<Employee> getEmployeeByPosition(String position) {
		DynamicQuery query = dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("position", position))
				.add(RestrictionsFactoryUtil.eq("active", true));
		return dynamicQuery(query);
	}

	@Override
	public List<Employee> getEmployeesFromDepartment(long departmentId) {
		DSLQuery query = DSLQueryFactoryUtil.select(EmployeeTable.INSTANCE)
				.from(EmployeeTable.INSTANCE)
				.where(
						EmployeeTable.INSTANCE.departmentId.eq(departmentId)
								.and(EmployeeTable.INSTANCE.active.eq(true))
				);
		return employeePersistence.dslQuery(query);
	}

	private void validate(String name, String email, long departmentId)
			throws InvalidEmailException, DepartmentInactiveException {

		if (Validator.isNull(name)) {
			throw new InvalidEmailException("Nome não pode ser vazio");
		}
		if (!Validator.isEmailAddress(email)) {
			throw new InvalidEmailException("Email inválido");
		}
		Department department = departmentPersistence.fetchByPrimaryKey(departmentId);
		if (department == null) {
			throw new DepartmentInactiveException("Departamento inativo ou inexistente");
		}
	}
}
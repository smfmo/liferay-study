package com.portal.rh.employee.service.persistence;

import com.portal.rh.employee.model.Employee;
import java.util.List;

public interface EmployeeFinder {
    List<Employee> findActiveWithDepartment(boolean employeeActive, boolean departmentActive,
                                            String nameLike, int limit);
}

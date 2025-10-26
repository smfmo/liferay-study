package com.portal.rh.employee.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.portal.rh.employee.model.Employee;
import com.portal.rh.employee.model.impl.EmployeeImpl;
import com.portal.rh.employee.service.persistence.EmployeeFinder;
import org.osgi.service.component.annotations.Component;
import java.util.List;

@Component(
        service = EmployeeFinder.class
)
public class EmployeeFinderImpl extends EmployeeFinderBaseImpl implements EmployeeFinder {

    @Override
    public List<Employee> findActiveWithDepartment(boolean employeeActive, boolean departmentActive,
                                                   String nameLike, int limit) {
        Session session = null;

        try {
            session = openSession();

            String sql = CustomSQLUtil.get("com.portal.rh.employee.service.persistence.EmployeeFinder.findActiveWithDepartment");

            SQLQuery query = session.createSynchronizedSQLQuery(sql);
            query.addEntity("Employee", EmployeeImpl.class);

            query.setBoolean(0, employeeActive);
            query.setBoolean(1, departmentActive);
            query.setString(2, "%" + nameLike.toLowerCase() + "%");
            query.setInteger(3, limit);

            return (List<Employee>)  query.list();
        }
        catch (Exception e) {
            throw new SystemException("Erro ao executar query customizada", e);
        }
        finally {
            closeSession(session);
        }
    }
}

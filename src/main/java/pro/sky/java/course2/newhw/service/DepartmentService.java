package pro.sky.java.course2.newhw.service;

import pro.sky.java.course2.newhw.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeMaxSum(int department);

    Employee getEmployeeMinSum(int department);

    Collection<Employee> getEmployeeFor(int department);

    Map<Integer, List<Employee>> getEmployeesDepartment();

}

package pro.sky.java.course2.newhw.service;

import pro.sky.java.course2.newhw.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int department, int salary, int departmentId);

    Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getAll();
}

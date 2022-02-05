package pro.sky.java.course2.newhw.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.newhw.exception.EmployeeExistException;
import pro.sky.java.course2.newhw.exception.EmployeeNotFoundExemption;
import pro.sky.java.course2.newhw.model.Employee;
import pro.sky.java.course2.newhw.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);
        return add(employee1);
    }

    @Override
    public Employee add(Employee employee) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            throw new EmployeeExistException();
        }
        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);
        return remove(employee1);
    }

    @Override
    public Employee remove(Employee employee) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            throw new EmployeeExistException();
        }
        employees.remove(key, employee); {
            throw new EmployeeNotFoundExemption();
        }
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        Employee employee = employees.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundExemption();
        }
        return employee;
    }

    @Override
    public Collection<Employee> getAll() {
        return Set.copyOf(employees.values());
    }

    private String getKey(Employee employee) {
        return getKey(employee.getFirstName(), employee.getLastName());
    }

    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}
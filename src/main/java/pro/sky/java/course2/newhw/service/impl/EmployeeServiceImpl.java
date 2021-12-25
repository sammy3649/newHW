package pro.sky.java.course2.newhw.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.newhw.exception.EmployeeExistException;
import pro.sky.java.course2.newhw.exception.EmployeeNotFoundExemption;
import pro.sky.java.course2.newhw.model.Employee;
import pro.sky.java.course2.newhw.service.EmployeeService;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Set<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashSet<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);
        return add(employee1);
    }

    @Override
    public Employee add(Employee employee) {
        if (!employees.add(employee)) {
            throw new EmployeeExistException();
        }
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);
        return remove(employee1);
    }

    @Override
    public Employee remove(Employee employee) {
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundExemption();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundExemption();
        }
        return employee;
    }

    @Override
    public Collection<Employee> getAll() {
        return Set.copyOf(employees);
    }
}
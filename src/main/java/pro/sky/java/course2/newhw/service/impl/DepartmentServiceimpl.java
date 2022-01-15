package pro.sky.java.course2.newhw.service.impl;

import pro.sky.java.course2.newhw.exception.EmployeeNotFoundExemption;
import pro.sky.java.course2.newhw.model.Employee;
import pro.sky.java.course2.newhw.service.DepartmentService;
import pro.sky.java.course2.newhw.service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServiceimpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceimpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeMaxSum(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.isInDepartment(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundExemption());
    }

    @Override
    public Employee getEmployeeMinSum(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.isInDepartment(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundExemption());
    }

    @Override
    public Collection<Employee> getEmployeeFor(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.isInDepartment(department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesDepartment() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

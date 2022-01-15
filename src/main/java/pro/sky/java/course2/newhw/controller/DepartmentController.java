package pro.sky.java.course2.newhw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.newhw.model.Employee;
import pro.sky.java.course2.newhw.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min")
    Employee getEmployeeMinSum(@RequestParam int department, @RequestParam int departmentId) {
        return departmentService.getEmployeeMinSum(department);
    }

    @GetMapping("/max")
    Employee getEmployeeMaxSum(@RequestParam int department, @RequestParam int departmentId) {
        return departmentService.getEmployeeMaxSum(department);
    }

    @GetMapping("/all")
    Map<Integer, List<Employee>> getEmployeesDepartment() {
        return departmentService.getEmployeesDepartment();
    }

    @GetMapping("/all")
    Collection<Employee> getEmployeeFor(@RequestParam int department, int departmentId) {
        return departmentService.getEmployeeFor(department);
    }

}





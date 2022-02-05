package pro.sky.java.course2.newhw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.newhw.exception.EmployeeNotFoundExemption;
import pro.sky.java.course2.newhw.model.Employee;
import pro.sky.java.course2.newhw.service.EmployeeService;
import pro.sky.java.course2.newhw.service.impl.DepartmentServiceimpl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.newhw.constants.EmployeeServiceTestConstants.*;
import static pro.sky.java.course2.newhw.constants.EmployeeServiceTestConstants.DEPARTMENT_ID2;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeServiceMock;
    @InjectMocks
    private DepartmentServiceimpl out;

    @BeforeEach
    public void initTest() {
        when(employeeServiceMock.getAll()).thenReturn(List.of(
                new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID),
                new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT, SALARY2, DEPARTMENT_ID2)
        ));
    }

    @Test
    public void getEmployeeMaxSumTest() {
        Employee actual = out.getEmployeeMaxSum(DEPARTMENT);
        Employee expected = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT, SALARY2, DEPARTMENT_ID2);
        assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeMaxSunExceptionTest() {
        assertThrowsExactly(EmployeeNotFoundExemption.class, () -> out.getEmployeeMaxSum(DEPARTMENT2));
    }
    @Test
    public void getEmployeeMinSumTest() {
        Employee actual = out.getEmployeeMinSum(DEPARTMENT);
        Employee expected = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeMinSunExceptionTest() {
        assertThrowsExactly(EmployeeNotFoundExemption.class, () -> out.getEmployeeMinSum(DEPARTMENT2));
    }

    @Test
    public void getEmployeeForTest() {
        Collection<Employee> actual = out.getEmployeeFor(DEPARTMENT);
        List<Employee> expected = List.of(
                new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID),
                new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT, SALARY2, DEPARTMENT_ID2)
        );
        assertEquals(actual.size(), expected.size());
        assertTrue(expected.containsAll(actual));
    }
    @Test
    public void getEmployeeForTest2() {
        Collection<Employee> actual = out.getEmployeeFor(DEPARTMENT2);
        List<Employee> expected = Collections.emptyList();
        assertEquals(expected, actual);    }

    @Test
    public void getEmployeeDepartmentTest() {
        Map<Integer, List<Employee>> actual = out.getEmployeesDepartment();
        Map<Integer, List<Employee>> expected = Map.of(DEPARTMENT, List.of(
                new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID),
                new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT, SALARY2, DEPARTMENT_ID2)
        ));
        assertEquals(expected, actual);
    }
}
package pro.sky.java.course2.newhw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.newhw.exception.EmployeeExistException;
import pro.sky.java.course2.newhw.exception.EmployeeNotFoundExemption;
import pro.sky.java.course2.newhw.model.Employee;
import pro.sky.java.course2.newhw.service.impl.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.newhw.constants.EmployeeServiceTestConstants.*;

public class EmployeeServiceImplTest {
    private EmployeeServiceImpl out;

    @BeforeEach
    public void initTest() {
        this.out = new EmployeeServiceImpl();
    }

    @Test
    public void addTest() {
        Employee testEmployee = out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        Employee testEmployee1 = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        assertEquals(testEmployee1, testEmployee);
    }

    @Test
    public void addTestEmployee() {
        Employee testEmployee = out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        Employee testEmployee1 = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        assertEquals(testEmployee1, testEmployee);
        testEmployee = out.add(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2, DEPARTMENT_ID2);
        testEmployee1 = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2, DEPARTMENT_ID2);
        assertEquals(testEmployee1, testEmployee);
    }

    @Test
    public void addTestEmployee2() {
        out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        assertThrowsExactly(EmployeeExistException.class, () -> out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID));
    }

    @Test
    public void removeTest() {
        out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        Employee actual = out.remove(FIRST_NAME, LAST_NAME);
        Employee expected = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        assertEquals(expected, actual);
    }

    @Test
    public void removeTest2() {
        assertThrowsExactly(EmployeeNotFoundExemption.class, () -> out.remove(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void findTest() {
        out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        Employee testEmployee = out.find(FIRST_NAME, LAST_NAME);
        Employee testEmployee1 = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        assertEquals(testEmployee1, testEmployee);
    }
    @Test
    public void findTest2() {
        assertThrowsExactly(EmployeeNotFoundExemption.class, () -> out.find(FIRST_NAME, LAST_NAME));
    }
    @Test
    public void getAllTest() {
        out.add(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID);
        out.add(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2, DEPARTMENT_ID2);
        Collection<Employee> actual = out.getAll();
        List<Employee> expected = List.of(
                new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT, SALARY, DEPARTMENT_ID),
                new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2, DEPARTMENT_ID2)
        );
        assertEquals(actual.size(), expected.size());
        assertTrue(expected.containsAll(actual));
    }
}
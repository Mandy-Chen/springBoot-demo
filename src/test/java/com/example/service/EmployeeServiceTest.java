package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {
    @Mock
    EmployeeRepository mockEmployeeRepository;
    @InjectMocks
    EmployeeService emplyeeService;

    @Test
    void should_return_employee_when_add_given_employee() {
        //given
        Employee emplyee = new Employee(1, "mandy");
        //when
        given(mockEmployeeRepository.save(emplyee)).willReturn(emplyee);
        Employee actualEmployee = emplyeeService.add(emplyee);
        //then
        assertEquals(emplyee, actualEmployee);
    }

    @Test
    void should_return_all_employees_when_get_all_employee_given_nothing() {
        //given
        Employee employeeFirst = new Employee(1, "mandy");
        Employee employeeSecond = new Employee(2, "chen");
        List<Employee> employees = Arrays.asList(employeeFirst, employeeSecond);
        given(mockEmployeeRepository.findAll()).willReturn(employees);
        //when
        List<Employee> actualEmployees = emplyeeService.getAllEmployees();
        //then
        assertEquals(employees, actualEmployees);
    }

    @Test
    void should_return_nothing_when_delete_employee_given_employee() {
        //given

        //when
        emplyeeService.deleteEmployee(1);
        //then
        verify(mockEmployeeRepository, times(1)).deleteById(1);
    }

    @Test
    void should_return_employee_when_update_employee_given_employee() {
        //given
        Employee employee = new Employee(1, "mandy");
        Employee updatedEmployee = new Employee(1, "chen");
        given(mockEmployeeRepository.findById(1)).willReturn(Optional.of(employee));
        given(mockEmployeeRepository.save(employee)).willReturn(updatedEmployee);
        //when
        Employee actualEmployee = emplyeeService.updateEmployee(1, employee);
        //then
        assertEquals(updatedEmployee, actualEmployee);
    }
}

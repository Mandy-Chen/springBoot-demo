package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

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
}

package com.example.service;

import com.example.model.Department;
import com.example.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class DepartmentServiceTest {
    @Mock
    DepartmentRepository mockDepartmentRepository;
    @InjectMocks
    DepartmentService departmentService;

    @Test
    void should_return_all_department_when_get_all_department_given_nothing() {
        //given
        List<Department> departments = new ArrayList<Department>();
        departments.add(new Department(1, "ITA", null));
        departments.add(new Department(2, "HR", null));
        given(mockDepartmentRepository.findAll()).willReturn(departments);
        //when
        List<Department> actualDepartments = departmentService.getAllDepartments();
        //then
        assertEquals(departments, actualDepartments);
    }

    @Test
    void should_return_department_when_add_department_given_department() {
        //given
        Department department = new Department(1, "ITA", null);
        given(mockDepartmentRepository.save(department)).willReturn(department);
        //when
        Department actualDepartment = departmentService.addDepartment(department);
        //then
        assertEquals(department, actualDepartment);
    }
}

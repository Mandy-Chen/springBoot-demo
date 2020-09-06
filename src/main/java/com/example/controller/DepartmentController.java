package com.example.controller;

import com.example.model.Department;
import com.example.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }
}

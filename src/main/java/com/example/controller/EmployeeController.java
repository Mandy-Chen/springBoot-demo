package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        System.out.println(employee.toString());
        return employeeService.add(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees().stream().collect(Collectors.toList());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "delete success!";
    }
}

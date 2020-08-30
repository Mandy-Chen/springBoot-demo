package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee add(Employee emplyee) {
        return employeeRepository.save(emplyee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Integer id, Employee updatedemployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        employee.setName(updatedemployee.getName());
        return employeeRepository.save(employee);
    }
}

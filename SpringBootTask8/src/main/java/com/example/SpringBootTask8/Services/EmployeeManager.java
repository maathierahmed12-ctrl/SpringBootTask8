package com.example.SpringBootTask8.Services;
import com.example.SpringBootTask8.Entities.Employee;
import com.example.SpringBootTask8.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class EmployeeManager {
@Autowired

    private EmployeeRepository employeeRepository;

    public List<Employee>getEmployee(){

        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employee.setName(employeeDetails.getName());


        return employeeRepository.save(employee);
    }

    public Employee patchEmployee(Long id, Map<String, Object> updates) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        if (updates.containsKey("name")) {
            employee.setName((String) updates.get("name"));
        }

        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}



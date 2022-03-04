package com.emreblblvv.cruddemo.rest;

import com.emreblblvv.cruddemo.entity.Employee;
import com.emreblblvv.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")
public class EmployeeRestController {
    // quick and dirty : inject the employee data
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    // expose `/employees` and return the list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee is not found -" +employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0); // i understand what process we do while set 0 to employee
        employeeService.save(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee== null){
            throw new RuntimeException("Employee is not found - "+employeeId);
        }
        employeeService.delete(employeeId);
        return "Deleted employee  id - "+employeeId;
    }
}

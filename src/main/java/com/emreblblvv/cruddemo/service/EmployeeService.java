package com.emreblblvv.cruddemo.service;

import com.emreblblvv.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {

    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save (Employee theEmployee);
    public void delete(int theId);
}

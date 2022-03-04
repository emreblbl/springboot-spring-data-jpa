package com.emreblblvv.cruddemo.service;

import com.emreblblvv.cruddemo.dao.EmployeeRepository;
import com.emreblblvv.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee employee = null;
        if(result.isPresent()) {
            employee = result.get();
            return employee;
        }
        else{
            throw  new RuntimeException("didn't find employee by id -"+theId);
        }
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void delete(int theId) {
        employeeRepository.deleteById(theId);
    }
}

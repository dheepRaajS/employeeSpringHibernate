package org.company.dashboard.service;

import org.company.dashboard.model.Employee;
import org.company.dashboard.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("employeeService")
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> findAllEmployee(){
        return (List<Employee>) repository.findAll();
    }

    public Employee addEmployee(Employee employee){
        return repository.save(employee);
    }

}

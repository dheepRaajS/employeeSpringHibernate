package org.company.dashboard.controller;

import jdk.jfr.ContentType;
import org.company.dashboard.model.Employee;
import org.company.dashboard.repository.EmployeeRepository;
import org.company.dashboard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("employeeController")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/api/getEmployees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(service.findAllEmployee(), HttpStatus.OK);
    }

    @PostMapping("/api/postNewEmployee")
    public ResponseEntity<String> addNewEmployee(@Validated @RequestBody Employee newEmployee){
        try{
            service.addEmployee(newEmployee);
            return new ResponseEntity("Success", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }

    }
}

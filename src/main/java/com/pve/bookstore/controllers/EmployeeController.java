package com.pve.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pve.bookstore.model.Employee;
import com.pve.bookstore.services.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService empService;


    
    @GetMapping(value = "/", produces = "application/json")
    public List<Employee> getEmployees() {
        return empService.list();
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json" )
    public Employee save(@RequestBody Employee emp) {
        return empService.save(emp);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Employee get(@PathVariable Long id) {
        return empService.get(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        return empService.update(id, emp);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void delete(@PathVariable Long id) {
        empService.delete(id);
    }

}

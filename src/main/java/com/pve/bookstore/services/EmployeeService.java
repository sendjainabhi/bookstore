package com.pve.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.pve.bookstore.model.Employee;

import com.pve.bookstore.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;

    public List<Employee> list() {
        return empRepository.findAll();
    }

    public Employee save(Employee emp) {
        return empRepository.save(emp);
    }

    public Employee get(Long id) {

        Optional<Employee> empOptional = empRepository.findById(id);
        if (empOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Employee Record not found");
        }
        return empOptional.get();
    }

    public Employee update(Long id, Employee emp) {
        Optional<Employee> empOptional = empRepository.findById(id);
        if (empOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Employee not found");
        }
        Employee existingEmp = empOptional.get();
        existingEmp.setName(emp.getName());
        return empRepository.save(existingEmp);
    }

    public void delete(Long id) {
        empRepository.deleteById(id);
    }

}

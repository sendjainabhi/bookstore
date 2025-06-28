package com.pve.bookstore.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pve.bookstore.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}

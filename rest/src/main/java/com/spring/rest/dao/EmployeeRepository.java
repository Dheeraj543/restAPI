package com.spring.rest.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

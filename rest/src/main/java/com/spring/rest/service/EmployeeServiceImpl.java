package com.spring.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.EmployeeRepository;
import com.spring.rest.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Employee deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee emp=employeeRepository.findById(id).get();
		employeeRepository.delete(emp);
		return emp;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> optEmp=employeeRepository.findById(id);
		if(!optEmp.isPresent()) {
			throw new RuntimeException("Employee not present");
		}
		Employee emp=optEmp.get();
		if(employee.getName()!=null) {
			emp.setName(employee.getName());
		}
		if(employee.getGender()!=null) {
			emp.setGender(employee.getGender());
		}
		if(employee.getAge()!=0) {
			emp.setAge(employee.getAge());
		}
		if(employee.getSalary()!=0) {
			emp.setSalary(employee.getSalary());
		}
		employeeRepository.save(emp);
		return employee;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not exist"));
	}

}


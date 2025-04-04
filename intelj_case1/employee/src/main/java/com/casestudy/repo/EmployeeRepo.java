package com.casestudy.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.model.Composite;
import com.casestudy.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Composite>{
	
	List<Employee> findByempId(int empId);
	List<Employee> findBymanagerId(int managerId);


}

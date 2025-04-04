package com.casestudy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.casestudy.model.Certificate;
import com.casestudy.model.Employee;
import com.casestudy.model.EmployeeList;
import com.casestudy.service.EmployeeServ;

@RestController
public class EmployeeCntr {

	@Autowired
	private EmployeeServ service;

	@GetMapping("/")
	public List<Employee> getEmployeeList(){
		return service.getList();
	}
	
	//to get a employee of particular empId
	@GetMapping("/emp/{empId}")
	public List<Certificate> getEmpById(@PathVariable int empId) {
		return service.getbyId(empId);
	}
	
	//to get the employee details based on his empId and certName
	@GetMapping("/employee/{empId}/{certName}")
	public Certificate getcertDetails(@PathVariable("empId") int empId,@PathVariable("certName") String certName)
	{
		return service.getCertificates(empId,certName);
	}
	
	//getting employee details based on the manId provided
	@GetMapping("/emp/mgr/{managerId}")
	public EmployeeList getMgr(@PathVariable("managerId") int managerId){
		return service.getManager(managerId);
	}
	
	//to get employee details under a particular manager  
	@GetMapping("/emp/mgr/{managerId}/{empId}")
	public List<Employee> getMgrEmp(@PathVariable("empId") int empId){
		return service.getEmp(empId);
	}
}

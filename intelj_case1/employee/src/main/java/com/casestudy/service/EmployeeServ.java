package com.casestudy.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.model.Certificate;
import com.casestudy.model.Employee;
import com.casestudy.model.Composite;
import com.casestudy.model.EmployeeList;
import com.casestudy.repo.EmployeeRepo;

@Service
public class EmployeeServ {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	Employee e;

	public List<Employee> getList(){
		return empRepo.findAll();
		
	}
	

		
	public List<Certificate> getbyId(int empId){
		EmployeeList empList=new EmployeeList();
		empList.setEmpList(empRepo.findAll());
		List<Employee> e=empList.getEmpList().stream().filter(n->n.getEmpId()==empId).collect(Collectors.toList());
		return e.stream().map(n->restTemplate.getForObject("http://CERTIFICATE-APP/get/{cerName}",Certificate.class,n.getCertificateName())).collect(Collectors.toList());
	}
	
	
	public Certificate getCertificates(int empId,String certificateName) {
        Employee e1= empRepo.findById(new Composite(empId,certificateName)).get();
        String certName = e1.getCertificateName();    
        Certificate certificate = restTemplate.getForObject("http://CERTIFICATE-APP/get/{cerName}", Certificate.class,certName);
        return certificate;   
	}
	
	public EmployeeList getManager(int managerId) {
		EmployeeList empList=new EmployeeList();
		empList.setEmpList(empRepo.findBymanagerId(managerId));
		return empList;
		
	}
	
	public List<Employee> getEmp(int empId){ 
		return empRepo.findByempId(empId);
	}
	
	
	
	
}

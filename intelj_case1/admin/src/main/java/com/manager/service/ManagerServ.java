package com.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.manager.model.EmployeeList;
import com.manager.model.Manager;

import com.manager.repo.ManagerRepo;


@Service
public class ManagerServ {
	
	@Autowired
	private ManagerRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public EmployeeList getManager(int manId) {
		EmployeeList e=restTemplate.getForObject("http://EMPLOYEE-APP/emp/mgr/{manId}", EmployeeList.class, manId);
		return e;
	}

	public List<Manager> all() {
		return repo.findAll();
	}
	

	
	


}

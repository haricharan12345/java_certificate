package com.manager.cntlr;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.manager.model.EmployeeList;
import com.manager.model.Manager;
import com.manager.service.ManagerServ;

@RestController
public class ManagerCont {
	
    @Autowired
	private ManagerServ serv;


  //getting all List of Managers	
	@GetMapping("/")
	   public List<Manager> allMngr()
	   {
		   return serv.all();
	   }
	
	//getting the list of employees under a manager
	
	@GetMapping("/mgr/{manId}")
	public EmployeeList getManager(@PathVariable("manId") int manId){
		return serv.getManager(manId);
	}

		
	
}

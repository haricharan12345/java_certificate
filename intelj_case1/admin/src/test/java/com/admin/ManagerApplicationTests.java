package com.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.manager.model.Employee;
import com.manager.model.EmployeeList;
import com.manager.model.Manager;
import com.manager.repo.ManagerRepo;
import com.manager.service.ManagerServ;

@SpringBootTest
public class ManagerApplicationTests {

    @InjectMocks
    private ManagerServ managerServ;

    @Mock
    private ManagerRepo managerRepo;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetManager() {
        int manId = 1;
        EmployeeList employeeList = new EmployeeList();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employeeList.setEmpList(employees);
        
        when(restTemplate.getForObject(anyString(), eq(EmployeeList.class), eq(manId))).thenReturn(employeeList);

        EmployeeList result = managerServ.getManager(manId);

        assertEquals(employees.size(), result.getEmpList().size());
    }

    @Test
    public void testAll() {
        List<Manager> managers = new ArrayList<>();
        managers.add(new Manager());
        managers.add(new Manager());
        when(managerRepo.findAll()).thenReturn(managers);

        List<Manager> result = managerServ.all();

        assertEquals(managers.size(), result.size());
    }
}




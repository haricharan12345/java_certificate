package com.casestudy.employee;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;


import com.casestudy.model.Certificate;
import com.casestudy.model.Composite;
import com.casestudy.model.Employee;
import com.casestudy.model.EmployeeList;
import com.casestudy.repo.EmployeeRepo;
import com.casestudy.service.EmployeeServ;

@SpringBootTest
class EmployeeApplicationTests {

	 @InjectMocks
	    private EmployeeServ employeeServ;

	    @Mock
	    private EmployeeRepo employeeRepo;

	    @Mock
	    private RestTemplate restTemplate;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    public void testGetList() {
	        List<Employee> employees = new ArrayList<Employee>();
	        employees.add(new Employee());
	        employees.add(new Employee());
	        when(employeeRepo.findAll()).thenReturn(employees);

	        List<Employee> result = employeeServ.getList();

	        assertEquals(2, result.size());
	    }

	    @Test
	    public void testGetbyId() {
	        int empId = 1;
	        List<Employee> employees = new ArrayList<>();
	        employees.add(new Employee());
	        when(employeeRepo.findAll()).thenReturn(employees);

	        List<Certificate> certificates = new ArrayList<>();
	        certificates.add(new Certificate());
	        when(restTemplate.getForObject(anyString(), eq(Certificate.class), anyString())).thenReturn(new Certificate());

	        List<Certificate> result = employeeServ.getbyId(empId);

	        assertEquals(1, result.size());
	    }

	    @Test
	    public void testGetCertificates() {
	        int empId = 1;
	        String certificateName = "Certificate1";
	        Composite composite = new Composite(empId, certificateName);
	        Employee employee = new Employee();
	        employee.setCertificateName(certificateName);

	        when(employeeRepo.findById(composite)).thenReturn(Optional.of(employee));

	        Certificate certificate = new Certificate();
	        when(restTemplate.getForObject(anyString(), eq(Certificate.class), eq(certificateName))).thenReturn(certificate);

	        Certificate result = employeeServ.getCertificates(empId, certificateName);

	        assertEquals(certificate, result);
	    }

	    @Test
	    public void testGetManager() {
	        int managerId = 1;
	        List<Employee> employees = new ArrayList<>();
	        employees.add(new Employee());
	        when(employeeRepo.findBymanagerId(managerId)).thenReturn(employees);

	        EmployeeList result = employeeServ.getManager(managerId);

	        assertEquals(employees.size(), result.getEmpList().size());
	    }

	    @Test
	    public void testGetEmp() {
	        int empId = 1;
	        List<Employee> employees = new ArrayList<>();
	        employees.add(new Employee());
	        when(employeeRepo.findByempId(empId)).thenReturn(employees);

	        List<Employee> result = employeeServ.getEmp(empId);

	        assertEquals(employees.size(), result.size());
	    }
}

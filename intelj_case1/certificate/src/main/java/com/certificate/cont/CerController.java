package com.certificate.cont;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.certificate.model.Certificate;
import com.certificate.service.CerService;



@RestController
public class CerController {

	
	@Autowired
	private CerService ser;
	
	@GetMapping("/")
	public List<Certificate> getAll(){		
	return 	ser.getAllcert();
	}
	
	@GetMapping("/get/{cerName}")
	public Certificate getByName(@PathVariable String cerName) {
		return ser.getByName(cerName);
		
	}
	
	@PostMapping("/post")
	public Certificate addCertificate(@RequestBody Certificate cer) {
		return ser.addCer(cer);
	}
	
	@PutMapping("/put")
	public Certificate updateAndSaveCer(@RequestBody Certificate cer) {
		return ser.updateCert(cer);
	}

	
	@DeleteMapping("/delete/{cerName}")
	public String deleteByCerName(@PathVariable String cerName) {
		ser.deleteByName(cerName);
		return "deleted";

	}
}
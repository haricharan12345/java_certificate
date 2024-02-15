package com.certificate.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certificate.exception.CertificateNotFoundException;
import com.certificate.exception.CertificateServiceException;
import com.certificate.model.Certificate;
import com.certificate.repo.CerRepository;


@Service
public class CerService {

	@Autowired
	private CerRepository repo;
	
	
	// to get all list of all certificate



public List<Certificate> getAllcert() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            throw new CertificateNotFoundException("Failed to retrieve all certificates", e);
        }
    }
	
	
//	to get the certificate for a particular certificateName
	public Certificate getByName(String cerName) {
	    try {
	        Optional<Certificate> certificate = repo.findById(cerName);
	        return certificate.get();
	    }  catch (Exception e) {
	        throw new CertificateServiceException("Failed to retrieve certificate by name: " + cerName);
	    }
	}

	
	//to add a new certificate
	public Certificate addCer(Certificate cer) {
        
            return repo.save(cer);
        
    }
	
	//to delete the certificate
	public String deleteByName(String cerName) {
		repo.deleteById(cerName);
		return "deleted";

	}
	
	//to update the certificate
	public Certificate updateCert(Certificate cer) {
		repo.save(cer);
		return cer;
	}


	
	
}

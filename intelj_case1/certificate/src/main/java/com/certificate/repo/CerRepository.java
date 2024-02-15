package com.certificate.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certificate.model.Certificate;

@Repository
public interface CerRepository extends JpaRepository<Certificate, String>
{
	
}

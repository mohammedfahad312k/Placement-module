package com.tns.certificate.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.certificate.entities.Certificate;
import com.tns.certificate.repository.CertificateRepository;

@Service
@Transactional
public class CertificateService 
{
	@Autowired
	private CertificateRepository repository;
	

	public List<Certificate> listAll() 
	{
		return repository.findAll();
	}


	public Certificate get(Integer id) 
	{
		
		return repository.findById(id).get();
	} 

	
    public void save(Certificate certificate) 
    {
    	 repository.save(certificate);
	}


	public void delete(Integer id) 
	{
		repository.deleteById(id);
	}

}

package com.tns.certificate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.certificate.entities.Certificate;
import com.tns.certificate.services.CertificateService;

@RestController
public class CertificateController 
{
	@Autowired
	private CertificateService service;
	
	// Retrieve All the rows from Database
	@GetMapping("/certificates")
	public List<Certificate> list()
	{
		return service.listAll();
		
	}
	
	// Retrieve Specific Records from Database 
	@GetMapping("/certificates/{id}")
	public ResponseEntity<Certificate> get (@PathVariable Integer id)
	{
		Certificate certificate = service.get (id);
		return new ResponseEntity<Certificate>(certificate, HttpStatus.OK);
		
	}
	
	// CREATE a row in the database
	@PostMapping("/certificates")
	public void add(@RequestBody Certificate certificate )
	{
		service.save(certificate);
	}
	
	//Update Operation - record in database
	@PutMapping("/certificates/{id}")
	public ResponseEntity<?> Update(@RequestBody Certificate certificate,@PathVariable Integer id)
	{
		try 
		{
			Certificate existcertificate = service.get(id);
			service.save(certificate);
			return new ResponseEntity<Certificate>(certificate, HttpStatus.OK);
		}
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Delete Operation
	@DeleteMapping("/certificates/{id}")
	public void delete(@PathVariable Integer id)
	{
		service.delete(id);
	}
	
	

}

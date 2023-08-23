package com.tns.admin.controllers;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.tns.admin.entities.Admin;
import com.tns.admin.services.AdminService;
import com.tns.admin.services.AdminServiceImpl;

@RestController
public class AdminController
{
	@Autowired
	private AdminService service;
	//Retrive all the rows from the database

	@GetMapping("/admins")
	public List<Admin> list()
	{
		return service.listAll();
	}
	//Retrieve specific records from database
	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> get (@PathVariable Long id)
	{
		try {	
			Admin admin =service.get(id);
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//create row in the database
	@PostMapping("/admins")
	public void add(@RequestBody Admin admin)
	{
		service.save(admin);
	}
	
	//update record in the database
	@PutMapping("/admins/{id}")
	public ResponseEntity<?> update(@RequestBody Admin admin,@PathVariable Long id)
	{
		try 
		{
			Admin updateAdmin = service.update(admin, id);
			service.save(updateAdmin);
			return new ResponseEntity<Admin>(updateAdmin,HttpStatus.OK);
		} 
		catch (NoSuchElementException e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//delete operation
	@DeleteMapping("/admins/{id}")
	public void delete(@PathVariable Long id)
	{
		service.delete(id);
	}
}

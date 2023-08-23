package com.tns.admin.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.admin.entities.Admin;
import com.tns.admin.repository.AdminRepository;


@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository repository;
	
	public List<Admin> listAll() 
	{
		return repository.findAll();
	}
	public void save(Admin admin) 
	{
		 repository.save(admin);
	}
	public Admin get(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	public Admin update(Admin admin, Long id) {
		Admin existadmin =repository.findById(id).get();
		existadmin.setPassword(admin.getPassword());
		existadmin.setName(admin.getName());
		return existadmin;
	}
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
}

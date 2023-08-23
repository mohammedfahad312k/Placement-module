package com.tns.admin.services;

import java.util.List;

import com.tns.admin.entities.Admin;

public interface AdminService{
	public List<Admin> listAll();
	public void save(Admin admin);
	public Admin get(Long id);
	public void delete(Long id);
	public Admin update(Admin admin, Long id);
	
}

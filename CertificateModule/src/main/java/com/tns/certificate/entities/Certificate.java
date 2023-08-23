 package com.tns.certificate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Certificate
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int year;
	private String college;
	
	public Certificate(int id, int year, String college) 
	{	
		this.id = id;
		this.year = year;
		this.college = college;
	}
	public Certificate() 
	{
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "certificate [id=" + id + ", year=" + year + ", college=" + college + "]";
	} 
	
	
	
	
    
}

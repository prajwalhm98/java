package com.example.Student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String name,  emailId;
	private int age, standard;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public Student(Long id, String name, String emailId, int age, int standard) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.age = age;
		this.standard = standard;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

	
}

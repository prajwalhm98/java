package com.example.Student.Response;

public class StudentResponse {

	private Long id;
	private String name;
	private int age;
	private String emailId;
	private int standard;

	private FeesResponse feesResponse;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public FeesResponse getFeesResponse() {
		return feesResponse;
	}

	public void setFeesResponse(FeesResponse feesResponse) {
		this.feesResponse = feesResponse;
	}

	public StudentResponse(Long id, String name, int age, String emailId, int standard, FeesResponse feesResponse) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.emailId = emailId;
		this.standard = standard;
		this.feesResponse = feesResponse;
	}

	public StudentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}

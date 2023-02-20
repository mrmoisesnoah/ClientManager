package com.project.usermanager.model;


public class User {
	private Integer id;
	private String name;
	private String cpf;
	private String email;
	private String country;
	
	public User() {
		
	}

	public User(Integer id, String name, String cpf, String email, String country) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.country = country;
	}

	public User(String name, String cpf, String email, String country) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

}

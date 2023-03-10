package com.project.usermanager.model;

import java.time.LocalDate;

public class User {
	private Integer id;
	private String name;
	private String cpf;
	private LocalDate dateOfBirth;
	private String email;
	private String phone;
	private String country;
	
	public User() {
		
	}

	public User(String name, String cpf, LocalDate dateOfBirth, String email, String phone, String country) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
		this.country = country;
	}

	public User(Integer id, String name, String cpf, LocalDate dateOfBirth, String email, String phone, String country) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

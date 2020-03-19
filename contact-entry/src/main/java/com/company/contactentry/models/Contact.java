package com.company.contactentry.models;

import java.util.Set;

public class Contact {
	
	private Long id;
	private Name name;
	private Address address;
	private Set<Phone> phone;
	private String email;
	
	public Contact() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Phone> getPhone() {
		return phone;
	}

	public void setPhone(Set<Phone> phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}


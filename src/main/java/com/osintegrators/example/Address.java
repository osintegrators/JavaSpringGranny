package com.osintegrators.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Address.findAll", query = "select a from Address a") })
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long _id;

	private String name;
	private String address;
	private String phone;
	private String email;

	public Address(String name, String address, String phoneNumber, String email) {
		this.name = name;
		this.address = address;
		this.phone = phoneNumber;
		this.email = email;
	}

	// ADDED Default Constructor Because of Build Errors in pom.xml
	public Address() {
	}

	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phoneNumber) {
		this.phone = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

package com.cgi.learning.servlets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
public class Registration_pojo {
	private String name, email, password, contact, bloodgroup, street, area, city, district;

	

	public Registration_pojo() {
		super();
	}

	
	public String getName() {
		return name;
	}

	public Registration_pojo(String name, String email, String password, String contact, String bloodgroup, String street,
			String area, String city, String district) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.bloodgroup = bloodgroup;
		this.street = street;
		this.area = area;
		this.city = city;
		this.district = district;
	}

	@Column(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	@Id
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "contact")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "bloodgroup")
	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	@Column(name = "street")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "area")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "district")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}

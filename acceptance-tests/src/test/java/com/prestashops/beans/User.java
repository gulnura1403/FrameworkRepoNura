package com.prestashops.beans;
// BEANS -> all 3 represent certain types, with getters/setters and fields
// POJO -> plain old java object
// MODEL 
public class User {
	
	String firstName;
	String lastName;
	String address;
	String company;
	String city;
	
	public User(String firstName, String lastName, String address, String company, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.company = company;
		this.city = city;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}

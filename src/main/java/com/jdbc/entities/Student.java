package com.jdbc.entities;

public class Student {
	
	private int id;
	private String name;
	private String phone;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "[  Student Id -> " + id + " | Name : " + name + ", Phone : " + phone + ", City=" + city + "  ]";
	}
	
	

}

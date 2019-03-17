package com.itechart.d10.java.is.contacts.dao.impl.entity;

import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;

public class Address extends BaseEntity implements IAddress{

	private String country;
	private String city;
	private String street;
	private String houseNumber;
	private Integer apartment;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public Integer getApartment() {
		return apartment;
	}
	public void setApartment(Integer apartment) {
		this.apartment = apartment;
	}
	
	
}

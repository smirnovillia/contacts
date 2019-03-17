package com.itechart.d10.java.is.contacts.dao.api.entity;

import com.itechart.d10.java.is.contacts.dao.api.base.IBaseEntity;

public interface IAddress extends IBaseEntity {

	String getCountry();

	void setCountry(String country);

	String getCity();

	void setCity(String city);

	String getStreet();

	void setStreet(String street);

	String getHouseNumber();

	void setHouseNumber(String houseNumber);

	Integer getApartment();

	void setApartment(Integer apartment);
}

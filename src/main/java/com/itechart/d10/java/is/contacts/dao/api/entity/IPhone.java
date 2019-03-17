package com.itechart.d10.java.is.contacts.dao.api.entity;

import com.itechart.d10.java.is.contacts.dao.api.base.IBaseEntity;
import com.itechart.d10.java.is.contacts.dao.api.enums.PhoneType;

public interface IPhone extends IBaseEntity {

	String getCountryCode();

	void setCountryCode(String countryCode);

	String getOperatorCode();

	void setOperatorCode(String operatorCode);

	String getPhoneNumber();

	void setPhoneNumber(String phoneNumber);

	PhoneType getPhoneType();

	void setPhoneType(PhoneType phoneType);

	String getComment();

	void setComment(String comment);
}

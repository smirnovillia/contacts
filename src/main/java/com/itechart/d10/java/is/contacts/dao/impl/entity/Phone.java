package com.itechart.d10.java.is.contacts.dao.impl.entity;

import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.dao.api.enums.PhoneType;

public class Phone extends BaseEntity implements IPhone{

	private IContact contact;
	private String countryCode;
	private String operatorCode;
	private String phoneNumber;
	private PhoneType phoneType;
	private String comment;
	

	public IContact getContact() {
		return contact;
	}

	public void setContact(IContact contact) {
		this.contact = contact;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

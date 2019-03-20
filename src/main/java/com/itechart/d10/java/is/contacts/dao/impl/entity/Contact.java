package com.itechart.d10.java.is.contacts.dao.impl.entity;

import java.util.Date;

import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.dao.api.enums.Gender;
import com.itechart.d10.java.is.contacts.dao.api.enums.MaritalStatus;

public class Contact extends BaseEntity implements IContact {

	private String firstName;
	private String midleName;
	private String lastName;
	private Date birthday;
	private Gender gender;
	private String citizenship;
	private MaritalStatus maritalStatus;
	private String website;
	private IWorkplace workplace;
	private IAddress address;
	private Date created;
	private Date updated;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidleName() {
		return midleName;
	}

	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public IWorkplace getWorkplace() {
		return workplace;
	}

	public void setWorkplace(IWorkplace workplace) {
		this.workplace = workplace;
	}

	public IAddress getAddress() {
		return address;
	}

	public void setAddress(IAddress address) {
		this.address = address;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}

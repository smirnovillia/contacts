package com.itechart.d10.java.is.contacts.dao.api.entity;

import java.util.Date;

import com.itechart.d10.java.is.contacts.dao.api.base.IBaseEntity;
import com.itechart.d10.java.is.contacts.dao.api.enums.Gender;
import com.itechart.d10.java.is.contacts.dao.api.enums.MaritalStatus;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Address;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Attachment;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Phone;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Workplace;

public interface IContact extends IBaseEntity{

	String getFirstName();

	void setFirstName(String firstName);

	String getMidleName();

	void setMidleName(String midleName);

	String getLastName();

	void setLastName(String lastName);

	Date getBirthday();

	void setBirthday(Date birthday);

	Gender getGender();

	void setGender(Gender gender);

	String getCitizenship();

	void setCitizenship(String citizenship);

	MaritalStatus getMaritalStatus();

	void setMaritalStatus(MaritalStatus maritalStatus);

	String getWebsite();

	void setWebsite(String website);

	Workplace getWorkplace();

	void setWorkplace(Workplace workplace);

	Address getAddress();

	void setAddress(Address address);

	Phone getPhone();

	void setPhone(Phone phone);

	Attachment getAttachment();

	void setAttachment(Attachment attachment);

	Date getCreated();

	void setCreated(Date created);

	Date getUpdated();

	void setUpdated(Date updated);
}

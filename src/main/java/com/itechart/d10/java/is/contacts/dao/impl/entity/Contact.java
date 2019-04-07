package com.itechart.d10.java.is.contacts.dao.impl.entity;

import java.util.Date;

import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
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
        private String email;
	private String company;
	private String country;
	private String city;
	private String street;
	private String houseNumber;
	private Integer apartment;
	private String zip;
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
        
        public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

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
	
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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
        
        public String getFullName(){
            StringBuilder sb = new StringBuilder();
            if(getMidleName() != null){
                sb.append(getFirstName()).append(" ").
                        append(getMidleName()).append(" ").
                        append(getLastName());
            } else {
                sb.append(getFirstName()).append(" ").
                        append(getLastName());
            }
            return sb.toString();
        }
        
        public String getFullAddress(){
            StringBuilder sb = new StringBuilder();
            sb.append(getZip()).append(" ").
                    append(getCountry()).append(" ").
                    append(getCity()).append(" ").
                    append(getStreet()).append(" ").
                    append(getHouseNumber()).append(" ").
                    append(getApartment()).append(" ");
            return sb.toString();
        }

}

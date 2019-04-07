package com.itechart.d10.java.is.contacts.dao.api.entity;

import java.util.Date;

import com.itechart.d10.java.is.contacts.dao.api.base.IBaseEntity;
import com.itechart.d10.java.is.contacts.dao.api.enums.Gender;
import com.itechart.d10.java.is.contacts.dao.api.enums.MaritalStatus;

public interface IContact extends IBaseEntity {

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

    String getEmail();

    void setEmail(String email);

    String getCompany();

    void setCompany(String company);

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

    String getZip();

    void setZip(String zip);

    Date getCreated();

    void setCreated(Date created);

    Date getUpdated();

    void setUpdated(Date updated);
    
    String getFullName();
    
    String getFullAddress();

}

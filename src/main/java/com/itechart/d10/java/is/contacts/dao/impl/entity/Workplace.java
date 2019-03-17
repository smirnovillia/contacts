package com.itechart.d10.java.is.contacts.dao.impl.entity;

import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;

public class Workplace extends BaseEntity implements IWorkplace{

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}

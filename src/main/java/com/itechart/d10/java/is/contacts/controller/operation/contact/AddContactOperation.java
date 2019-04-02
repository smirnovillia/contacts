package com.itechart.d10.java.is.contacts.controller.operation.contact;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.enums.Gender;
import com.itechart.d10.java.is.contacts.dao.api.enums.MaritalStatus;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;

public class AddContactOperation implements ICommand {
	
	
	private static AddContactOperation instance;

	private AddContactOperation() {
	}

	public static AddContactOperation getInstance() {
		if (instance == null) {
			instance = new AddContactOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final IContact entity = ContactServiceImpl.getInstance().createEntity();
		entity.setFirstName(request.getParameter("firstName"));
		entity.setMidleName(request.getParameter("midleName"));
		entity.setLastName(request.getParameter("lastName"));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String bDay = request.getParameter("birthday");
		Date birthday = null;
		try {
			birthday = dateFormat.parse(bDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		entity.setBirthday(birthday);
		
		entity.setGender(Gender.valueOf(request.getParameter("gender")));
		entity.setCitizenship(request.getParameter("citizenship"));
		entity.setMaritalStatus(MaritalStatus.valueOf(request.getParameter("maritalStatus")));
		entity.setWebsite(request.getParameter("website"));
		entity.setCountry(request.getParameter("website"));
		ContactServiceImpl.getInstance().save(entity);
		ListContactOperation.getInstance().execute(request, response);
	}

}

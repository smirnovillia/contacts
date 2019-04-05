package com.itechart.d10.java.is.contacts.controller.operation.phone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.dao.api.enums.PhoneType;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;
import com.itechart.d10.java.is.contacts.service.impl.PhoneServiceImpl;

public class SavePhoneOperation implements ICommand{
        
        private PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();
        private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
	
	private static SavePhoneOperation instance;

	private SavePhoneOperation() {
	}

	public static SavePhoneOperation getInstance() {
		if (instance == null) {
			instance = new SavePhoneOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final IPhone entity = phoneServiceImpl.createEntity();
		
		final IContact contact = contactServiceImpl.createEntity();
		if(request.getParameter("contactId") != null) {
			contact.setId(Integer.parseInt(request.getParameter("contactId")));
			entity.setContact(contact);
		}
		
		entity.setCountryCode(request.getParameter("countryCode"));
		entity.setOperatorCode(request.getParameter("operatorCode"));
		entity.setPhoneNumber(request.getParameter("phoneNumber"));
		entity.setPhoneType(PhoneType.valueOf(request.getParameter("phoneType")));
		entity.setComment(request.getParameter("comment"));
		
		phoneServiceImpl.save(entity);
		
	}

}

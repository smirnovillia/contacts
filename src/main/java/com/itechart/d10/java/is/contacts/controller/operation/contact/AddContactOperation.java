package com.itechart.d10.java.is.contacts.controller.operation.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.dao.api.enums.Gender;
import com.itechart.d10.java.is.contacts.dao.api.enums.MaritalStatus;
import com.itechart.d10.java.is.contacts.service.IAddressService;
import com.itechart.d10.java.is.contacts.service.IContactService;
import com.itechart.d10.java.is.contacts.service.IWorkplaceService;
import com.itechart.d10.java.is.contacts.service.impl.AddressServiceImpl;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;
import com.itechart.d10.java.is.contacts.service.impl.WorkplaceServiceImpl;

public class AddContactOperation implements ICommand {
	
	private IContactService contactService = new ContactServiceImpl();
	private IWorkplaceService workplaceService = new WorkplaceServiceImpl();
	private IAddressService addressService = new AddressServiceImpl();
	
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
		final IContact entity = contactService.createEntity();
		entity.setFirstName(request.getParameter("firstName"));
		entity.setMidleName(request.getParameter("midleName"));
		entity.setLastName(request.getParameter("lastName"));
		entity.setGender(Gender.valueOf(request.getParameter("gender")));
		entity.setCitizenship(request.getParameter("citizenship"));
		entity.setMaritalStatus(MaritalStatus.valueOf(request.getParameter("maritalStatus")));
		entity.setWebsite(request.getParameter("website"));
		final IWorkplace workplace = workplaceService.createEntity();
		if(request.getParameter("workplace") != null) {
			workplace.setId(Integer.parseInt(request.getParameter("workplace")));
			entity.setWorkplace(workplace);
		}
		
		final IAddress address = addressService.createEntity();
		if(request.getParameter("address") != null) {
			address.setId(Integer.parseInt(request.getParameter("address")));
			entity.setAddress(address);
		}
		
		
		contactService.save(entity);
	}

}

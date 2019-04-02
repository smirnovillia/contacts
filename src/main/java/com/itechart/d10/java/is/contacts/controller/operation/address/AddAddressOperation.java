package com.itechart.d10.java.is.contacts.controller.operation.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.controller.operation.contact.ListContactOperation;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.service.impl.AddressServiceImpl;

public class AddAddressOperation implements ICommand {

	private static AddAddressOperation instance;

	private AddAddressOperation() {
	}

	public static AddAddressOperation getInstance() {
		if (instance == null) {
			instance = new AddAddressOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		final IAddress entity = AddressServiceImpl.getInstance().createEntity();
		entity.setCountry(request.getParameter("country"));
		entity.setCity(request.getParameter("city"));
		entity.setStreet(request.getParameter("street"));
		entity.setHouseNumber(request.getParameter("houseNumber"));
		entity.setApartment(Integer.parseInt(request.getParameter("apartmnet")));
		
		AddressServiceImpl.getInstance().save(entity);
		
		ListAddressOperation.getInstance().execute(request, response);
	}

}

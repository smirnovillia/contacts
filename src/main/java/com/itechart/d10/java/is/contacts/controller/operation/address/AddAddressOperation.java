package com.itechart.d10.java.is.contacts.controller.operation.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.service.IAddressService;
import com.itechart.d10.java.is.contacts.service.impl.AddressServiceImpl;

public class AddAddressOperation implements ICommand {

	private IAddressService addressService = new AddressServiceImpl();
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
		
		final IAddress entity = addressService.createEntity();
		addressService.save(entity);
	}

}

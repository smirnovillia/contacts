package com.itechart.d10.java.is.contacts.controller.operation.address;

import com.itechart.d10.java.is.contacts.controller.util.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.service.IAddressService;
import com.itechart.d10.java.is.contacts.service.impl.AddressServiceImpl;

public class AddAddressOperation implements ICommand {
	
	private IAddressService addressService = new AddressServiceImpl();

	@Override
	public void execute() {
		final IAddress entity = addressService.createEntity();
		addressService.save(entity);
	}

}

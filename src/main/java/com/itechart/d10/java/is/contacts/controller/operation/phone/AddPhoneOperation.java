package com.itechart.d10.java.is.contacts.controller.operation.phone;

import com.itechart.d10.java.is.contacts.controller.util.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.service.IPhoneService;
import com.itechart.d10.java.is.contacts.service.impl.PhoneServiceImpl;

public class AddPhoneOperation implements ICommand{
	
	private IPhoneService phoneService = new PhoneServiceImpl();

	@Override
	public void execute() {
		final IPhone entity = phoneService.createEntity();
		phoneService.save(entity);
	}

}

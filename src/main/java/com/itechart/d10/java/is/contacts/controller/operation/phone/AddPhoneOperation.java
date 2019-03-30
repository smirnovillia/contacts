package com.itechart.d10.java.is.contacts.controller.operation.phone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.service.IPhoneService;
import com.itechart.d10.java.is.contacts.service.impl.PhoneServiceImpl;

public class AddPhoneOperation implements ICommand{
	
	private IPhoneService phoneService = new PhoneServiceImpl();
	
	private static AddPhoneOperation instance;

	private AddPhoneOperation() {
	}

	public static AddPhoneOperation getInstance() {
		if (instance == null) {
			instance = new AddPhoneOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final IPhone entity = phoneService.createEntity();
		phoneService.save(entity);
	}

}

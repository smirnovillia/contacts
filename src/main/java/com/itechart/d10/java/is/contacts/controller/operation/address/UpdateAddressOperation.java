package com.itechart.d10.java.is.contacts.controller.operation.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class UpdateAddressOperation implements ICommand {
	
	private static UpdateAddressOperation instance;

	private UpdateAddressOperation() {
	}

	public static UpdateAddressOperation getInstance() {
		if (instance == null) {
			instance = new UpdateAddressOperation();
		}
		return instance;
	}


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

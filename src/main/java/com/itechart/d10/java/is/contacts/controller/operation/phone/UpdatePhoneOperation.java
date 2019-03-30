package com.itechart.d10.java.is.contacts.controller.operation.phone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class UpdatePhoneOperation implements ICommand {
	
	private static UpdatePhoneOperation instance;

	private UpdatePhoneOperation() {
	}

	public static UpdatePhoneOperation getInstance() {
		if (instance == null) {
			instance = new UpdatePhoneOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

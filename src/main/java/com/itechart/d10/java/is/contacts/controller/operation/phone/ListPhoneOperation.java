package com.itechart.d10.java.is.contacts.controller.operation.phone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class ListPhoneOperation implements ICommand {
	
	private static ListPhoneOperation instance;

	private ListPhoneOperation() {
	}

	public static ListPhoneOperation getInstance() {
		if (instance == null) {
			instance = new ListPhoneOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

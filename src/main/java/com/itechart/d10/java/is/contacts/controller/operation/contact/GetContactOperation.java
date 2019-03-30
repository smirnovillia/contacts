package com.itechart.d10.java.is.contacts.controller.operation.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class GetContactOperation implements ICommand {
	
	private static GetContactOperation instance;

	private GetContactOperation() {
	}

	public static GetContactOperation getInstance() {
		if (instance == null) {
			instance = new GetContactOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

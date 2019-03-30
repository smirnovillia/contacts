package com.itechart.d10.java.is.contacts.controller.operation.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class UpdateContactOperation implements ICommand {
	
	private static UpdateContactOperation instance;

	private UpdateContactOperation() {
	}

	public static UpdateContactOperation getInstance() {
		if (instance == null) {
			instance = new UpdateContactOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

package com.itechart.d10.java.is.contacts.controller.operation.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class ListContactOperation implements ICommand {
	
	private static ListContactOperation instance;

	private ListContactOperation() {
	}

	public static ListContactOperation getInstance() {
		if (instance == null) {
			instance = new ListContactOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

package com.itechart.d10.java.is.contacts.controller.operation.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class ListAddressOperation implements ICommand {
	
	private static ListAddressOperation instance;

	private ListAddressOperation() {
	}

	public static ListAddressOperation getInstance() {
		if (instance == null) {
			instance = new ListAddressOperation();
		}
		return instance;
	}


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

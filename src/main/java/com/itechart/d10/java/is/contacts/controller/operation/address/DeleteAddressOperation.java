package com.itechart.d10.java.is.contacts.controller.operation.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class DeleteAddressOperation implements ICommand {
	
	private static DeleteAddressOperation instance;

	private DeleteAddressOperation() {
	}

	public static DeleteAddressOperation getInstance() {
		if (instance == null) {
			instance = new DeleteAddressOperation();
		}
		return instance;
	}


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

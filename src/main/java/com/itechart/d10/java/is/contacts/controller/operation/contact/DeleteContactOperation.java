package com.itechart.d10.java.is.contacts.controller.operation.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class DeleteContactOperation implements ICommand {
	
	private static DeleteContactOperation instance;
	
	private DeleteContactOperation() {
	}

	public static DeleteContactOperation getInstance() {
		if (instance == null) {
			instance = new DeleteContactOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
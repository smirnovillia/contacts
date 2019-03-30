package com.itechart.d10.java.is.contacts.controller.operation.workplace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class DeleteWorkplaceOperation implements ICommand {
	
	private static DeleteWorkplaceOperation instance;

	private DeleteWorkplaceOperation() {
	}

	public static DeleteWorkplaceOperation getInstance() {
		if (instance == null) {
			instance = new DeleteWorkplaceOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

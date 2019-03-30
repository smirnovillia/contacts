package com.itechart.d10.java.is.contacts.controller.operation.workplace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class UpdateWorkplaceOperation implements ICommand {
	
	private static UpdateWorkplaceOperation instance;

	private UpdateWorkplaceOperation() {
	}

	public static UpdateWorkplaceOperation getInstance() {
		if (instance == null) {
			instance = new UpdateWorkplaceOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

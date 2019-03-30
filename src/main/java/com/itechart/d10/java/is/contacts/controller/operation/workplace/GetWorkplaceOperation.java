package com.itechart.d10.java.is.contacts.controller.operation.workplace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class GetWorkplaceOperation implements ICommand {
	
	private static GetWorkplaceOperation instance;

	private GetWorkplaceOperation() {
	}

	public static GetWorkplaceOperation getInstance() {
		if (instance == null) {
			instance = new GetWorkplaceOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

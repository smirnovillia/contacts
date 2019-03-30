package com.itechart.d10.java.is.contacts.controller.operation.workplace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class ListWorkplaceOperation implements ICommand{
	
	private static ListWorkplaceOperation instance;

	private ListWorkplaceOperation() {
	}

	public static ListWorkplaceOperation getInstance() {
		if (instance == null) {
			instance = new ListWorkplaceOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	
}

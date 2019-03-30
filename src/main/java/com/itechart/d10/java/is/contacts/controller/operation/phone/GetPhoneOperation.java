package com.itechart.d10.java.is.contacts.controller.operation.phone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class GetPhoneOperation implements ICommand{
	
	private static GetPhoneOperation instance;

	private GetPhoneOperation() {
	}

	public static GetPhoneOperation getInstance() {
		if (instance == null) {
			instance = new GetPhoneOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	

}

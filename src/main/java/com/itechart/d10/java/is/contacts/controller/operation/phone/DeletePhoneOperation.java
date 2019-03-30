package com.itechart.d10.java.is.contacts.controller.operation.phone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class DeletePhoneOperation implements ICommand{
	
	private static DeletePhoneOperation instance;

	private DeletePhoneOperation() {
	}

	public static DeletePhoneOperation getInstance() {
		if (instance == null) {
			instance = new DeletePhoneOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	

}

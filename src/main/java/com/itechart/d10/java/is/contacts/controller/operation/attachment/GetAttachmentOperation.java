package com.itechart.d10.java.is.contacts.controller.operation.attachment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class GetAttachmentOperation implements ICommand {
	
	private static GetAttachmentOperation instance;

	private GetAttachmentOperation() {
	}

	public static GetAttachmentOperation getInstance() {
		if (instance == null) {
			instance = new GetAttachmentOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	
}

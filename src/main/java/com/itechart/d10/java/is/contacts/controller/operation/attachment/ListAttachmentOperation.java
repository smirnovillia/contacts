package com.itechart.d10.java.is.contacts.controller.operation.attachment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class ListAttachmentOperation implements ICommand {
	
	private static ListAttachmentOperation instance;

	private ListAttachmentOperation() {
	}

	public static ListAttachmentOperation getInstance() {
		if (instance == null) {
			instance = new ListAttachmentOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

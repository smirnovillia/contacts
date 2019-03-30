package com.itechart.d10.java.is.contacts.controller.operation.attachment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class UpdateAttachmentOperation implements ICommand {
	
	private static UpdateAttachmentOperation instance;

	private UpdateAttachmentOperation() {
	}

	public static UpdateAttachmentOperation getInstance() {
		if (instance == null) {
			instance = new UpdateAttachmentOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

package com.itechart.d10.java.is.contacts.controller.operation.attachment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class DeleteAttachmentOperation implements ICommand {
	
	private static DeleteAttachmentOperation instance;

	private DeleteAttachmentOperation() {
	}

	public static DeleteAttachmentOperation getInstance() {
		if (instance == null) {
			instance = new DeleteAttachmentOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}

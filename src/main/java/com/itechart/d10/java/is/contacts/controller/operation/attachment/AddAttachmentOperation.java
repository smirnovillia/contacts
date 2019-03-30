package com.itechart.d10.java.is.contacts.controller.operation.attachment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.controller.operation.address.AddAddressOperation;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.service.IAttachmentService;
import com.itechart.d10.java.is.contacts.service.impl.AttachmentServiceImpl;

public class AddAttachmentOperation implements ICommand{
	
	private IAttachmentService attachmentService = new AttachmentServiceImpl();
	
	private static AddAttachmentOperation instance;

	private AddAttachmentOperation() {
	}

	public static AddAttachmentOperation getInstance() {
		if (instance == null) {
			instance = new AddAttachmentOperation();
		}
		return instance;
	}

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final IAttachment entity = attachmentService.createEntity();
		attachmentService.save(entity);
	}

}

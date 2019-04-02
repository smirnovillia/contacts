package com.itechart.d10.java.is.contacts.controller.operation.attachment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.service.impl.AttachmentServiceImpl;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;

public class AddAttachmentOperation implements ICommand{
	
	
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
		final IAttachment entity = AttachmentServiceImpl.getInstance().createEntity();
		
		final IContact contact = ContactServiceImpl.getInstance().createEntity();
		if(request.getParameter("contactId") != null) {
			contact.setId(Integer.parseInt(request.getParameter("contactId")));
			entity.setContact(contact);
		}
		
		entity.setFileName(request.getParameter("fileName"));
		entity.setFilePath(request.getParameter("filePath"));
		entity.setComment(request.getParameter("comment"));
		
		AttachmentServiceImpl.getInstance().save(entity);
		
		ListAttachmentOperation.getInstance().execute(request, response);
	}

}

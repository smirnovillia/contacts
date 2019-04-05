package com.itechart.d10.java.is.contacts.controller.operation.attachment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.service.impl.AttachmentServiceImpl;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;

public class SaveAttachmentOperation implements ICommand{
	
        private AttachmentServiceImpl attachmentServiceImpl = new AttachmentServiceImpl();
        private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
    
	private static SaveAttachmentOperation instance;

	private SaveAttachmentOperation() {
	}

	public static SaveAttachmentOperation getInstance() {
		if (instance == null) {
			instance = new SaveAttachmentOperation();
		}
		return instance;
	}

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final IAttachment entity = attachmentServiceImpl.createEntity();
		
		final IContact contact = contactServiceImpl.createEntity();
		if(request.getParameter("contactId") != null) {
			contact.setId(Integer.parseInt(request.getParameter("contactId")));
			entity.setContact(contact);
		}
		
		entity.setFileName(request.getParameter("fileName"));
		entity.setFilePath(request.getParameter("filePath"));
		entity.setComment(request.getParameter("comment"));
		
		attachmentServiceImpl.save(entity);
		
	}

}

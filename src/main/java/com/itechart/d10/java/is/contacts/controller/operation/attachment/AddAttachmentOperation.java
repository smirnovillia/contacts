package com.itechart.d10.java.is.contacts.controller.operation.attachment;

import com.itechart.d10.java.is.contacts.controller.util.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.service.IAttachmentService;
import com.itechart.d10.java.is.contacts.service.impl.AttachmentServiceImpl;

public class AddAttachmentOperation implements ICommand{
	
	private IAttachmentService attachmentService = new AttachmentServiceImpl();
	
	@Override
	public void execute() {
		final IAttachment entity = attachmentService.createEntity();
		attachmentService.save(entity);
	}

}

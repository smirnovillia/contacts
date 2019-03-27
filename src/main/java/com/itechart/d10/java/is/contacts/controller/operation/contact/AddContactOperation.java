package com.itechart.d10.java.is.contacts.controller.operation.contact;

import com.itechart.d10.java.is.contacts.controller.util.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.service.IContactService;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;

public class AddContactOperation implements ICommand {
	
	private IContactService contactService = new ContactServiceImpl();

	@Override
	public void execute() {
		final IContact entity = contactService.createEntity();
		contactService.save(entity);
	}

}

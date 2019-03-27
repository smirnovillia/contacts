package com.itechart.d10.java.is.contacts.controller.operation.workplace;

import com.itechart.d10.java.is.contacts.controller.util.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.service.IWorkplaceService;
import com.itechart.d10.java.is.contacts.service.impl.WorkplaceServiceImpl;

public class AddWorkplaceOperation implements ICommand{
	
	private IWorkplaceService workplaceServiceImpl = new WorkplaceServiceImpl();

	@Override
	public void execute() {
		final IWorkplace entity = workplaceServiceImpl.createEntity();
		workplaceServiceImpl.save(entity);
	}

}

package com.itechart.d10.java.is.contacts.controller.operation.workplace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.service.impl.WorkplaceServiceImpl;

public class AddWorkplaceOperation implements ICommand{
	
	
	private static AddWorkplaceOperation instance;

	private AddWorkplaceOperation() {
	}

	public static AddWorkplaceOperation getInstance() {
		if (instance == null) {
			instance = new AddWorkplaceOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final IWorkplace entity = WorkplaceServiceImpl.getInstance().createEntity();
		
		entity.setCompany(request.getParameter("company"));
		
		WorkplaceServiceImpl.getInstance().save(entity);
		
		ListWorkplaceOperation.getInstance().execute(request, response);
	}

}

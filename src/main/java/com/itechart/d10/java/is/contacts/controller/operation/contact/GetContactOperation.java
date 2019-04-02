package com.itechart.d10.java.is.contacts.controller.operation.contact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;

public class GetContactOperation implements ICommand {
	
	
	private static GetContactOperation instance;

	private GetContactOperation() {
	}

	public static GetContactOperation getInstance() {
		if (instance == null) {
			instance = new GetContactOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final IContact entity = ContactServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("contact", entity);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/contact/form.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}

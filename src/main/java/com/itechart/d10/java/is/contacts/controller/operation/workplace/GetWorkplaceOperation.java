package com.itechart.d10.java.is.contacts.controller.operation.workplace;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.service.impl.WorkplaceServiceImpl;

public class GetWorkplaceOperation implements ICommand {
	
	
	private static GetWorkplaceOperation instance;

	private GetWorkplaceOperation() {
	}

	public static GetWorkplaceOperation getInstance() {
		if (instance == null) {
			instance = new GetWorkplaceOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final IWorkplace entity = WorkplaceServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("workplace", entity);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/workplace/form.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}

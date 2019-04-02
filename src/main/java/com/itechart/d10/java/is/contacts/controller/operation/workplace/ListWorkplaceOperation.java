package com.itechart.d10.java.is.contacts.controller.operation.workplace;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.service.impl.WorkplaceServiceImpl;

public class ListWorkplaceOperation implements ICommand{
	
	private static ListWorkplaceOperation instance;

	private ListWorkplaceOperation() {
	}

	public static ListWorkplaceOperation getInstance() {
		if (instance == null) {
			instance = new ListWorkplaceOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List<IWorkplace> workplaceList = WorkplaceServiceImpl.getInstance().getAll();
		request.setAttribute("workplaceList", workplaceList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/workplace/list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	
}

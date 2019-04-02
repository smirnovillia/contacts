package com.itechart.d10.java.is.contacts.controller.operation.attachment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.service.impl.AttachmentServiceImpl;

public class GetAttachmentOperation implements ICommand {
	
	
	private static GetAttachmentOperation instance;

	private GetAttachmentOperation() {
	}

	public static GetAttachmentOperation getInstance() {
		if (instance == null) {
			instance = new GetAttachmentOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			final IAttachment entity = AttachmentServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("attachment", entity);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/attachment/form.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		
	}

	
}

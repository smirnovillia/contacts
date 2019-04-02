package com.itechart.d10.java.is.contacts.controller.operation.attachment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.service.impl.AttachmentServiceImpl;

public class ListAttachmentOperation implements ICommand {
	
	private static ListAttachmentOperation instance;

	private ListAttachmentOperation() {
	}

	public static ListAttachmentOperation getInstance() {
		if (instance == null) {
			instance = new ListAttachmentOperation();
		}
		return instance;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List<IAttachment> attachmentList = AttachmentServiceImpl.getInstance().getAll();
		request.setAttribute("attachmentList", attachmentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/attachment/list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}

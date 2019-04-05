package com.itechart.d10.java.is.contacts.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.controller.operation.attachment.SaveAttachmentOperation;
import com.itechart.d10.java.is.contacts.controller.operation.attachment.DeleteAttachmentOperation;
import com.itechart.d10.java.is.contacts.controller.operation.attachment.GetAttachmentOperation;
import com.itechart.d10.java.is.contacts.controller.operation.attachment.ListAttachmentOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.SaveContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.DeleteContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.GetContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.ListContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.phone.SavePhoneOperation;
import com.itechart.d10.java.is.contacts.controller.operation.phone.DeletePhoneOperation;
import com.itechart.d10.java.is.contacts.controller.operation.phone.GetPhoneOperation;
import com.itechart.d10.java.is.contacts.controller.operation.phone.ListPhoneOperation;

public class CommonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<Operation, ICommand> comands;

	@Override
	public void init() throws ServletException {
		comands = new HashMap<Operation, ICommand>();
		comands.put(Operation.SAVE_CONTACT, SaveContactOperation.getInstance());
		comands.put(Operation.LIST_CONTACT, ListContactOperation.getInstance());
		comands.put(Operation.DELETE_CONTACT, DeleteContactOperation.getInstance());
		comands.put(Operation.GET_CONTACT, GetContactOperation.getInstance());
		comands.put(Operation.SAVE_PHONE, SavePhoneOperation.getInstance());
		comands.put(Operation.LIST_PHONE, ListPhoneOperation.getInstance());
		comands.put(Operation.DELETE_PHONE, DeletePhoneOperation.getInstance());
		comands.put(Operation.GET_PHONE, GetPhoneOperation.getInstance());
		comands.put(Operation.SAVE_ATTACHMENT, SaveAttachmentOperation.getInstance());
		comands.put(Operation.LIST_ATTACHMENT, ListAttachmentOperation.getInstance());
		comands.put(Operation.DELETE_ATTACHMENT, DeleteAttachmentOperation.getInstance());
		comands.put(Operation.GET_ATTACHMENT, GetAttachmentOperation.getInstance());
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			if (request.getParameter("operation") != null) {
				String operation = request.getParameter("operation");
				comands.get(Operation.valueOf(operation)).execute(request, response);
			} else {
				comands.get(Operation.LIST_CONTACT).execute(request, response);
			}
		} catch (Exception e) {
			throw new ServletException();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}

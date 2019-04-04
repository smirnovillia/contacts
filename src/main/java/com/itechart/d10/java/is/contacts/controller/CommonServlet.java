package com.itechart.d10.java.is.contacts.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.controller.operation.attachment.AddAttachmentOperation;
import com.itechart.d10.java.is.contacts.controller.operation.attachment.DeleteAttachmentOperation;
import com.itechart.d10.java.is.contacts.controller.operation.attachment.GetAttachmentOperation;
import com.itechart.d10.java.is.contacts.controller.operation.attachment.ListAttachmentOperation;
import com.itechart.d10.java.is.contacts.controller.operation.attachment.UpdateAttachmentOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.AddContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.DeleteContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.GetContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.ListContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.UpdateContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.phone.AddPhoneOperation;
import com.itechart.d10.java.is.contacts.controller.operation.phone.DeletePhoneOperation;
import com.itechart.d10.java.is.contacts.controller.operation.phone.GetPhoneOperation;
import com.itechart.d10.java.is.contacts.controller.operation.phone.ListPhoneOperation;
import com.itechart.d10.java.is.contacts.controller.operation.phone.UpdatePhoneOperation;

public class CommonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, ICommand> comands;

	@Override
	public void init() throws ServletException {
		comands = new HashMap<String, ICommand>();
		comands.put("AddContactOperation", AddContactOperation.getInstance());
		comands.put("ListContactOperation", ListContactOperation.getInstance());
		comands.put("UpdateContactOperation", UpdateContactOperation.getInstance());
		comands.put("DeleteContactOperation", DeleteContactOperation.getInstance());
		comands.put("GetContactOperation", GetContactOperation.getInstance());
		comands.put("AddPhoneOperation", AddPhoneOperation.getInstance());
		comands.put("ListPhoneOperation", ListPhoneOperation.getInstance());
		comands.put("UpdatePhoneOperation", UpdatePhoneOperation.getInstance());
		comands.put("DeletePhoneOperation", DeletePhoneOperation.getInstance());
		comands.put("GetPhoneOperation", GetPhoneOperation.getInstance());
		comands.put("AddAttachmentOperation", AddAttachmentOperation.getInstance());
		comands.put("ListAttachmentOperation", ListAttachmentOperation.getInstance());
		comands.put("UpdateAttachmentOperation", UpdateAttachmentOperation.getInstance());
		comands.put("DeleteAttachmentOperation", DeleteAttachmentOperation.getInstance());
		comands.put("GetAttachmentOperation", GetAttachmentOperation.getInstance());
		System.out.println("Servlet started");
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

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("This method was executed");
		try {
			if (request.getParameter("operation") != null) {
				String operation = request.getParameter("operation");
				comands.get(operation).execute(request, response);
			} else {
				comands.get("ListContactOperation").execute(request, response);
			}
		} catch (Exception e) {
			throw new ServletException();
		}
	}

}

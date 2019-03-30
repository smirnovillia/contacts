package com.itechart.d10.java.is.contacts.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.controller.operation.address.AddAddressOperation;
import com.itechart.d10.java.is.contacts.controller.operation.address.DeleteAddressOperation;
import com.itechart.d10.java.is.contacts.controller.operation.address.GetAddressOperation;
import com.itechart.d10.java.is.contacts.controller.operation.address.ListAddressOperation;
import com.itechart.d10.java.is.contacts.controller.operation.address.UpdateAddressOperation;
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
import com.itechart.d10.java.is.contacts.controller.operation.workplace.AddWorkplaceOperation;
import com.itechart.d10.java.is.contacts.controller.operation.workplace.DeleteWorkplaceOperation;
import com.itechart.d10.java.is.contacts.controller.operation.workplace.GetWorkplaceOperation;
import com.itechart.d10.java.is.contacts.controller.operation.workplace.ListWorkplaceOperation;
import com.itechart.d10.java.is.contacts.controller.operation.workplace.UpdateWorkplaceOperation;

@WebServlet("/CommonServlet")
public class CommonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, ICommand> comands;
	
       
    public CommonServlet() {
        super();
    }
    
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
    	comands.put("AddWorkplaceOperation", AddWorkplaceOperation.getInstance());
    	comands.put("ListWorkplaceOperation", ListWorkplaceOperation.getInstance());
    	comands.put("UpdateWorkplaceOperation", UpdateWorkplaceOperation.getInstance());
    	comands.put("DeleteWorkplaceOperation", DeleteWorkplaceOperation.getInstance());
    	comands.put("GetWorkplaceOperation", GetWorkplaceOperation.getInstance());
    	comands.put("AddAddressOperation", AddAddressOperation.getInstance());
    	comands.put("ListAddressOperation", ListAddressOperation.getInstance());
    	comands.put("UpdateAddressOperation", UpdateAddressOperation.getInstance());
    	comands.put("DeleteAddressOperation", DeleteAddressOperation.getInstance());
    	comands.put("GetAddressOperation", GetAddressOperation.getInstance());
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}

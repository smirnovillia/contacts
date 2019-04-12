/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itechart.d10.java.is.contacts.controller.operation.contact;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author illiasmirnov
 */
public class FormContactOperation implements ICommand {

    private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();

    private static FormContactOperation instance;

    public FormContactOperation() {

    }

    public static FormContactOperation getInstance() {
        if (instance == null) {
            instance = new FormContactOperation();
        }
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IContact entity = null;
        if (null != request.getParameter("contactId")) {
            Integer contactId = Integer.parseInt(request.getParameter("contactId"));
            entity = contactServiceImpl.getById(contactId);
            entity.setId(contactId);
            request.setAttribute("contact", entity);

        }
        return "/jsp/contact.jsp";
    }

}

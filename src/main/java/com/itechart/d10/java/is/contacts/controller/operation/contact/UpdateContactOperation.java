package com.itechart.d10.java.is.contacts.controller.operation.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;

public class UpdateContactOperation implements ICommand {

    private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();

    private static UpdateContactOperation instance;

    private UpdateContactOperation() {
    }

    public static UpdateContactOperation getInstance() {
        if (instance == null) {
            instance = new UpdateContactOperation();
        }
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        final IContact entity = contactServiceImpl.getById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("contact", entity);
        return "success";
    }

}

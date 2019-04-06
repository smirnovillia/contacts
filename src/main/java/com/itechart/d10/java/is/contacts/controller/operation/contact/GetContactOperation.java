package com.itechart.d10.java.is.contacts.controller.operation.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;

public class GetContactOperation implements ICommand {

    private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();

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
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        final IContact entity = contactServiceImpl.getById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("contact", entity);
        return "success";
    }

}

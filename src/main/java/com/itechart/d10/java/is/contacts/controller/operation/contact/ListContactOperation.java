package com.itechart.d10.java.is.contacts.controller.operation.contact;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;

public class ListContactOperation implements ICommand {

    private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();

    private static ListContactOperation instance;

    private ListContactOperation() {
    }

    public static ListContactOperation getInstance() {
        if (instance == null) {
            instance = new ListContactOperation();
        }
        return instance;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<IContact> contactsFromDb = contactServiceImpl.getAll();
        request.setAttribute("contactList", contactsFromDb);
        String url = "jsp/contact/list.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}

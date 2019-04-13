package com.itechart.d10.java.is.contacts.controller.operation;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendEmailOperation implements ICommand {

    private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();

    private static SendEmailOperation instance;

    private SendEmailOperation() {

    }

    public static SendEmailOperation getInstance() {
        if (instance == null) {
            instance = new SendEmailOperation();
        }
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        contactServiceImpl.sendEmail(recipient, subject, message);

        return "/controller?operation=LIST_CONTACT";
    }
}

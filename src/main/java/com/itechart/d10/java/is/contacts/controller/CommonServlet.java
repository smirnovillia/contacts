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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

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

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String operation = request.getParameter("operation");
        String view = comands.get(Operation.valueOf(operation)).execute(request, response);
        if (view.equals("failure")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("failure.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException ex | IOException ex) {
                Logger.getLogger(CommonServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (view.equals("success")) {
                try {
                    response.sendRedirect(Operation.valueOf(operation).getPage());
                } catch (IOException ex) {
                    Logger.getLogger(CommonServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
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

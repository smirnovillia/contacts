package com.itechart.d10.java.is.contacts.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.controller.operation.SaveContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.DeleteContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.FormContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.ListContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.SendEmailOperation;
import java.util.EnumMap;
import javax.servlet.RequestDispatcher;

public class CommonServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Map<Operation, ICommand> comands;

    @Override
    public void init() throws ServletException {
        comands = new EnumMap<Operation, ICommand>(Operation.class);
        comands.put(Operation.SAVE_CONTACT, SaveContactOperation.getInstance());
        comands.put(Operation.LIST_CONTACT, ListContactOperation.getInstance());
        comands.put(Operation.FORM_CONTACT, FormContactOperation.getInstance());
        comands.put(Operation.DELETE_CONTACT, DeleteContactOperation.getInstance());
         comands.put(Operation.SEND_EMAIL, SendEmailOperation.getInstance());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String operation = request.getParameter("operation");
        try {
            String page = comands.get(Operation.valueOf(operation)).execute(request, response);
            if (page != null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
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

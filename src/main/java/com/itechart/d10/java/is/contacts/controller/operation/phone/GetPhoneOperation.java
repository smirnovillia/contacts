package com.itechart.d10.java.is.contacts.controller.operation.phone;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.service.impl.PhoneServiceImpl;

public class GetPhoneOperation implements ICommand {

    private PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();

    private static GetPhoneOperation instance;

    private GetPhoneOperation() {
    }

    public static GetPhoneOperation getInstance() {
        if (instance == null) {
            instance = new GetPhoneOperation();
        }
        return instance;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        final IPhone entity = phoneServiceImpl.getById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("phone", entity);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/phone/form.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}

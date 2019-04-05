package com.itechart.d10.java.is.contacts.controller.operation.phone;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.service.impl.PhoneServiceImpl;

public class ListPhoneOperation implements ICommand {

    private PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();

    private static ListPhoneOperation instance;

    private ListPhoneOperation() {
    }

    public static ListPhoneOperation getInstance() {
        if (instance == null) {
            instance = new ListPhoneOperation();
        }
        return instance;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<IPhone> phoneList = phoneServiceImpl.getAll();
        request.setAttribute("phoneList", phoneList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/phone/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

}

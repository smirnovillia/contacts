package com.itechart.d10.java.is.contacts.controller.operation.address;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.service.impl.AddressServiceImpl;

public class ListAddressOperation implements ICommand {
	
	
	private static ListAddressOperation instance;

	private ListAddressOperation() {
	}

	public static ListAddressOperation getInstance() {
		if (instance == null) {
			instance = new ListAddressOperation();
		}
		return instance;
	}


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List<IAddress> addressList = AddressServiceImpl.getInstance().getAll();
		request.setAttribute("addressList", addressList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/address/list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}

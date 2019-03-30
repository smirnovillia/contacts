package com.itechart.d10.java.is.contacts.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
	
	void execute(HttpServletRequest request, HttpServletResponse response);

}

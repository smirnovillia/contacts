package com.itechart.d10.java.is.contacts.controller.operation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.enums.Gender;
import com.itechart.d10.java.is.contacts.dao.api.enums.MaritalStatus;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;

public class SaveContactOperation implements ICommand {

    private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();

    private static SaveContactOperation instance;

    private SaveContactOperation() {

    }

    public static SaveContactOperation getInstance() {
        if (instance == null) {
            instance = new SaveContactOperation();
        }
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IContact entity = null;
        request.setAttribute("contact", entity);
        if ("".equals(request.getParameter("contactId"))) {
            entity = contactServiceImpl.createEntity();
        } else {
            Integer contactId = Integer.parseInt(request.getParameter("contactId"));
            entity = contactServiceImpl.getById(contactId);
            entity.setId(contactId);
        }
        entity.setFirstName(request.getParameter("firstName"));
        entity.setMidleName(request.getParameter("midleName"));
        entity.setLastName(request.getParameter("lastName"));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String bDay = request.getParameter("birthday");
        Date birthday = null;
        try {
            birthday = new Date(dateFormat.parse(bDay).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        entity.setBirthday(birthday);
        entity.setGender(Gender.valueOf(request.getParameter("gender")));
        entity.setCitizenship(request.getParameter("citizenship"));
        entity.setMaritalStatus(MaritalStatus.valueOf(request.getParameter("maritalStatus")));
        entity.setWebsite(request.getParameter("website"));
        entity.setEmail(request.getParameter("email"));
        entity.setCompany(request.getParameter("company"));
        entity.setCountry(request.getParameter("country"));
        entity.setCity(request.getParameter("city"));
        entity.setStreet(request.getParameter("street"));
        entity.setHouseNumber(request.getParameter("houseNumber"));
        if(request.getParameter("apartment") != null && !request.getParameter("apartment").isEmpty()){
            entity.setApartment(Integer.parseInt(request.getParameter("apartment")));
        }
        entity.setZip(request.getParameter("zip"));
        
        

        contactServiceImpl.save(entity);
        return "/controller?operation=LIST_CONTACT";
    }

}

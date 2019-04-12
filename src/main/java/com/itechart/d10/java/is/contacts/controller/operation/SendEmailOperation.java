package com.itechart.d10.java.is.contacts.controller.operation;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
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
        String contacts[] = request.getParameterValues("labeled");
        List<String> contactList = Arrays.asList(contacts);

        List<Integer> contactIdList = new ArrayList<>();
        for (String contact : contactList) {
            contactIdList.add(Integer.valueOf(contact));
        }

        List<IContact> contactsFromDB = contactServiceImpl.getAll();
        
        List<String> emailList = null;
        
        for (int i = 0; i < contactsFromDB.size(); i++) {
            for (int j = 0; j < contactIdList.size(); j++) {
                if(!contactIdList.get(j).equals(null) && contactsFromDB.get(i).getId().equals(contactIdList.get(j))) {
                    emailList.add(contactsFromDB.get(i).getEmail());
                }
            }
            
        }
        
        

        return "jsp/email.jsp";
    }
}

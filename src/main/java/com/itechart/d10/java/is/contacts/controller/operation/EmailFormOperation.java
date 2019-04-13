/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itechart.d10.java.is.contacts.controller.operation;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmailFormOperation implements ICommand{
    
    private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
    
    public static EmailFormOperation instance;
    
    public static EmailFormOperation getInstance() {
        if (instance == null) {
            instance = new EmailFormOperation();
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
        
        List<String> emailList = new ArrayList<>();
        
        for (int i = 0; i < contactsFromDB.size(); i++) {
            for (int j = 0; j < contactIdList.size(); j++) {
                if(contactsFromDB.get(i).getId().equals(contactIdList.get(j))) {
                    emailList.add(contactsFromDB.get(i).getEmail());
                }
            }
            
        }
        String[] emailArray = new String[emailList.size()]; 
  
        for (int i =0; i < emailList.size(); i++) {
            emailArray[i] = emailList.get(i); 
        }
        StringBuilder buildRecipient = new StringBuilder();
        for (int i = 0; i < emailArray.length-1; i++) {
            buildRecipient.append(emailArray[i]).append(", ").append(emailArray[i+1]);
        }
        request.setAttribute("recipient", buildRecipient.toString());
        return "/jsp/email.jsp";
    }
    
}

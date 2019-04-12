package com.itechart.d10.java.is.contacts.controller.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DeleteContactOperation implements ICommand {

    private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();

    private static DeleteContactOperation instance;

    private DeleteContactOperation() {
    }

    public static DeleteContactOperation getInstance() {
        if (instance == null) {
            instance = new DeleteContactOperation();
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
        Iterator<Integer> iterator = contactIdList.iterator();     
        while (iterator.hasNext()){
            Integer contactId = iterator.next();
            if(!contactId.equals(null)){   
                contactServiceImpl.delete(contactId);                  
            }
        }
        return "/controller?operation=LIST_CONTACT";
    }

}

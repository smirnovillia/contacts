/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itechart.d10.java.is.contacts.controller;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.controller.operation.contact.DeleteContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.GetContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.ListContactOperation;
import com.itechart.d10.java.is.contacts.controller.operation.contact.SaveContactOperation;

/**
 *
 * @author illiasmirnov
 */
public enum Operation {
    
    SAVE_CONTACT(SaveContactOperation.getInstance()),
    GET_CONTACT(GetContactOperation.getInstance()),
    DELETE_CONTACT(DeleteContactOperation.getInstance()),
    LIST_CONTACT(ListContactOperation.getInstance());
    
    private ICommand command;
    
    private Operation(ICommand command){
        this.command = command;
    }
    
    public ICommand getCommand(){
        return command;
    }
}

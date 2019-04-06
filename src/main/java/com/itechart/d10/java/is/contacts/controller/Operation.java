/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itechart.d10.java.is.contacts.controller;

/**
 *
 * @author illiasmirnov
 */
public enum Operation {
    
    SAVE_CONTACT("contact/form.jsp"),
    GET_CONTACT("contact/{%s}"),
    DELETE_CONTACT(""),
    LIST_CONTACT("contact/list.jsp"),
    SAVE_ATTACHMENT("attachment/form.jsp"),
    GET_ATTACHMENT("attachment/{%s}"),
    DELETE_ATTACHMENT(""),
    LIST_ATTACHMENT("attachment/list.jsp"),
    SAVE_PHONE("phone/form.jsp"),
    GET_PHONE("phone/{%s}"),
    DELETE_PHONE(""),
    LIST_PHONE("phone/list.jsp");
    
    private String jspPage;
    
    private Operation(String jspPage){
        this.jspPage = jspPage;
    }
    
    public String getPage(){
        return jspPage;
    }
}

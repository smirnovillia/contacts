package com.itechart.d10.java.is.contacts.dao.api;

import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.filter.ContactFilter;

public interface IContactDao extends IBaseDao<IContact, Integer>{

	List<IContact> find(ContactFilter filter);

}

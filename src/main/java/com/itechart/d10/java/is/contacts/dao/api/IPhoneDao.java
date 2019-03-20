package com.itechart.d10.java.is.contacts.dao.api;

import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.dao.api.filter.PhoneFilter;

public interface IPhoneDao extends IBaseDao<IPhone, Integer>{
	
	List<IPhone> find(PhoneFilter filter);

}

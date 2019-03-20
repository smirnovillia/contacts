package com.itechart.d10.java.is.contacts.dao.api;

import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.dao.api.filter.AddressFilter;

public interface IAddressDao extends IBaseDao<IAddress, Integer>{
	
	List<IAddress> find(AddressFilter filter);

}

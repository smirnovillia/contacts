package com.itechart.d10.java.is.contacts.service;

import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.dao.api.filter.AddressFilter;

public interface IAddressService {

	IAddress getById(Integer id);

	List<IAddress> getAll();

	void save(IAddress entity);

	void delete(Integer id);

	void deleteAll();

	IAddress createEntity();

	List<IAddress> find(AddressFilter filter);
}

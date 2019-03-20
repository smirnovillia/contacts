package com.itechart.d10.java.is.contacts.service;

import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.dao.api.filter.PhoneFilter;

public interface IPhoneService {

	IPhone getById(Integer id);

	List<IPhone> getAll();

	void save(IPhone entity);

	void delete(Integer id);

	void deleteAll();

	IPhone createEntity();

	List<IPhone> find(PhoneFilter filter);
}

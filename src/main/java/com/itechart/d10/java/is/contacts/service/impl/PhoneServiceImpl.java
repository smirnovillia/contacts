package com.itechart.d10.java.is.contacts.service.impl;

import java.util.Date;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IPhoneDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.dao.api.filter.PhoneFilter;
import com.itechart.d10.java.is.contacts.service.IPhoneService;

public class PhoneServiceImpl implements IPhoneService {

	private IPhoneDao dao;

	private static PhoneServiceImpl instance;

	private PhoneServiceImpl() {
	}

	public static PhoneServiceImpl getInstance() {
		if (instance == null) {
			instance = new PhoneServiceImpl();
		}
		return instance;
	}

	@Override
	public IPhone getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<IPhone> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(IPhone entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public IPhone createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IPhone> find(PhoneFilter filter) {
		return dao.find(filter);
	}

}

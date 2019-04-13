package com.itechart.d10.java.is.contacts.service.impl;

import java.util.Date;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IPhoneDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.dao.api.filter.PhoneFilter;
import com.itechart.d10.java.is.contacts.dao.impl.PhoneDaoImpl;
import com.itechart.d10.java.is.contacts.service.IPhoneService;

public class PhoneServiceImpl implements IPhoneService {

	private IPhoneDao dao;

	public PhoneServiceImpl() {
            dao = new PhoneDaoImpl();
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
        
	public void save(IContact contact, IPhone entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			entity.setCreated(modifedOn);
                        entity.setContact(contact);
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

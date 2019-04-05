package com.itechart.d10.java.is.contacts.service.impl;

import java.util.Date;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IContactDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.filter.ContactFilter;
import com.itechart.d10.java.is.contacts.dao.impl.ContactDaoImpl;
import com.itechart.d10.java.is.contacts.service.IContactService;

public class ContactServiceImpl implements IContactService {

	private IContactDao dao;
	
        public ContactServiceImpl(){
            dao = new ContactDaoImpl();
        }
        
	@Override
	public IContact getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<IContact> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(IContact entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if(entity.getId() == null) {
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
	public IContact createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IContact> find(ContactFilter filter) {
		return dao.find(filter);
	}

}

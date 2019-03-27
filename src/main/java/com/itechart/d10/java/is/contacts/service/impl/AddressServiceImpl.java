package com.itechart.d10.java.is.contacts.service.impl;

import java.util.Date;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IAddressDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.dao.api.filter.AddressFilter;
import com.itechart.d10.java.is.contacts.dao.impl.AddressDaoImpl;
import com.itechart.d10.java.is.contacts.service.IAddressService;

public class AddressServiceImpl implements IAddressService{
	
	private IAddressDao dao;

	public AddressServiceImpl() {
		super();
		this.dao = new AddressDaoImpl();
	}

	@Override
	public IAddress getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<IAddress> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(IAddress entity) {
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
	public IAddress createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IAddress> find(AddressFilter filter) {
		return dao.find(filter);
	}

}

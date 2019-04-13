package com.itechart.d10.java.is.contacts.service.impl;

import java.util.Date;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IAttachmentDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.filter.AttachmentFilter;
import com.itechart.d10.java.is.contacts.dao.impl.AttachmentDaoImpl;
import com.itechart.d10.java.is.contacts.service.IAttachmentService;

public class AttachmentServiceImpl implements IAttachmentService{
	
	private IAttachmentDao dao;

	public AttachmentServiceImpl() {
            dao = new AttachmentDaoImpl();
	}
	
	@Override
	public IAttachment getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<IAttachment> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(IAttachment entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if(entity.getId() == null) {
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}
        
        public void save(IContact contact, IAttachment entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if(entity.getId() == null) {
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
	public IAttachment createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IAttachment> find(AttachmentFilter filter) {
		return dao.find(filter);
	}

}

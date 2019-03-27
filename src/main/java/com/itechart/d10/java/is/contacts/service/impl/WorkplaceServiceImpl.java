package com.itechart.d10.java.is.contacts.service.impl;

import java.util.Date;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IWorkplaceDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.dao.api.filter.WorkplaceFilter;
import com.itechart.d10.java.is.contacts.dao.impl.WorkplaceDaoImpl;
import com.itechart.d10.java.is.contacts.service.IWorkplaceService;

public class WorkplaceServiceImpl implements IWorkplaceService{
	
	private IWorkplaceDao dao;

	public WorkplaceServiceImpl() {
		super();
		this.dao = new WorkplaceDaoImpl();
	}

	@Override
	public IWorkplace getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<IWorkplace> getAll() {
		return dao.getAll();
	}

	@Override
	public void save(IWorkplace entity) {
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
	public IWorkplace createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IWorkplace> find(WorkplaceFilter filter) {
		return dao.find(filter);
	}

}

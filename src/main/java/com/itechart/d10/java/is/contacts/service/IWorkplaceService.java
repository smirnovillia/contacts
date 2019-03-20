package com.itechart.d10.java.is.contacts.service;

import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.dao.api.filter.WorkplaceFilter;

public interface IWorkplaceService {

	IWorkplace getById(Integer id);

	List<IWorkplace> getAll();

	void save(IWorkplace entity);

	void delete(Integer id);

	void deleteAll();

	IWorkplace createEntity();

	List<IWorkplace> find(WorkplaceFilter filter);
}

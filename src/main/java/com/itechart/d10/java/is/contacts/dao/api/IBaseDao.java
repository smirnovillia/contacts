package com.itechart.d10.java.is.contacts.dao.api;

import java.util.List;

public interface IBaseDao<ENTITY, ID> {
	
	ENTITY createEntity();

	ENTITY getById(ID id);

	void update(ENTITY entity);

	void insert(ENTITY entity);

	void deleteById(ID id);

	void deleteAll();

	List<ENTITY> getAll();
}

package com.itechart.d10.java.is.contacts.dao.api;

import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.dao.api.filter.WorkplaceFilter;

public interface IWorkplaceDao extends IBaseDao<IWorkplace, Integer>{
	
	List<IWorkplace> find(WorkplaceFilter filter);

}

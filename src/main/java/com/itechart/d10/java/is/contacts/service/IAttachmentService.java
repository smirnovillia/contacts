package com.itechart.d10.java.is.contacts.service;

import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.dao.api.filter.AttachmentFilter;

public interface IAttachmentService {
	
	IAttachment getById(Integer id);
	
	List<IAttachment> getAll();
	
	void save(IAttachment entity);
	
	void delete(Integer id);
	
	void deleteAll();
	
	IAttachment createEntity();
	
	List<IAttachment> find(AttachmentFilter filter);

}

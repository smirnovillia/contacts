package com.itechart.d10.java.is.contacts.dao.api;

import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.dao.api.filter.AttachmentFilter;

public interface IAttachmentDao extends IBaseDao<IAttachment, Integer>{
	
	List<IAttachment> find(AttachmentFilter filter);

}

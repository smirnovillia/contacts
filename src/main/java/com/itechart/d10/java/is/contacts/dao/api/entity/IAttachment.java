package com.itechart.d10.java.is.contacts.dao.api.entity;

import com.itechart.d10.java.is.contacts.dao.api.base.IBaseEntity;

public interface IAttachment extends IBaseEntity {

	String getFileName();

	void setFileName(String fileName);

	String getComment();

	void setComment(String comment);

}

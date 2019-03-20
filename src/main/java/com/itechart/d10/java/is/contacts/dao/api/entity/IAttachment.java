package com.itechart.d10.java.is.contacts.dao.api.entity;

import com.itechart.d10.java.is.contacts.dao.api.base.IBaseEntity;

public interface IAttachment extends IBaseEntity {

	IContact getContact();

	void setContact(IContact contact);

	String getFileName();

	void setFileName(String fileName);

	String getFilePath();

	void setFilePath(String filePath);

	String getComment();

	void setComment(String comment);

}

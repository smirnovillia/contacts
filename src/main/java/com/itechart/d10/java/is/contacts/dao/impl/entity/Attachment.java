package com.itechart.d10.java.is.contacts.dao.impl.entity;

import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;

public class Attachment extends BaseEntity implements IAttachment {

	private IContact contact;
	private String fileName;
	private String filePath;
	private String comment;
	
	
	public IContact getContact() {
		return contact;
	}
	public void setContact(IContact contact) {
		this.contact = contact;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

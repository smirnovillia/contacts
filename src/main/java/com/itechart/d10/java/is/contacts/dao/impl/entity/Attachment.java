package com.itechart.d10.java.is.contacts.dao.impl.entity;

import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;

public class Attachment extends BaseEntity implements IAttachment {

	private String fileName;
	private String comment;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

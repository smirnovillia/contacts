package com.itechart.d10.java.is.contacts.dao.api.base;

import java.util.Date;

public interface IBaseEntity {
	Integer getId();

	void setId(Integer id);

	Date getCreated();

	void setCreated(Date created);

	Date getUpdated();

	void setUpdated(Date updated);
}

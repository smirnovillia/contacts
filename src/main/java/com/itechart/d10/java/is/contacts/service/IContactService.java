package com.itechart.d10.java.is.contacts.service;

import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.dao.api.filter.ContactFilter;

public interface IContactService {

        IContact getById(Integer id);

        List<IContact> getAll();

        void save(IContact entity);

        void delete(Integer id);

        void deleteAll();

        IContact createEntity();

        List<IContact> find(ContactFilter filter);

        void save(IContact entity, List<IPhone> phoneList);

}

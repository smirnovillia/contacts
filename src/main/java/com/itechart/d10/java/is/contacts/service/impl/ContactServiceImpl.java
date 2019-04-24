package com.itechart.d10.java.is.contacts.service.impl;

import java.util.Date;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IContactDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.dao.api.filter.ContactFilter;
import com.itechart.d10.java.is.contacts.dao.impl.ContactDaoImpl;
import com.itechart.d10.java.is.contacts.service.IContactService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactServiceImpl implements IContactService {

    private IContactDao dao;
    private AttachmentServiceImpl attachmentServiceImpl;
    private PhoneServiceImpl phoneServiceImpl;

    public ContactServiceImpl() {
        dao = new ContactDaoImpl();
        phoneServiceImpl = new PhoneServiceImpl();
        attachmentServiceImpl = new AttachmentServiceImpl();
    }

    @Override
    public IContact getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    public List<IContact> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(IContact entity) {
        final Date modifedOn = new Date();
        entity.setUpdated(modifedOn);
        if (entity.getId() == null) {
            entity.setCreated(modifedOn);
            dao.insert(entity);
        } else {
            dao.update(entity);
        }
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public IContact createEntity() {
        return dao.createEntity();
    }

    @Override
    public List<IContact> find(ContactFilter filter) {
        return dao.find(filter);
    }

    public void sendEmail(String recipient, String subject, String content) {
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            Properties prop = new Properties();
            try {
                prop.load(new FileInputStream(rootPath + "mail-config.properties"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ContactServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ContactServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(prop.getProperty("mail.username"), prop.getProperty("mail.password"));
                }
            });
            Message message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(prop.getProperty("mail.username")));
            } catch (AddressException ex) {
            } catch (MessagingException ex) {
            }
            if (recipient.contains(",")) {
                String[] receiver = recipient.split(",");
                try {
                    Address[] to = new Address[receiver.length];
                    for (int i = 0; i < to.length; i++) {
                        to[i] = new InternetAddress(receiver[i]);
                    }
                    message.setRecipients(Message.RecipientType.TO, to);
                } catch (AddressException ex) {
                } catch (MessagingException ex) {
                }
            } else {
                try {
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                } catch (AddressException ex) {
                } catch (MessagingException ex) {
                }
            }
            message.setSubject(subject);

            message.setText(content);

            Transport.send(message);

        } catch (MessagingException ex) {
            Logger.getLogger(ContactServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void save(IContact entity, List<IPhone> phones) {
        final Date modifedOn = new Date();
        entity.setUpdated(modifedOn);
        if (entity.getId() == null) {
            entity.setCreated(modifedOn);
            dao.insert(entity);
        } else {
            dao.update(entity);

        }
        saveModels(entity, phones);
    }

    public void save(IContact entity, List<IPhone> phones, List<IAttachment> attachments) {
        final Date modifedOn = new Date();
        entity.setUpdated(modifedOn);
        if (entity.getId() == null) {
            entity.setCreated(modifedOn);
            dao.insert(entity);
        } else {
            dao.update(entity);

        }
        saveModels(entity, phones, attachments);
    }
    
    private void saveModels(IContact contact, List<IPhone> phones) {

        if (phones != null) {
            for (IPhone phone : phones) {
                phoneServiceImpl.save(contact, phone);
            }
        }
    }

    private void saveModels(IContact contact, List<IPhone> phones, List<IAttachment> attachments) {

        if (phones != null) {
            for (IPhone phone : phones) {
                phoneServiceImpl.save(contact, phone);
            }
        }
        if (attachments != null) {
            for (IAttachment attachment : attachments) {
                attachmentServiceImpl.save(contact, attachment);
            }
        }
    }

}

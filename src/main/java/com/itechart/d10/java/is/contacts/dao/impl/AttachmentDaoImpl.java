package com.itechart.d10.java.is.contacts.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IAttachmentDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAttachment;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.filter.AttachmentFilter;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Attachment;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Contact;
import com.itechart.d10.java.is.contacts.dao.impl.util.PreparedStatementAction;

public class AttachmentDaoImpl extends AbsractDaoImpl<IAttachment, Integer> implements IAttachmentDao{

	@Override
	public IAttachment createEntity() {
		return new Attachment();
	}

	@Override
	public void update(IAttachment entity) {
		executeStatement(new PreparedStatementAction<IAttachment>(String.format(
				"update %s set contact_id=?, file_name=?, file_path=?, comment=?, updated=? where id=?",
				getTableName())) {

			@Override
			public IAttachment doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getContact().getId());
				pStmt.setString(2, entity.getFileName());
				pStmt.setString(3, entity.getFilePath());
				pStmt.setString(4, entity.getComment());
				pStmt.setObject(5, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(6, entity.getId());
				
				pStmt.executeUpdate();
				
				return entity;
			}

		});


	}

	@Override
	public void insert(IAttachment entity) {
		executeStatement(new PreparedStatementAction<IAttachment>(String.format(
				"insert into %s (contact_id, file_name, file_path, comment" + ", created, updated) values(?,?,?,?,?,?)",
				getTableName()), true) {

			@Override
			public IAttachment doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getContact().getId());
				pStmt.setString(2, entity.getFileName());
				pStmt.setString(3, entity.getFilePath());
				pStmt.setString(4, entity.getComment());
				pStmt.setObject(5, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(6, entity.getUpdated(), Types.TIMESTAMP);
				
				pStmt.executeUpdate();
				
				final ResultSet rs = pStmt.getGeneratedKeys();
				rs.next();
				final int id = rs.getInt("id");
				
				rs.close();
				
				entity.setId(id);
				
				return entity;
			}

		});

	}
	

	@Override
	protected IAttachment parseRow(ResultSet resultSet) throws SQLException {
		final IAttachment entity = createEntity();
		entity.setId(resultSet.getInt("id"));
		
		final IContact contact = new Contact();
		contact.setId(resultSet.getInt("contact_id"));
		entity.setContact(contact);
		
		entity.setFileName(resultSet.getString("file_name"));
		entity.setFilePath(resultSet.getString("file_path"));
		entity.setComment(resultSet.getString("comment"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		
		return entity;
	}

	@Override
	protected String getTableName() {
		return "attachment";
	}
	
	@Override
	public List<IAttachment> find(final AttachmentFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
        appendSort(filter, sqlTile);
        appendPaging(filter, sqlTile);
        return executeFindQuery(sqlTile.toString());
	}

}

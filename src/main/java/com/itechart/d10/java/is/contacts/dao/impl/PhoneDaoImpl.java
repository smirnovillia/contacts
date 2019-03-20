package com.itechart.d10.java.is.contacts.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IPhoneDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.dao.api.enums.PhoneType;
import com.itechart.d10.java.is.contacts.dao.api.filter.PhoneFilter;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Contact;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Phone;
import com.itechart.d10.java.is.contacts.dao.impl.util.PreparedStatementAction;

public class PhoneDaoImpl extends AbsractDaoImpl<IPhone, Integer> implements IPhoneDao {

	@Override
	public IPhone createEntity() {
		return new Phone();
	}

	@Override
	public void update(IPhone entity) {
		executeStatement(new PreparedStatementAction<IPhone>(
				String.format("update %s set contact_id=?, country_code=?, operator_code=?, phone_number=?, phone_type=?, comment=?, "
						+ "updated=? where id=?", getTableName())) {

			@Override
			public IPhone doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getContact().getId());
				pStmt.setString(2, entity.getCountryCode());
				pStmt.setString(3, entity.getOperatorCode());
				pStmt.setString(4, entity.getPhoneNumber());
				pStmt.setString(5, entity.getPhoneType().toString());
				pStmt.setString(6, entity.getComment());
				pStmt.setObject(7, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(8, entity.getId());
				
				pStmt.executeUpdate();
				
				return entity;
			}

		});

	}

	@Override
	public void insert(IPhone entity) {
		executeStatement(new PreparedStatementAction<IPhone>(
				String.format("insert into %s (contact_id, country_code, operator_code, phone_number, phone_type, comment, "
						+ "created, updated) values(?,?,?,?,?,?,?,?)", getTableName()),
				true) {

			@Override
			public IPhone doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getContact().getId());
				pStmt.setString(2, entity.getCountryCode());
				pStmt.setString(3, entity.getOperatorCode());
				pStmt.setString(4, entity.getPhoneNumber());
				pStmt.setString(5, entity.getPhoneType().toString());
				pStmt.setString(6, entity.getComment());
				pStmt.setObject(7, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(8, entity.getUpdated(), Types.TIMESTAMP);
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
	protected IPhone parseRow(ResultSet resultSet) throws SQLException {
		final IPhone entity = createEntity();
		final IContact contact = new Contact();
		contact.setId(resultSet.getInt("contact_id"));
		entity.setContact(contact);
		entity.setCountryCode(resultSet.getString("country_code"));
		entity.setOperatorCode(resultSet.getString("operator_code"));
		entity.setPhoneNumber(resultSet.getString("phone_number"));
		entity.setPhoneType(PhoneType.valueOf(resultSet.getString("phone_type")));
		entity.setComment(resultSet.getString("comment"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		return entity;
	}

	@Override
	protected String getTableName() {
		return "phone";
	}
	
	@Override
	public List<IPhone> find(final PhoneFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
        appendSort(filter, sqlTile);
        appendPaging(filter, sqlTile);
        return executeFindQuery(sqlTile.toString());
	}

}

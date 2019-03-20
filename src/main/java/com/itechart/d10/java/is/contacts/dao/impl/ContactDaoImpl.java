package com.itechart.d10.java.is.contacts.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IContactDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.dao.api.enums.Gender;
import com.itechart.d10.java.is.contacts.dao.api.enums.MaritalStatus;
import com.itechart.d10.java.is.contacts.dao.api.filter.ContactFilter;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Address;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Contact;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Workplace;
import com.itechart.d10.java.is.contacts.dao.impl.util.PreparedStatementAction;

public class ContactDaoImpl extends AbsractDaoImpl<IContact, Integer> implements IContactDao {

	@Override
	public IContact createEntity() {
		return new Contact();
	}

	@Override
	public void update(IContact entity) {
		executeStatement(new PreparedStatementAction<IContact>(String.format(
				"update %s set first_name=?, midle_name=?, last_name=?, birthday=?, gender=?, citizenship=?,"
						+ "marital_status=?, website=?, workplase_id=?, address_id=?, updated=? where id=?",
				getTableName())) {

			@Override
			public IContact doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getFirstName());
				pStmt.setString(2, entity.getMidleName());
				pStmt.setString(3, entity.getLastName());
				pStmt.setObject(4, entity.getBirthday());
				pStmt.setString(5, entity.getGender().toString());
				pStmt.setString(6, entity.getCitizenship());
				pStmt.setString(7, entity.getMaritalStatus().toString());
				pStmt.setString(8, entity.getWebsite());
				pStmt.setInt(9, entity.getWorkplace().getId());
				pStmt.setInt(10, entity.getAddress().getId());
				pStmt.setObject(11, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(12, entity.getId());

				pStmt.executeUpdate();
				return entity;
			}

		});

	}

	@Override
	public void insert(IContact entity) {
		executeStatement(new PreparedStatementAction<IContact>(String.format(
				"insert into %s (first_name, midle_name, last_name, birthday, gender, citizenship, marital_status,"
						+ " website, workplace_id, address_id, created, updated) values(?,?,?,?,?,?,?,?,?,?,?,?)",
				getTableName()), true) {

			@Override
			public IContact doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getFirstName());
				pStmt.setString(2, entity.getMidleName());
				pStmt.setString(3, entity.getLastName());
				pStmt.setObject(4, entity.getBirthday());
				pStmt.setString(5, entity.getGender().toString());
				pStmt.setString(6, entity.getCitizenship());
				pStmt.setString(7, entity.getMaritalStatus().toString());
				pStmt.setString(8, entity.getWebsite());
				pStmt.setInt(9, entity.getWorkplace().getId());
				pStmt.setInt(10, entity.getAddress().getId());
				pStmt.setObject(11, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(12, entity.getUpdated(), Types.TIMESTAMP);

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
	protected IContact parseRow(ResultSet resultSet) throws SQLException {
		final IContact entity = createEntity();
		entity.setId(resultSet.getInt("id"));
		entity.setFirstName(resultSet.getString("first_name"));
		entity.setMidleName(resultSet.getString("midle_name"));
		entity.setLastName(resultSet.getString("last_name"));
		entity.setBirthday(resultSet.getDate("birthday"));
		entity.setGender(Gender.valueOf(resultSet.getString("gender")));
		entity.setCitizenship(resultSet.getString("citizenship"));
		entity.setMaritalStatus(MaritalStatus.valueOf(resultSet.getString("marital_status")));
		entity.setWebsite(resultSet.getString("website"));
		
		final IWorkplace workplace = new Workplace();
		workplace.setId(resultSet.getInt("workplace_id"));
		entity.setWorkplace(workplace);
		
		final IAddress address = new Address();
		address.setId(resultSet.getInt("address_id"));
		entity.setAddress(address);
		
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		
		return entity;
	}

	@Override
	protected String getTableName() {
		return "contact";
	}

	@Override
	public List<IContact> find(final ContactFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
        appendSort(filter, sqlTile);
        appendPaging(filter, sqlTile);
        return executeFindQuery(sqlTile.toString());
	}
	
	


}

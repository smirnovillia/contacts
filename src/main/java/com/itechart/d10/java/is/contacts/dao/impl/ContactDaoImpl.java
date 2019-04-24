package com.itechart.d10.java.is.contacts.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IContactDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.enums.Gender;
import com.itechart.d10.java.is.contacts.dao.api.enums.MaritalStatus;
import com.itechart.d10.java.is.contacts.dao.api.filter.ContactFilter;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Contact;
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
						+ "marital_status=?, website=?, email=?, company=?, country=?, city=?, street=?, house_number=?, apartment=?, zip=?, updated=? where id=?",
				getTableName())) {

			@Override
			public IContact doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getFirstName());
				pStmt.setString(2, entity.getMidleName());
				pStmt.setString(3, entity.getLastName());
				pStmt.setObject(4, entity.getBirthday(), Types.DATE);
				pStmt.setString(5, entity.getGender().toString());
				pStmt.setString(6, entity.getCitizenship());
				pStmt.setString(7, entity.getMaritalStatus().toString());
				pStmt.setString(8, entity.getWebsite());
                                pStmt.setString(9, entity.getEmail());
				pStmt.setString(10, entity.getCompany());
				pStmt.setString(11, entity.getCountry());
				pStmt.setString(12, entity.getCity());
				pStmt.setString(13, entity.getStreet());
				pStmt.setString(14, entity.getHouseNumber());
				 if(entity.getApartment() == null) {
                                    pStmt.setInt(15, java.sql.Types.NULL);
                                } else{
                                    pStmt.setInt(15, entity.getApartment());
                                }
				pStmt.setString(16, entity.getZip());
				pStmt.setObject(17, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(18, entity.getId());

				pStmt.executeUpdate();
				return entity;
			}

		});

	}

	@Override
	public void insert(IContact entity) {
		executeStatement(new PreparedStatementAction<IContact>(String.format(
				"insert into %s (first_name, midle_name, last_name, birthday, gender, citizenship, marital_status,"
						+ " website, email, company, country, city, street, house_number, apartment, zip, created, updated) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				getTableName()), true) {

			@Override
			public IContact doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getFirstName());
				pStmt.setString(2, entity.getMidleName());
				pStmt.setString(3, entity.getLastName());
				pStmt.setObject(4, entity.getBirthday(), Types.DATE);
				pStmt.setString(5, entity.getGender().toString());
				pStmt.setString(6, entity.getCitizenship());
				pStmt.setString(7, entity.getMaritalStatus().toString());
				pStmt.setString(8, entity.getWebsite());
                                pStmt.setString(9, entity.getEmail());
				pStmt.setString(10, entity.getCompany());
				pStmt.setString(11, entity.getCountry());
				pStmt.setString(12, entity.getCity());
				pStmt.setString(13, entity.getStreet());
				pStmt.setString(14, entity.getHouseNumber());
                                if(entity.getApartment() == null) {
                                    pStmt.setInt(15, java.sql.Types.NULL);
                                } else{
                                    pStmt.setInt(15, entity.getApartment());
                                }
				pStmt.setString(16, entity.getZip());
				pStmt.setObject(17, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(18, entity.getUpdated(), Types.TIMESTAMP);

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
                entity.setEmail(resultSet.getString("email"));
                entity.setCompany(resultSet.getString("company"));
		entity.setCountry(resultSet.getString("country"));
		entity.setCity(resultSet.getString("city"));
		entity.setStreet(resultSet.getString("street"));
		entity.setHouseNumber(resultSet.getString("house_number"));
                Integer apartment = resultSet.getInt("apartment");
		entity.setApartment(apartment);
		entity.setZip(resultSet.getString("zip"));
		
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

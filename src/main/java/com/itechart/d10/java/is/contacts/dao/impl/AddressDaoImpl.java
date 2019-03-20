package com.itechart.d10.java.is.contacts.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IAddressDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IAddress;
import com.itechart.d10.java.is.contacts.dao.api.filter.AddressFilter;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Address;
import com.itechart.d10.java.is.contacts.dao.impl.util.PreparedStatementAction;

public class AddressDaoImpl extends AbsractDaoImpl<IAddress, Integer> implements IAddressDao{

	@Override
	public IAddress createEntity() {
		return new Address();
	}

	@Override
	public void update(IAddress entity) {
		executeStatement(new PreparedStatementAction<IAddress>(
				String.format("update %s set country=?, city=?, street=?, house_number=?, apartment=?"
						+ "updated=? where id=?", getTableName())) {

			@Override
			public IAddress doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getCountry());
				pStmt.setString(2, entity.getCity());
				pStmt.setString(3, entity.getStreet());
				pStmt.setString(4, entity.getHouseNumber());
				pStmt.setInt(5, entity.getApartment());
				pStmt.setObject(6, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(7, entity.getId());
				
				pStmt.executeUpdate();
				
				return entity;
			}

		});

	}

	@Override
	public void insert(IAddress entity) {
		executeStatement(new PreparedStatementAction<IAddress>(
				String.format("insert into %s (country, city, street, house_number, apartment, created"
						+ "updated) values (?,?,?,?,?,?,?)", getTableName()),
				true) {

			@Override
			public IAddress doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getCountry());
				pStmt.setString(2, entity.getCity());
				pStmt.setString(3, entity.getStreet());
				pStmt.setString(4, entity.getHouseNumber());
				pStmt.setInt(5, entity.getApartment());
				pStmt.setObject(6, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(7, entity.getUpdated(), Types.TIMESTAMP);
				
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
	protected IAddress parseRow(ResultSet resultSet) throws SQLException {
		final IAddress entity = createEntity();
		entity.setId(resultSet.getInt("id"));
		entity.setCountry(resultSet.getString("country"));
		entity.setCity(resultSet.getString("city"));
		entity.setStreet(resultSet.getString("street"));
		entity.setHouseNumber(resultSet.getString("house_number"));
		entity.setApartment(resultSet.getInt("apartment"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		
		return entity;
	}

	@Override
	protected String getTableName() {
		return "address";
	}
	
	@Override
	public List<IAddress> find(final AddressFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
        appendSort(filter, sqlTile);
        appendPaging(filter, sqlTile);
        return executeFindQuery(sqlTile.toString());
	}

}

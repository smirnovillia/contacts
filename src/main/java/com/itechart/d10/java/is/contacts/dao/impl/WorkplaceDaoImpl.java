package com.itechart.d10.java.is.contacts.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.itechart.d10.java.is.contacts.dao.api.IWorkplaceDao;
import com.itechart.d10.java.is.contacts.dao.api.entity.IWorkplace;
import com.itechart.d10.java.is.contacts.dao.api.filter.WorkplaceFilter;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Workplace;
import com.itechart.d10.java.is.contacts.dao.impl.util.PreparedStatementAction;

public class WorkplaceDaoImpl extends AbsractDaoImpl<IWorkplace, Integer> implements IWorkplaceDao {

	@Override
	public IWorkplace createEntity() {
		return new Workplace();
	}

	@Override
	public void update(IWorkplace entity) {
		executeStatement(new PreparedStatementAction<IWorkplace>(
				String.format("update %s set company=?, updated=?, where id=?", getTableName())) {

			@Override
			public IWorkplace doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getCompany());
				pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(3, entity.getId());
				pStmt.executeUpdate();
				
				return entity;
			}

		});

	}

	@Override
	public void insert(IWorkplace entity) {
		executeStatement(new PreparedStatementAction<IWorkplace>(
				String.format("insert into %s (company, created, updated) values(?,?,?)", getTableName()), true) {

			@Override
			public IWorkplace doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getCompany());
				pStmt.setObject(2, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
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
	protected String getTableName() {
		return "workplace";
	}
	
	@Override
	public List<IWorkplace> find(final WorkplaceFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
        appendSort(filter, sqlTile);
        appendPaging(filter, sqlTile);
        return executeFindQuery(sqlTile.toString());
	}

}

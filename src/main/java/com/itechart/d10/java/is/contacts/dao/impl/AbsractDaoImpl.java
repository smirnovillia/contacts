package com.itechart.d10.java.is.contacts.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import com.itechart.d10.java.is.contacts.dao.api.IBaseDao;
import com.itechart.d10.java.is.contacts.dao.api.filter.AbstractFilter;
import com.itechart.d10.java.is.contacts.dao.impl.util.PreparedStatementAction;
import com.itechart.d10.java.is.contacts.dao.impl.util.SQLExecutionException;
import com.itechart.d10.java.is.contacts.dao.impl.util.StatementAction;

public abstract class AbsractDaoImpl<ENTITY, ID> implements IBaseDao<ENTITY, ID> {


	@Override
	public ENTITY getById(final ID id) {
		return executeStatement((statement) -> {
			statement.executeQuery("select * from " + getTableName() + " where id=" + id);

			final ResultSet resultSet = statement.getResultSet();
			final Set<String> columns = resolveColumnNames(resultSet);

			final boolean hasNext = resultSet.next();
			ENTITY result = null;
			if (hasNext) {
				result = parseRow(resultSet, columns);
			}

			resultSet.close();
			return result;
		});
	}

	@Override
	public List<ENTITY> getAll() {
		return executeStatement(new StatementAction<List<ENTITY>>() {
			@Override
			public List<ENTITY> doWithStatement(final Statement statement) throws SQLException {
				statement.executeQuery("select * from " + getTableName());

				final ResultSet resultSet = statement.getResultSet();
				final Set<String> columns = resolveColumnNames(resultSet);
				final List<ENTITY> result = new ArrayList<>();
				boolean hasNext = resultSet.next();
				while (hasNext) {
					result.add(parseRow(resultSet, columns));
					hasNext = resultSet.next();
				}
				resultSet.close();
				return result;
			}
		});
	}

	@Override
	public void deleteById(final ID id) {
		executeStatement(
				new PreparedStatementAction<Integer>(String.format("delete from %s where id=?", getTableName())) {
					@Override
					public Integer doWithPreparedStatement(final PreparedStatement prepareStatement)
							throws SQLException {
						prepareStatement.setObject(1, id);
						return prepareStatement.executeUpdate();
					}
				});
	}

	@Override
	public void deleteAll() {
		executeStatement(new PreparedStatementAction<Integer>("delete from " + getTableName()) {
			@Override
			public Integer doWithPreparedStatement(final PreparedStatement prepareStatement) throws SQLException {
				final int executeUpdate = prepareStatement.executeUpdate();
				return executeUpdate;
			}
		});
	}

	protected <T> T executeStatement(final StatementAction<T> action) {
		try (Connection c = getConnection(); Statement stmt = c.createStatement()) {
			c.setAutoCommit(false);
			return action.doWithStatement(stmt);

		} catch (final SQLException e) {
			throw new SQLExecutionException(e); 
		}
	}

	protected <T> T executeStatement(final PreparedStatementAction<T> action) {
		try (Connection c = getConnection();
				PreparedStatement pStmt = action.isReturnGeneratedKeys()
						? c.prepareStatement(action.getSql(), Statement.RETURN_GENERATED_KEYS)
						: c.prepareStatement(action.getSql())) {
			c.setAutoCommit(false);
			try {
				final T doWithPreparedStatement = action.doWithPreparedStatement(pStmt);
				c.commit();
				return doWithPreparedStatement;
			} catch (final Exception e) {
				c.rollback();
				throw new RuntimeException(e);
			}

		} catch (final SQLException e) {
			throw new SQLExecutionException(e);
		}
	}

	protected List<ENTITY> executeFindQuery(final String sqlFragment) {
		return executeFindQueryWithCustomSelect(String.format("select * from %s %s", getTableName(), sqlFragment));
	}

	protected List<ENTITY> executeFindQueryWithCustomSelect(final String fullSql) {
		return executeStatement(new StatementAction<List<ENTITY>>() {
			@Override
			public List<ENTITY> doWithStatement(final Statement statement) throws SQLException {
				statement.executeQuery(fullSql);

				final ResultSet resultSet = statement.getResultSet();

				final Set<String> columns = resolveColumnNames(resultSet);

				final List<ENTITY> result = new ArrayList<>();
				boolean hasNext = resultSet.next();
				while (hasNext) {
					result.add(parseRow(resultSet, columns));
					hasNext = resultSet.next();
				}
				resultSet.close();
				return result;
			}

		});
	}

	protected long executeCountQuery(final String sql) {
		return executeStatement(new StatementAction<Long>() {
			@Override
			public Long doWithStatement(final Statement statement) throws SQLException {
				final String fullSql = String.format("select count(*) as total from %s %s", getTableName(), sql);

				statement.executeQuery(fullSql);

				final ResultSet resultSet = statement.getResultSet();
				resultSet.next();

				final long total = resultSet.getLong("total");
				resultSet.close();
				return total;
			}
		});
	}

	private Set<String> resolveColumnNames(final ResultSet resultSet) throws SQLException {
		final ResultSetMetaData rsMetaData = resultSet.getMetaData();
		final int numberOfColumns = rsMetaData.getColumnCount();
		final Set<String> columns = new HashSet<>();
		for (int i = 1; i <= numberOfColumns; i++) {
			columns.add(rsMetaData.getColumnName(i));
		}
		return columns;
	}

	protected Connection getConnection() throws SQLException {
		InitialContext initContext = null;
		try {
			initContext = new InitialContext();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		DataSource ds = null;
		try {
			ds = (DataSource) initContext.lookup("java:comp/env/jdbc/postgres");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ds.getConnection();
	}

	protected ENTITY parseRow(final ResultSet resultSet) throws SQLException {
		throw new UnsupportedOperationException();
	};

	protected ENTITY parseRow(final ResultSet resultSet, final Set<String> columns) throws SQLException {
		return parseRow(resultSet);
	};
	
    protected void appendSort(final AbstractFilter filter, final StringBuilder sql) {
        final String sortColumn = filter.getSortColumn();
        final Boolean sortOrder = filter.getSortOrder();

        if (sortColumn != null) {
            sql.append(String.format(" order by %s", sortColumn));

            if (sortOrder != null) {
                sql.append(" ");
                sql.append(sortOrder ? "asc" : "desc");
            }
        }
    }
    
    protected void appendPaging(final AbstractFilter filter, final StringBuilder sql) {
        final Integer limit = filter.getLimit();
        final Integer offset = filter.getOffset();

        if (limit != null) {
            sql.append(" limit " + limit);
        }

        if (offset != null) {
            sql.append(" offset " + offset);
        }
    }

	protected abstract String getTableName();

}

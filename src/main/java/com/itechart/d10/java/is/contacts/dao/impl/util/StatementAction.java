package com.itechart.d10.java.is.contacts.dao.impl.util;

import java.sql.SQLException;
import java.sql.Statement;

public interface StatementAction<RETURN_TYPE> {

	 RETURN_TYPE doWithStatement(Statement stmt) throws SQLException;
}

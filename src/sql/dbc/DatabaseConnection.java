package sql.dbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnection {

	private static final String DATA_SOURCE_NAME = "java:comp/env/jdbc/remote_builder";

	public static Connection getConnection() throws NamingException, SQLException {
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup(DATA_SOURCE_NAME);
		return dataSource.getConnection();
	}
}

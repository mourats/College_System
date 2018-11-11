package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class responsible for creating a connection to the database.
 *
 * @author thiagomoura21
 */
public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/COLLEGE_SYSTEM", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
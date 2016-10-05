/**
 * 
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

import com.util.SqlConfig;

/**
 * @author Sumit
 *
 */
public class ConnectionManager {

	private Connection connection;

	public Connection getConnection() {
		try {
			Class.forName(SqlConfig.getValue("jdbc.driver"));
			connection = DriverManager.getConnection(SqlConfig.getValue("jdbc.url"),
					SqlConfig.getValue("jdbc.username"), SqlConfig.getValue("jdbc.password"));
		} catch (Exception e) {

		}
		return connection;
	}
}

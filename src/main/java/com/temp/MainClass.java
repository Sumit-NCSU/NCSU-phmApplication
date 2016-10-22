/**
 * 
 */
package com.temp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.database.ConnectionManager;
import com.database.SelectQueries;
import com.exception.PhmException;
import com.model.AlertDTO;

/**
 * @author Sumit
 */
public class MainClass {

	/**
	 * @param args
	 * @throws PhmException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws PhmException, SQLException {
		ConnectionManager conM = new ConnectionManager();
		Connection con = conM.getConnection();
		List<AlertDTO> a = SelectQueries.getAllAlerts(con);
		for (AlertDTO alertDTO : a) {
			System.out.println("AlertID: " + alertDTO.getAlertId());
			System.out.println("PersonID: " + alertDTO.getPersonId());
			System.out.println("Description: " + alertDTO.getDescription());
		}
		con.close();
	}

}

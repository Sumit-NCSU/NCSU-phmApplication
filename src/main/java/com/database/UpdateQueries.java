package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.PhmException;
import com.util.StringsUtil;

/**
 * @author Sumit
 *
 */
public class UpdateQueries {

	/**
	 * Method to update the alert table in database and set the is viewed column
	 * as true. If flag clear mandatory is set then mandatory alerts are also
	 * cleared.
	 * 
	 * @param clearMandatory
	 *            if mandatory alerts need to be cleared as well.
	 * @return boolean value indicating that alerts were cleared successfully
	 */
	public static boolean clearAlerts(boolean clearMandatory) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * Method to update Person table database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of PersonDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static boolean updatePersonProfile(Connection connection, String personId, String fullname, String password, String address) throws PhmException {
		boolean status = false;
		try {
			PreparedStatement ps = connection.prepareStatement(StringsUtil.UPDATE_PERSON_PROFILE);
			ps.setString(1, fullname);
			ps.setString(2, password);
			ps.setString(3, address);
			ps.setString(4, personId);			
			int rows = ps.executeUpdate();
			
			if(rows > 0)
				status = true;
			else
				status = false;
			
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Persons." + e.getMessage());
			throw new PhmException("Failed to fetch all Persons." + e.getMessage());
		}
		return status;
	}
	
	/**
	 * Method to delete Disease from Record Disease.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static boolean deletePatientDisease(Connection connection, String personId, int diseaseId) throws PhmException {
		boolean status = false;
		try {
			PreparedStatement ps = connection.prepareStatement(StringsUtil.DELETE_RECORD_DISEASE);
			ps.setString(1, personId);
			ps.setInt(2,diseaseId);			
			int rows = ps.executeUpdate();
			if(rows > 0)
				status = true;
			else
				status = false;
			
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Persons." + e.getMessage());
			throw new PhmException("Failed to fetch all Persons." + e.getMessage());
		}
		return status;
	}
}

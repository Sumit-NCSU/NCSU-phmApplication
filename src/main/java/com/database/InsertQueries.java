/**
 * 
 */
package com.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.exception.PhmException;
import com.model.PersonDTO;

/**
 * @author Sumit
 *
 */
public class InsertQueries {

	public static boolean insertPerson(Connection connection, PersonDTO personDTO) throws PhmException {
		String insertQuery = "INSERT INTO Person (P_ID, PNAME, USERNAME, PASSWORD, ADDRESS, DOB, GENDER) VALUES ("
				+ personDTO.getPersonId() + ", '" + personDTO.getPersonName() + "', '" + personDTO.getUsername()
				+ "', '" + personDTO.getPassword() + "', '" + personDTO.getAddress() + "', '" + personDTO.getDob()
				+ "', '" + personDTO.getGender() + "')";
		try {
			int count = connection.createStatement().executeUpdate(insertQuery);
			if (count == 0) {
				throw new PhmException("Inserting Person failed. Insert Count = 0");
			}
		} catch (SQLException e) {
			throw new PhmException("Errror While inserting Person" + e.getMessage());
		}
		return true;
	}
}

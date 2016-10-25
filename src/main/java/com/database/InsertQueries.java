/**
 * 
 */
package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.exception.PhmException;
import com.model.PersonDTO;
import com.util.StringsUtil;

/**
 * @author Sumit
 *
 */
public class InsertQueries {

	public static boolean insertPerson(Connection connection, PersonDTO personDTO) throws PhmException, java.text.ParseException {
		
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		 
		try {
			PreparedStatement ps = connection.prepareStatement(StringsUtil.INSERT_PERSON);
			ps.setString(1, personDTO.getPersonId());
			ps.setString(2, personDTO.getPersonName());
			ps.setString(3, personDTO.getUsername());
			ps.setString(4, personDTO.getPassword());
			ps.setString(5, personDTO.getAddress());
			java.util.Date utilDate = formatter.parse(personDTO.getDob());
			java.sql.Date dob_date =  new java.sql.Date(utilDate.getTime());
			ps.setDate(6, dob_date);
			ps.setString(7, personDTO.getGender());
			
			ps.executeUpdate();
			System.out.println("User has been added.!");
		} catch (SQLException e) {
			throw new PhmException("Errror While inserting Person " + e.getMessage());
		}
		return true;
	}
}

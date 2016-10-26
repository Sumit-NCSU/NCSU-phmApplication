package com.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.database.ConnectionManager;
import com.database.SelectQueries;
import com.exception.PhmException;
import com.model.PersonDTO;

/*
 * @author Animesh
 * 
 */

public class Patient {

	public static void showScreen(PersonDTO health_supporter) throws PhmException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("List of Your Patients");
		Connection con = new ConnectionManager().getConnection();
		List<PersonDTO> patient_list = SelectQueries.getMyPatients(con, health_supporter.getPersonId());
		
		con.close();
	}


}

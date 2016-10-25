package com.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.database.ConnectionManager;
import com.database.SelectQueries;
import com.exception.PhmException;
import com.model.ObservationDTO;
import com.model.PersonDTO;

/*
 * @author Animesh
 * 
 */
public class Observation {

	public void showObservations(PersonDTO person) throws PhmException {
		// TODO Auto-generated method stub
		Connection con = new ConnectionManager().getConnection();
		List<ObservationDTO> observationDTOs = SelectQueries.getPersonObservations(con, person.getPersonId());
		int count=0,input;
		String observation_type = null;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		if( null != observationDTOs)
		{
			for(ObservationDTO obs : observationDTOs) {
				System.out.println("\nObservation No. " + ++count);
				System.out.print("Observation Value: " + obs.getObservationValue() + "\t");
				observation_type = SelectQueries.getObservationType(con, obs.getObservationId());
				System.out.print("Observation Type: " + observation_type + "\t");
				System.out.println();
				System.out.print("Observation Time: " + obs.getObservationTime() + "\t");
				System.out.print("Recorded Time: " + obs.getRecordTime());
				System.out.println();
			}
		}
		else
		{
			System.out.println("No Observation found.");
		}
		
		while(flag)
		{
			System.out.println("\n1. Go Back");
			input = Integer.valueOf(sc.nextLine());
			
			if(input == 1)
				flag = false;
			else
				System.out.println("Type 1 to go back");
		}
		
	}

	public void enterObservations(String person_id, String health_supporter_id) {
		// TODO Auto-generated method stub
		
	}
	
	

}

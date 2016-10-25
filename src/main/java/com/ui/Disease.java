package com.ui;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.database.ConnectionManager;
import com.database.SelectQueries;
import com.exception.PhmException;
import com.model.ObservationDTO;
import com.model.PersonDTO;
import com.model.RecordDiseaseDTO;
import com.util.StringsUtil;

/*
 * @author Animesh
 * 
 */

public class Disease {

	public void viewDiseases(PersonDTO person) throws PhmException {
		// TODO Auto-generated method stub
		Connection con = new ConnectionManager().getConnection();
		 List<RecordDiseaseDTO> recordDiseaseDTOs = SelectQueries.getPersonDiseases(con, person.getPersonId());
		int count=0,input;
		String disease_name = null;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		if( null != recordDiseaseDTOs)
		{
			for(RecordDiseaseDTO rec : recordDiseaseDTOs) {
				System.out.println("\nDisease No. " + ++count);
				disease_name = SelectQueries.getDiseaseName(con, rec.getDiseaseId());
				System.out.print("Disease Name: " + disease_name + "\t");
				System.out.print("Recorded Time: " + rec.getRecordTime());
				System.out.println();
			}
		}
		else
		{
			System.out.println("No Disease found.");
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

	public void enterDiseases(PersonDTO person) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Enter New Disease");
			
			System.out.println("Enter full name: ");
			String name = sc.nextLine();
			System.out.println("Enter a Username: ");
			String username = sc.nextLine();
			System.out.println("Enter a Password: ");
			String password = sc.nextLine();
			System.out.println("Enter Address: ");
			String address = sc.nextLine();
			System.out.println("Enter DOB (MM/dd/yyyy): ");
			String dob = sc.nextLine();
			System.out.println("Enter Gender: ");
			String gender = sc.nextLine();
			// TODO: auto-generate person ID?
			PersonDTO person1 = new PersonDTO(null, name, username, password, address, dob, gender);
			/*boolean status = insertPerson(person1);
			if (status) {
				System.out.println("Account Created Successfully");
				flag = false;
				break;
			} else {
				// TODO: implement error handling logic here.
				System.out.println("Failed to create account");
			}*/
		}
	}
	
	

}

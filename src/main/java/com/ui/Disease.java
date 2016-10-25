package com.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.database.ConnectionManager;
import com.database.InsertQueries;
import com.database.SelectQueries;
import com.database.UpdateQueries;
import com.exception.PhmException;
import com.model.DiseaseDTO;
import com.model.PersonDTO;
import com.model.RecordDiseaseDTO;
import com.util.StringsUtil;

/*
 * @author Animesh
 * 
 */

public class Disease {

	public static void showScreen(PersonDTO person) {
		// TODO Auto-generated method stub
		try{
	
			Scanner sc = new Scanner(System.in);
			boolean flag = true;
			int input=-1;
			
			while (flag) {
				sc = new Scanner(System.in);
				System.out.println(StringsUtil.LOGIN_MESSAGE);
				System.out.println("Select an option ");
				System.out.println("1. View Diseases");
				System.out.println("2. Add New Disease");
				System.out.println("3. Delete Disease");
				System.out.println("4. Go Back");
			
				input = Integer.valueOf(sc.nextLine());	
				
				switch (input) 
				{
					case 1:
						viewDiseases(person);
						break;
					case 2:
						enterDiseases(person);
						break;
					case 3:
						deleteDisease(person);
						break;
					case 4:
						flag = false;
						break;
					default:
						System.out.println("Invalid option. Try again.!");			
						break;
					}
				}
			}catch (Exception pe){
				System.out.println("ERROR" + pe.getMessage());
				pe.printStackTrace();
				}
	}

	

	private static void viewDiseases(PersonDTO person) throws PhmException, SQLException {
		// TODO Auto-generated method stub
		Connection con = new ConnectionManager().getConnection();
		List<RecordDiseaseDTO> recordDiseaseDTOs = SelectQueries.getPersonDiseases(con, person.getPersonId());
		con.close();
		
		int count = 0, input;
		String disease_name = null;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		if (null != recordDiseaseDTOs) {
			for (RecordDiseaseDTO rec : recordDiseaseDTOs) {
				System.out.println("\nDisease No. " + ++count);
				disease_name = SelectQueries.getDiseaseName(con, rec.getDiseaseId());
				System.out.print("Disease Name: " + disease_name + "\t");
				System.out.print("Recorded Time: " + rec.getRecordTime());
				System.out.println();
			}
		} else {
			System.out.println("No Disease found.");
		}

	}

	private static void enterDiseases(PersonDTO person) throws PhmException, SQLException, ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		Connection con = new ConnectionManager().getConnection();
		List<DiseaseDTO> all_diseases = SelectQueries.getAllDiseases(con);
		
		for(DiseaseDTO disease: all_diseases)
		{
			System.out.println(disease.getDiseaseId() + ". " + disease.getDiseaseName());
		}
		
		while (flag) {
			
			System.out.println("Enter New Disease from above List.");

			System.out.println("\nEnter Disease Number: ");
			int diseaseId = Integer.valueOf(sc.nextLine());
			
			RecordDiseaseDTO new_disease = new RecordDiseaseDTO(person.getPersonId(),diseaseId, null);
			
			boolean status = InsertQueries.recordDisease(con, new_disease);
			con.close();
			if (status) {
				System.out.println("Disease recorded successfully.!");
				flag = false;
				break;
			} else {
				System.out.println("Disease couldn't get recorded.");
			}
		}
	}
	
	
	private static void deleteDisease(PersonDTO person) throws PhmException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Connection con = new ConnectionManager().getConnection();
		List<RecordDiseaseDTO> patient_diseases = SelectQueries.getPatientDiseases(con, person.getPersonId());
		System.out.println("List of Diseases diagnosed for you.");
		for(RecordDiseaseDTO record: patient_diseases)
		{
			String disease_name = SelectQueries.getDiseaseName(con, record.getDiseaseId());
			System.out.println(record.getDiseaseId() + ". " + disease_name);
		}
		
		System.out.println("Enter the Disease No. which you want to delete?");
		int input = Integer.valueOf(sc.nextLine());
		int disease_no = input;
		System.out.println("Are you sure, you want to delete Disease No. " + input + " ?" + "\n1. Yes   2. No");
		input = Integer.valueOf(sc.nextLine());
		if(input == 1)
		{
			boolean status = UpdateQueries.deletePatientDisease(con, person.getPersonId(), disease_no);
			
			if(status == true)
				System.out.println("Record deleted successfully.");
			else
				System.out.println("Record couldn't be deleted.");
		}
		else if(input==2)
			return;
		else
			System.out.println("Input invalid, Try again.");
	}
}

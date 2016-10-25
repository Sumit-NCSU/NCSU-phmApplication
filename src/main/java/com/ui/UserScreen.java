/**
 * 
 */
package com.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.database.ConnectionManager;
import com.database.SelectQueries;
import com.database.UpdateQueries;
import com.exception.PhmException;
import com.model.PersonDTO;
import com.util.StringsUtil;

/**
 * @author Sumit
 *
 */
public class UserScreen {

	public void showUserScreen(PersonDTO person) throws PhmException {
		try{
			System.out.println("Hello, " + person.getPersonName());
			
			boolean checkHealthSup = checkHealthSupporter(person);
			Scanner sc = new Scanner(System.in);
			boolean flag = true;
			int input=-1;
			
			while (flag) {
				sc = new Scanner(System.in);
				System.out.println(StringsUtil.LOGIN_MESSAGE);
				System.out.println("Select an option ");
				System.out.println("1. Profile");
				System.out.println("2. Diagnoses");
				System.out.println("3. Health Indicators");
				System.out.println("4. Alerts");
				System.out.println("5. Health Supporters");
				
				if(checkHealthSup)
				{
					System.out.println("\n\nYou are a Health Supporter");
					System.out.println("7. View Patient(s)");
				}
				
				System.out.println("0. Log Out");
				System.out.println("Enter Choice: ");
				input = Integer.valueOf(sc.nextLine());	
				
				switch (input) {
				case 0:
					System.out.println("Bye " + person.getPersonName());
					flag = false;
					break;
				case 1:
					personalize(person);
					break;
				case 2:
					Disease.showScreen(person);
					break;
				case 3:
					Recommendation.showScreen(person);
					break;
				case 4:
					AlertScreen.showScreen(person.getPersonId(),null);
					break;
				case 5:
					HealthSupporter.showScreen(person);
					break;
				case 7:
					if(checkHealthSup)
					{
						Patient.showScreen(person);
					}
					else
					{
						System.out.println("Invalid option. Try again.!");
					}
					break;
				default:
					System.out.println("Invalid option. Try again.!");			
					break;
					
				/*
				System.out.println("1. View Observation");
				System.out.println("2. Enter Observation");
				System.out.println("3. View Disease(s)");
				System.out.println("4. Enter New Disease");
				System.out.println("5. View Alerts");
				System.out.println("6. Add/Update Health Supporters");
				System.out.println("7. View Standard Recommendation");
				System.out.println("8. View Specific Recommendation");
				
				case 0:
					System.out.println("Bye " + person.getPersonName());
					flag = false;
					break;
				case 1:
					Observation view_observation = new Observation();
					view_observation.showObservations(person);
					break;
				case 2:
					Observation add_observation = new Observation();
					add_observation.enterObservations(person.getPersonId(), null);
					break;
				case 3:
					Disease list_diseases = new Disease();
					list_diseases.viewDiseases(person);
					break;
				case 4:
					Disease add_disease = new Disease();
					add_disease.enterDiseases(person);
				case 5:
					//AlertScreen alert = new AlertScreen();
					//alert.showScreen(person.getPersonId(),null);
					break;
				case 6:
					HealthSupporter edit_HP = new HealthSupporter();
					edit_HP.showScreen(person);
					break;
				case 7:
					StandardRecommendation standard = new StandardRecommendation();
					standard.viewStandRecommedations(person);
					break;
				case 8:
					SpecificRecommendation specific = new SpecificRecommendation();
					specific.viewSpeciRecommendations(person);
					break;
				case 9:
					if(checkHealthSup)
					{
						Patient patient = new Patient();
						patient.showScreen(person);
					}
					else
					{
						System.out.println("Invalid option. Try again.!");
					}
					break;
				default:
					System.out.println("Invalid option. Try again.!");			
					break;*/
				}
			}
		} catch (Exception pe) {
			System.out.println("ERROR" + pe.getMessage());
			pe.printStackTrace();
		}
		
		
		//view alerts
		//add health supporter
		//remove health supporter
		//add disease
		//record observation
		//view recommendations
		// --conditional (if person is a HS): add recommendation
		// --conditional (if person is a HS): add recommendation
	}

	private void personalize(PersonDTO person) throws PhmException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		boolean flag1 = true;
		int input1=-1;
		while (flag1) {
			sc1 = new Scanner(System.in);
			System.out.println(StringsUtil.LOGIN_MESSAGE);
			System.out.println("Select an option ");
			System.out.println("1. View Profile");
			System.out.println("2. Edit Profile");
			System.out.println("3. Go Back");
			
			System.out.println("Enter Choice: ");
			input1 = Integer.valueOf(sc1.nextLine());	
			
			switch (input1) {
			
			case 1:
				viewProfile(person);
				break;
			case 2:
				editProfile(person);
				break;
			case 3:
				flag1 = false;
				break;
			default:
				System.out.println("Invalid option. Try again.!");			
				break;
			}	
		}
		
	}
	
	private void viewProfile(PersonDTO person) throws PhmException, SQLException
	{
		System.out.println("Your Profile");
		System.out.println("Name: \t\t" + person.getPersonName());
		System.out.println("Username: \t\t" + person.getUsername());
		System.out.println("Date of Birth: \t" + person.getDob());
		System.out.println("Address: \t\t" + person.getAddress());
		System.out.println("Gender: t\t" + person.getGender());
		Connection con = new ConnectionManager().getConnection();
		String status = SelectQueries.getPatientType(con, person.getPersonId());
		System.out.println("You are in a " + status + " Patient category.");
		con.close();
	}
	
	private void editProfile(PersonDTO person) throws PhmException, SQLException
	{
		System.out.println("Edit Exisiting Profile");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter full name: ");
		String fullname = sc.nextLine();
		System.out.println("Enter a Password: ");
		String password = sc.nextLine();
		System.out.println("Enter Address: ");
		String address = sc.nextLine();
		
		Connection con = new ConnectionManager().getConnection();
		boolean status = UpdateQueries.updatePersonProfile(con, person.getPersonId(),fullname,password,address);
		if(status)
			System.out.println("Profile Update Successfully.");
		con.close();
	}

	private boolean checkHealthSupporter(PersonDTO person) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

/**
 * 
 */
package com.ui;

import java.util.Scanner;

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
				System.out.println("1. View Observation");
				System.out.println("2. Enter Observation");
				System.out.println("3. View Disease(s)");
				System.out.println("4. Enter New Disease");
				System.out.println("5. View Alerts");
				System.out.println("6. Add/Update Health Supporters");
				System.out.println("7. View Standard Recommendation");
				System.out.println("8. View Specific Recommendation");
				
				if(checkHealthSup)
				{
					System.out.println("\n9. View Patients");
				}
				System.out.println("\n0. Log Out");
				System.out.println("Enter Choice: ");
				input = Integer.valueOf(sc.nextLine());	
				
				switch (input) {
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
					break;
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

	private boolean checkHealthSupporter(PersonDTO person) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

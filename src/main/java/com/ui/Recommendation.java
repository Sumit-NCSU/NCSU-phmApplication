package com.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.database.ConnectionManager;
import com.database.InsertQueries;
import com.database.SelectQueries;
import com.exception.PhmException;
import com.model.PersonDTO;
import com.model.RecommendationDTO;
import com.model.RecordDiseaseDTO;
import com.model.SpecificRecommendationDTO;
import com.model.StandardRecommendationDTO;
import com.util.StringsUtil;

public class Recommendation {

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
				System.out.println("1. View Standard Recommendation");
				System.out.println("2. View Specific Recommendation");
				System.out.println("3. Observations");
				System.out.println("4. Go Back");
			
				input = Integer.valueOf(sc.nextLine());	
				
				switch (input) 
				{
					case 1:
						viewStandardRecommendation(person);
						break;
					case 2:
						viewSpecificRecommendation(person);
						break;
					case 3:
						Observation.showScreen(person);
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

	public static void showScreenforHP(PersonDTO health_supporter) {
		// TODO Auto-generated method stub
		try{
			
			Scanner sc = new Scanner(System.in);
			boolean flag = true;
			int input=-1;
			
			while (flag) {
				sc = new Scanner(System.in);
				System.out.println(StringsUtil.LOGIN_MESSAGE);
				System.out.println("Select an option ");
				System.out.println("1. View All Recommendation");
				System.out.println("2. Add New Recommendation");
				System.out.println("4. Go Back");
			
				input = Integer.valueOf(sc.nextLine());	
				
				switch (input) 
				{
					case 1:
						viewAllRecommendation();
						break;
					case 2:
						addNewRecommendation();
						break;
					case 3:
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
	
	private static void addNewRecommendation() throws PhmException, SQLException, ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input;
		String obs_typ = null, freq = null, metric = null, lower_limit = null, upper_limit = null, ex_value = null;
		System.out.println("Enter Observation Type: ");
		obs_typ = sc.nextLine();
		System.out.println("Enter Metric: (Measured in?)");
		metric = sc.nextLine();
		System.out.println("Enter Frequency: (No. of Days)");
		freq = sc.nextLine();
		System.out.println("Do you have Limits? \t 1.Yes 2.No");
		if("1".equals(sc.nextLine()))
		{
			System.out.println("Enter Lower Limit: ");
			lower_limit = sc.nextLine();
			System.out.println("Enter Upper Limit: ");
			upper_limit = sc.nextLine();
		}
		else if("2".equals(sc.nextLine()))
		{
			System.out.println("Enter any Expected Value: ");
			ex_value = sc.nextLine();
		}
		else
		{
			System.out.println("Wrong Input. All value will be NULL stored as null.");
		}	
		RecommendationDTO newrecommendation = new RecommendationDTO(0,freq,obs_typ,metric,lower_limit,upper_limit,ex_value);
		Connection con = new ConnectionManager().getConnection();
		boolean status = InsertQueries.insertRecommendation(con, newrecommendation);
		con.close();
		if (status) {
			System.out.println("New Recommendation added successfully.!");
		} else {
			System.out.println("Couldn't add recommendation.");
		}
	}

	private static void viewAllRecommendation() throws PhmException, SQLException {
		// TODO Auto-generated method stub
		Connection con = new ConnectionManager().getConnection();
		List<RecommendationDTO> recommendations= SelectQueries.getAllRecommendations(con);
		
		for(RecommendationDTO list: recommendations)
		{
			System.out.println(list.getRecommendationId() + "Observation Type: " + list.getDescription() + "\n");
			if(null != list.getLowerLimit())
			{
				System.out.print("Lower Bound: " + list.getLowerLimit() + "\t");
			}
			if(null != list.getUpperLimit())
			{
				System.out.print("Upper Bound: " + list.getUpperLimit() + "\t");
			}
			if(null != list.getValue())
			{
				System.out.println();
				System.out.print("Measured in " + list.getMetric() + "\tHaving value: " + list.getValue());
				System.out.print("\t" + "To be checked in frequency of " + list.getFrequency() + " Day(s)");
			}
			else
			{
				System.out.print("Measured in " + list.getMetric());
				System.out.print("\t" + "To be checked in frequency of " + list.getFrequency() + " Day(s)");
			}	
		}
		con.close();
	}

	private static void viewStandardRecommendation(PersonDTO person) throws PhmException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count=1;
		Connection con = new ConnectionManager().getConnection();
		List<RecordDiseaseDTO> patient_diseases = SelectQueries.getPatientDiseases(con, person.getPersonId());
		
		System.out.println("Standard Recommendations for you ");
		for(RecordDiseaseDTO disease: patient_diseases)
		{
			List<StandardRecommendationDTO> standard_indicators = SelectQueries.getPatientStandardRecommendations(con, disease.getDiseaseId());
			
			for(StandardRecommendationDTO standard: standard_indicators)
			{
				List<RecommendationDTO> recommendations = SelectQueries.getPatientRecommendations(con, standard.getRecommendationId());
			
				for(RecommendationDTO recommendation: recommendations)
				{
					System.out.println(count++ + ". " + "You are suppose to take an obersvation for " + recommendation.getDescription() + ", record it on the frequency of " + recommendation.getFrequency() + " Day(s).");
				}
				
			}
			System.out.println("\n");
		}
		con.close();
	}
	
	private static void viewSpecificRecommendation(PersonDTO person) throws PhmException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count=1;
		Connection con = new ConnectionManager().getConnection();
		
		System.out.println("Specific Recommendations for you ");
		
		List<SpecificRecommendationDTO> specific_indicators = SelectQueries.getPatientSpecificRecommendations(con, person.getPersonId());
			
		for(SpecificRecommendationDTO specific: specific_indicators)
		{
			List<RecommendationDTO> recommendations = SelectQueries.getPatientRecommendations(con, specific.getRecommendationId());
			
			for(RecommendationDTO recommendation: recommendations)
			{
				System.out.println(count++ + ". " + "You are specifically recommended to take an obersvation for " + recommendation.getDescription() + ", record it on the frequency of " + recommendation.getFrequency() + " Day(s).");
			}	
		}
		System.out.println("\n");	
			
		con.close();
		
	}

}

package com.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.database.ConnectionManager;
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

package com.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.database.ConnectionManager;
import com.database.SelectQueries;
import com.database.UpdateQueries;
import com.exception.PhmException;
import com.model.PersonDTO;
import com.model.RecordDiseaseDTO;
import com.model.SickPersonDTO;
import com.model.WellPersonDTO;
import com.util.StringsUtil;

/*
 * @author Animesh
 * 
 */

public class HealthSupporter {

	public static void showScreen(PersonDTO patient) {
		// TODO Auto-generated method stub
try{
			
			Scanner sc = new Scanner(System.in);
			boolean flag = true;
			int input=-1;
			
			//Check whether patient is Well or Sick
			Connection con = new ConnectionManager().getConnection();
			String status = SelectQueries.getPatientType(con, patient.getPersonId());
			con.close();
			
			while (flag) {
				sc = new Scanner(System.in);
				System.out.println(StringsUtil.LOGIN_MESSAGE);
				System.out.println("Select an option ");
				System.out.println("1. View Health Supporter(s)");
				System.out.println("2. Add Health Supporter(s)");
				System.out.println("3. Edit Health Supporter(s)");
				System.out.println("4. Go Back");
			
				input = Integer.valueOf(sc.nextLine());	
				
				switch (input) 
				{
					case 1:
						viewHealthSupporters(patient,status);
						break;
					case 2:
						addHealthSupporters(patient,status);
						break;
					case 3:
						editHealthSupporters(patient,status);
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


	private static void viewHealthSupporters(PersonDTO patient, String status) throws PhmException, SQLException {
		// TODO Auto-generated method stub
		
		if(status.equals("SICK"))
		{
			Connection con = new ConnectionManager().getConnection();
			SickPersonDTO sickPatient = SelectQueries.getSickPersonHealthSupporter(con, patient.getPersonId());
		
			String h_sup_name = null;
			if(null != sickPatient.getHealthSupporter1Id())
			{
				System.out.println("Health Supporter 1 - ");
				h_sup_name = SelectQueries.getPersonName(con, sickPatient.getHealthSupporter1Id());
				System.out.print("\nFullName: " + h_sup_name + "\t");
				System.out.print("Authorized on: " + sickPatient.getHs1AuthDate());
				if(null != sickPatient.getHealthSupporter2Id())
				{
					System.out.println();
					System.out.println("Health Supporter 2 - ");
					h_sup_name = SelectQueries.getPersonName(con, sickPatient.getHealthSupporter2Id());
					System.out.print("\nFullName: " + h_sup_name + "\t");
					System.out.print("Authorized on: " + sickPatient.getHs2AuthDate());
				}
			}
				
			con.close();
		}
		else if(status.equals("WELL"))
		{
			Connection con = new ConnectionManager().getConnection();
			
			WellPersonDTO wellPatient = SelectQueries.getWellPersonHealthSupporter(con, patient.getPersonId());
		
			String h_sup_name = null;
			
			if(null != wellPatient.getHealthSupporter1Id())
			{
				System.out.println("Health Supporter 1 - ");
				h_sup_name = SelectQueries.getPersonName(con, wellPatient.getHealthSupporter1Id());
				System.out.print("\nFullName: " + h_sup_name + "\t");
				System.out.print("Authorized on: " + wellPatient.getHs1AuthDate());
				if(null != wellPatient.getHealthSupporter2Id())
				{
					System.out.println();
					System.out.println("Health Supporter 2: ");
					h_sup_name = SelectQueries.getPersonName(con, wellPatient.getHealthSupporter2Id());
					System.out.print("\nFullName: " + h_sup_name + "\t");
					System.out.print("Authorized on: " + wellPatient.getHs2AuthDate());
				}
			}
			con.close();
		}
	}
	
	
	private static void addHealthSupporters(PersonDTO patient, String status) throws PhmException, SQLException {
		// TODO Auto-generated method stub
		if(status.equals("SICK"))
		{
			Connection con = new ConnectionManager().getConnection();		
			SickPersonDTO sickPatient = SelectQueries.getSickPersonHealthSupporter(con, patient.getPersonId());
			
			Scanner sc = new Scanner(System.in);
			String h_sup_id = null, input = null;
			
			if(null == sickPatient.getHealthSupporter2Id())
			{
				System.out.println("Enter Health Supporter 2 (using username only)");
				input = sc.nextLine();
				h_sup_id = SelectQueries.getPersonId(con, input);
				boolean flag = UpdateQueries.updateSickPersonHealthSupporter2(con, patient.getPersonId(), h_sup_id);
				
				if(flag)
					System.out.println("Health Supporter 2 added successfully.");
				else
					System.out.println("Couldn't add Health Supporter 2.");
			}	
			else
			{
				System.out.println("You already have maximum no. of Health Supporters.");
			}
			con.close();
		}
		else if(status.equals("WELL"))
		{
			Connection con = new ConnectionManager().getConnection();
			
			WellPersonDTO wellPatient = SelectQueries.getWellPersonHealthSupporter(con, patient.getPersonId());
			Scanner sc = new Scanner(System.in);		
			String h_sup_id = null, input = null;
		
			if(null == wellPatient.getHealthSupporter1Id())
			{
				System.out.println("Enter Health Supporter 1 (using username only)");
				input = sc.nextLine();
				h_sup_id = SelectQueries.getPersonId(con, input);
				boolean flag = UpdateQueries.updateWellPersonHealthSupporter1(con, patient.getPersonId(), h_sup_id);
				if(flag)
				{
					System.out.println("Health Supporter 1 successfully added.");
					if(null == wellPatient.getHealthSupporter2Id())
					{
						System.out.println("What to add Health Supporter 2 ?");
						System.out.println("1. Yes \t2. No.");
						input = sc.nextLine();
						if(input.equals("1"))
						{
							System.out.println("Enter Health Supporter 2 (using username only)");
							input = sc.nextLine();
							h_sup_id = SelectQueries.getPersonId(con, input);
							boolean flag1 = UpdateQueries.updateWellPersonHealthSupporter2(con, patient.getPersonId(), h_sup_id);
							if(flag1)
								System.out.println("Health Supporter 2 successfully added.");
							else
								System.out.println("Couldn't add Health Supporter 2.");
							}
						else
						{
							con.close();
							return;
						}
					}
					else
						System.out.println("Couldn't add Health Supporter 1.");
					
				}
				
			}
			con.close();
		}
	}
	
	private static void editHealthSupporters(PersonDTO patient, String status) throws PhmException, SQLException {
		// TODO Auto-generated method stub
		if(status.equals("SICK"))
		{
			Connection con = new ConnectionManager().getConnection();
			boolean flag=true;
			Scanner sc = new Scanner(System.in);
			int input=-1;
			String input1,h_sup_id=null;
			SickPersonDTO sickPatient = SelectQueries.getSickPersonHealthSupporter(con, patient.getPersonId());
			System.out.println("List of your Health Supporter(s)");
			String h_sup_name = null;	
			if(null != sickPatient.getHealthSupporter1Id())
			{
				h_sup_name = SelectQueries.getPersonName(con, sickPatient.getHealthSupporter1Id());
				System.out.println("1. " + h_sup_name);
				if(null != sickPatient.getHealthSupporter2Id())
				{
					h_sup_name = SelectQueries.getPersonName(con, sickPatient.getHealthSupporter2Id());
					System.out.println(sickPatient.getHealthSupporter2Id() + ". " + h_sup_name);
				}
				while(flag)
				{
					System.out.println("Enter which Health Supporter you want to Edit");
					input = Integer.valueOf(sc.nextLine());
					switch(input)
					{
						case 1:
							System.out.println("Editing Health Supporter 1");
							System.out.println("Enter new Health Supporter 1 (using username only)");
							input1 = sc.nextLine();
							h_sup_id = SelectQueries.getPersonId(con, input1);
							boolean flag1 = UpdateQueries.updateSickPersonHealthSupporter1(con, patient.getPersonId(), h_sup_id);
							if(flag1)
								System.out.println("Health Supporter 1 successfully edited.");
							else
								System.out.println("Couldn't edit Health Supporter 1.");
							flag = false;
							break;
						case 2:
							if(null != sickPatient.getHealthSupporter2Id())
							{
								System.out.println("Editing Health Supporter 2");
								System.out.println("Enter new Health Supporter 2 (using username only)");
								input1 = sc.nextLine();
								h_sup_id = SelectQueries.getPersonId(con, input1);
								boolean flag2 = UpdateQueries.updateSickPersonHealthSupporter2(con, patient.getPersonId(), h_sup_id);
								if(flag2)
									System.out.println("Health Supporter 2 successfully edited.");
								else
									System.out.println("Couldn't edit Health Supporter 2.");
								break;
							}
							else
							{
								System.out.println("There is no 2nd Health Supporter for you.");
							}
							flag = false;
							break;
						default:
							System.out.println("Invalid input value.");
							flag = false;
							break;
					}	
				}
			}
			else
				System.out.println("Currently you have no health supporter.");
				
			con.close();
		}
		else if(status.equals("WELL"))
		{
			Connection con = new ConnectionManager().getConnection();
			boolean flag=true;
			Scanner sc = new Scanner(System.in);
			int input=-1;
			String input1,h_sup_id=null;
			WellPersonDTO wellPatient = SelectQueries.getWellPersonHealthSupporter(con, patient.getPersonId());
			System.out.println("List of your Health Supporter(s)");
			String h_sup_name = null;	
			if(null != wellPatient.getHealthSupporter1Id())
			{
				h_sup_name = SelectQueries.getPersonName(con, wellPatient.getHealthSupporter1Id());
				System.out.println("1. " + h_sup_name);
				if(null != wellPatient.getHealthSupporter2Id())
				{
					h_sup_name = SelectQueries.getPersonName(con, wellPatient.getHealthSupporter2Id());
					System.out.println(wellPatient.getHealthSupporter2Id() + ". " + h_sup_name);
				}
				while(flag)
				{
					System.out.println("Enter which Health Supporter you want to Edit");
					input = Integer.valueOf(sc.nextLine());
					switch(input)
					{
						case 1:
							System.out.println("Editing Health Supporter 1");
							System.out.println("Enter new Health Supporter 1 (using username only)");
							input1 = sc.nextLine();
							h_sup_id = SelectQueries.getPersonId(con, input1);
							boolean flag1 = UpdateQueries.updateWellPersonHealthSupporter1(con, patient.getPersonId(), h_sup_id);
							if(flag1)
								System.out.println("Health Supporter 1 successfully edited.");
							else
								System.out.println("Couldn't edit Health Supporter 1.");
							flag = false;
							break;
						case 2:
							if(null != wellPatient.getHealthSupporter2Id())
							{
								System.out.println("Editing Health Supporter 2");
								System.out.println("Enter new Health Supporter 2 (using username only)");
								input1 = sc.nextLine();
								h_sup_id = SelectQueries.getPersonId(con, input1);
								boolean flag2 = UpdateQueries.updateWellPersonHealthSupporter2(con, patient.getPersonId(), h_sup_id);
								if(flag2)
									System.out.println("Health Supporter 2 successfully edited.");
								else
									System.out.println("Couldn't edit Health Supporter 2.");
								break;
							}
							else
							{
								System.out.println("There is no 2nd Health Supporter for you.");
							}
							flag = false;
							break;
						default:
							System.out.println("Invalid input value.");
							flag = false;
							break;
					}	
				}
			}
			else
				System.out.println("Currently you have no health supporter.");
				
			con.close();
		}
	}


}

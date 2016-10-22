/**
 * 
 */
package com.ui;

import java.sql.Connection;
import java.util.Scanner;

import com.database.ConnectionManager;
import com.database.SelectQueries;
import com.exception.PhmException;
import com.model.PersonDTO;
import com.util.StringsUtil;

/**
 * @author Sumit
 *
 */
public class PhmLogin {

	/**
	 * Method to login to database. This method will ask for the userName
	 * (=unityID) and password (=unity password, encrypted))
	 * 
	 * @param username
	 *            the userName
	 * @param password
	 *            the encrypted password
	 * @throws PhmException
	 *             If some error occurs
	 */
	public PersonDTO doLogin(String username, String password) throws PhmException {
		// TODO: password encryption
		Connection con = new ConnectionManager().getConnection();
		PersonDTO person = SelectQueries.getLoginPerson(username, password, con);
		if (person == null) {
			System.out.println("Failed to Login!");
		}
		return person;
	}

	public void showScreen() throws PhmException {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println(StringsUtil.LOGIN_MESSAGE);
			System.out.println("Please Login: ");
			System.out.println("Username:");
			String userName = sc.nextLine();
			System.out.println("Password: ");
			String password = sc.nextLine();
			PersonDTO person = doLogin(userName, password);
			if (person == null) {
				System.out.println("Incorrect Login Credentials");
				System.out.println("Choose Option: ");
				System.out.println("1. Login Again");
				System.out.println("2. Back");
				int option = sc.nextInt();
				if (option == 2) {
					flag = false;
					break;
				}
			} else {
				System.out.println("Login Succesfull");
				flag = false;
			}
		}
		MainUI.showScreen();
		sc.close();
	}

}
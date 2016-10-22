/**
 * 
 */
package com.ui;

import java.util.Scanner;

import com.util.StringsUtil;

/**
 * @author Sumit
 *
 */
public class NewPhmUser {

	/**
	 * Method to sign up a new user
	 * 
	 * @param name
	 *            the name of user
	 * @param username
	 *            the userName of user
	 * @param password
	 *            the encrypted password of user.
	 * @return
	 */
	public boolean signUp(String name, String username, String password) {
		return true;
	}

	public void showScreen() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println(StringsUtil.LOGIN_MESSAGE);
			System.out.println("Create New User:");
			System.out.println("Enter full name: ");
			System.out.println("Enter a Username: ");
			System.out.println("Enter a Password: ");
			System.out.println("Enter Choice: ");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				PhmLogin login = new PhmLogin();
				break;
			case 2:
				NewPhmUser newUser = new NewPhmUser();
				break;
			case 3:
				break;
			default:
				break;
			}
		}
		sc.close();
	}

}

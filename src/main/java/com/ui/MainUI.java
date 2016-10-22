/**
 * 
 */
package com.ui;

import java.util.Scanner;

import com.exception.PhmException;
import com.util.StringsUtil;

/**
 * @author Sumit
 *
 */
public class MainUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			boolean flag = true;
			while (flag) {
				System.out.println(StringsUtil.LOGIN_MESSAGE);
				System.out.println("Select an option:");
				System.out.println("1. Login");
				System.out.println("2. Create User");
				System.out.println("3. Exit");
				System.out.println("Enter Choice: ");
				int input = sc.nextInt();
				switch (input) {
				case 1:
					PhmLogin login = new PhmLogin();
					login.showScreen();
					break;
				case 2:
					NewPhmUser newUser = new NewPhmUser();
					newUser.showScreen();
					break;
				case 3:
					break;
				default:
					break;
				}
			}
			sc.close();
		} catch (PhmException pe) {
			System.out.println("ERROR" + pe.getMessage());
			pe.printStackTrace();
		}
	}

}

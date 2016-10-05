/**
 * 
 */
package com.ui;

/**
 * @author Sumit
 *
 */
public class Login {

	/**
	 * Method to login to database. This method will ask for the userName
	 * (=unityID) and password (=unity password, encrypted))
	 * 
	 * @param username
	 *            the userName
	 * @param password
	 *            the encrypted password
	 */
	public void doLogin(String username, String password) {
		// TODO: implement some logic for encrypting password and checking that
		// with the stored (encrypted) value in the database.
		// TODO: also, save the encrypted password in (property?) file. To
		// prevent need of re- login for creating a new SQL connection.
	}
}

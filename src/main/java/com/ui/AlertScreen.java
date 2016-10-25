/**
 * 
 */
package com.ui;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.database.ConnectionManager;
import com.database.SelectQueries;
import com.exception.PhmException;
import com.model.AlertDTO;
import com.util.StringsUtil;

/**
 * @author Sumit
 *
 */
public class AlertScreen {

	/**
	 * Method to fetch and list all the alerts of a user or, all the alerts of
	 * the patient of a health supporter. If patientId is null, then self alerts
	 * will be shown for personId else, the alerts for patientIds would be
	 * shown.
	 * 
	 * @param personId
	 *            the person Id of the person whose alerts are to be shown.
	 * @param patientId
	 *            the patient id if health supporter is viewing the alerts or
	 *            else null.
	 * @throws PhmException
	 *             If error
	 */
	public static void showScreen(String personId, String patientId) throws PhmException {
		// TODO: list all alerts
		// give option to clear some or all non-mandatory alerts
		// back option.
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println(StringsUtil.LOGIN_MESSAGE);
			List<AlertDTO> alerts = null;
			if (null == patientId) { // case when self viewing
				alerts = listAlerts(personId);
				System.out.println("You have the following Alerts: ");
			} else { // case when viewing for patient
				alerts = listAlerts(patientId);
				System.out.println("Your patient has the following Alerts: ");
			}
			int i = 1;
			if (null == alerts || alerts.size() == 0) {
				System.out.println("You have no alerts!");
			} else {
				for (AlertDTO alert : alerts) {
					System.out.println(i++ + ") " + alert.getDescription());
				}
				System.out.println(i++ + ") Clear alerts.");
			}
			System.out.println(i + ") Back.");
			System.out.println("Enter Choice: ");
			int choice = Integer.valueOf(sc.nextLine());
			if (3 == choice) {
				flag = false;
				break;
			}
		}
	}

	public static void main(String[] args) throws PhmException {
		showScreen("P2", null);
	}

	/**
	 * Method to fetch all the alerts for a person from database
	 * 
	 * @param personId
	 *            the person ID
	 * @return the list of alert DTO objects
	 * @throws PhmException
	 *             If error
	 */
	private static List<AlertDTO> listAlerts(String personId) throws PhmException {
		Connection con = new ConnectionManager().getConnection();
		return SelectQueries.getPatientAlerts(con, personId);
	}
}

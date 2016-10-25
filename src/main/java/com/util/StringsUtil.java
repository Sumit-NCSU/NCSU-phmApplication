/**
 *
 */
package com.util;

/**
 * @author Sumit
 *
 */
public class StringsUtil {

	/** Static Queries **/
	/**
	 * query for alert table
	 */
	public static final String ALERT_QUERY = "SELECT A_ID as alertId, P_ID as personId, DESCRIPTION as description, IS_MANDATORY as isMandatory, IS_VIEWED as isViewed FROM ALERT";
	/**
	 * query for disease table
	 */
	public static final String DISEASE_QUERY = "SELECT D_ID as diseaseId, DNAME as diseaseName FROM DISEASE";
	/**
	 * query for observation table
	 */
	public static final String OBSERVATION_QUERY = "SELECT OB_ID as observationId, P_ID as personId, R_ID as recommendationId, OB_VALUE as observationValue, RECORD_TIME as recordTime, OB_TIME as observationTime FROM OBSERVATION";
	/**
	 * query for person table
	 */
	public static final String PERSON_QUERY = "SELECT P_ID as PersonId, PNAME as personName, USERNAME as username, PASSWORD as password, ADDRESS as address, DOB as dob, GENDER as gender FROM PERSON";
	/**
	 * query for recommendation table
	 */
	public static final String RECOMMENDATION_QUERY = "SELECT R_ID as recommendationId, DESCRIPTION as description, FREQUENCY as frequency, LOWER_LIMIT as lowerLimit, UPPER_LIMIT as upperLimit, METRIC as metric, STRING_VALUE as value FROM RECOMMENDATION";
	/**
	 * query for record disease table
	 */
	public static final String RECRD_DISEASE_QUERY = "SELECT P_ID as PersonId, D_ID as diseaseId, RECORD_TIME as recordTime FROM RECORD_DISEASE";
	/**
	 * query for sick person table
	 */
	public static final String SICK_PERSON_QUERY = "SELECT P_ID as PersonId, HS1_ID as HealthSupporter1Id, HS2_ID as HealthSupporter2Id, HS1_AUTH_DATE as hs1AuthDate, HS2_AUTH_DATE as hs2AuthDate FROM SICK_PERSON";
	/**
	 * query for specific recommendation table
	 */
	public static final String SPE_RECOMMENDATION_QUERY = "SELECT P_ID as PersonId, R_ID as recommendationId FROM SPECIFIC_RECOMMENDATION";
	/**
	 * query for standard recommendation table
	 */
	public static final String STD_RECOMMENDATION_QUERY = "SELECT D_ID as diseaseId, R_ID as recommendationId FROM STANDARD_RECOMMENDATION";
	/**
	 * query for well person table
	 */
	public static final String WELL_PERSON_QUERY = "SELECT P_ID as PersonId, HS1_ID as HealthSupporter1Id, HS2_ID as HealthSupporter2Id, HS1_AUTH_DATE as hs1AuthDate, HS2_AUTH_DATE as hs2AuthDate FROM WELL_PERSON";

	/** Prepared Statements **/
	public static final String LOGIN_QUERY = PERSON_QUERY.concat(" WHERE USERNAME = ? AND PASSWORD = ?");

	/** Messages **/

	public static final String LOGIN_MESSAGE = "Welcome to Patient Health Management Application!";

	public static final String INSERT_PERSON = "INSERT INTO Person (P_ID, PNAME, USERNAME, PASSWORD, ADDRESS, DOB, GENDER) VALUES (concat('P',phmseq.nextval), ?, ?, ?, ?, ?, ?)";

	public static final String VIEW_EXISTING_HEALTH_SUPPORTERS = "SELECT HS1_ID AND HS2_ID FROM SICK_PERSON WHERE P_ID = ?"
			+ "UNION" + "SELECT HS1_ID AND HS2_ID FROM WELL_PERSON WHERE P_ID = ?";

	public static final String VIEW_DISEASES = RECRD_DISEASE_QUERY.concat(" WHERE P_ID = ? ");

	public static final String VIEW_ALERTS = ALERT_QUERY.concat(" WHERE P_ID = ? AND IS_VIEWED = 'F'");

	public static final String MARK_VIEWED_ALERTS = "UPDATE ALERT SET IS_VIEWED = 'T' WHERE P_ID = ?";

	public static final String VIEW_OBSERVATIONS = OBSERVATION_QUERY.concat(" WHERE P_ID = ? ");

	public static final String UPDATE_SICK_PERSON_FIRST_HEALTH_SUPPORTER = "UPDATE SICK_PERSON SET HS1_ID = ? WHERE P_ID = ?";

	public static final String UPDATE_SICK_PERSON_SECOND_HEALTH_SUPPORTER = "UPDATE SICK_PERSON SET HS2_ID = ? WHERE P_ID = ?";

	public static final String UPDATE_WELL_PERSON_FIRST_HEALTH_SUPPORTER = "UPDATE WELL_PERSON SET HS1_ID = ? WHERE P_ID = ?";

	public static final String UPDATE_WELL_PERSON_SECOND_HEALTH_SUPPORTER = "UPDATE WELL_PERSON SET HS2_ID = ? WHERE P_ID = ?";

	public static final String DELETE_SICK_PERSON_FIRST_HEALTH_SUPPORTER = "UPDATE SICK_PERSON SET HS1_ID = NULL WHERE P_ID = ?";

	public static final String DELETE_SICK_PERSON_SECOND_HEALTH_SUPPORTER = "UPDATE SICK_PERSON SET HS2_ID = NULL WHERE P_ID = ?";

	public static final String DELETE_WELL_PERSON_FIRST_HEALTH_SUPPORTER = "UPDATE WELL_PERSON SET HS1_ID = NULL WHERE P_ID = ?";

	public static final String DELETE_WELL_PERSON_SECOND_HEALTH_SUPPORTER = "UPDATE WELL_PERSON SET HS2_ID = NULL WHERE P_ID = ?";

	public static final String SHOW_DISEASES = "SELECT * FROM DISEASE";

	public static final String ADD_DISEASE = "INSERT INTO RECORD_DISEASE VALUES (P_ID?, D_ID?, SYSTIMESTAMP)";

	public static final String ADD_OBSERVATION = "INSERT INTO OBSERVATION VALUES (PHMSQL.NEXTVAL, P_ID?, R_ID?, OB_VALUE?, SYSTIMESTAMP)";

	public static final String SHOW_PATIENTS_OF_HEALTH_SUPPORTER = PERSON_QUERY.concat(
			" WHERE P_ID IN ( SELECT P_ID FROM WELL_PERSON WHERE HS1_ID=? OR HS2_ID=? UNION SELECT P_ID FROM SICK_PERSON WHERE HS1_ID=? OR HS2_ID=? )");

	public static final String HEALTH_SUPPORTER_VIEWS_ALERTS_OF_PATIENT = "SELECT DESCRIPTION AS Description FROM ALERT WHERE P_ID = ?";

	public static final String IS_PERSON_HEALTH_SUPPORTER = "SELECT COUNT(*) AS VALUE FROM PERSON P AND SICK_PERSON S AND WELL_PERSON W WHERE P.P_ID=S.HS1_ID OR P.P_ID=S.HS2_ID OR P.P_ID=W.HS1_ID OR P.P_ID=W.HS2_ID";
	
	public static final String HEALTH_SUPPORTER_VIEWS_SPECIFIC_RECOMMENDATION = "SELECT R.FREQUENCY AS Frequency, R.DESCRIPTION AS Description, R.METRIC AS Metric, R.LOWER_BOUND AS Lower Bound, R.UPPER_BOUND AS Upper Bound, R.STRING_VALUE AS String_Value FROM RECOMMENDATION R, SPECIFIC_RECOMMENDATION SR WHERE SR.R_ID=R.R_ID";
 	
	public static final String RECOMMENDATION_DESCRIPTION_FROM_OBSERVATION_ID = "SELECT R.DESCRIPTION AS Description FROM RECOMMENDATION R, OBSERVATION O WHERE O.R_ID = R.R_ID AND O.OB_ID=?";

	public static final String GET_DISEASE_NAME = "SELECT DNAME as diseaseName FROM DISEASE WHERE D_ID = ?";

}

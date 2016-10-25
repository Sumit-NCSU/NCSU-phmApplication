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
	public static final String ALERT_QUERY = "SELECT A_ID as alertId, P_ID as PersonId, DESCRIPTION as description FROM ALERT";
	public static final String DISEASE_QUERY = "SELECT D_ID as diseaseId, DNAME as diseaseName FROM DISEASE";
	public static final String DISEASE_OBSERVATION_QUERY = "SELECT D_ID as diseaseId, OB_TYPE as observationType FROM DISEASE_OBSERVATION";
	public static final String OBSERVATION_QUERY = "SELECT OB_ID as observationId, R_ID as recommendationId, OB_VALUE as observationValue FROM OBSERVATION";
	public static final String OBSERVATION_TYPE_QUERY = "SELECT OB_TYPE as observationType, R_ID as recommendationId FROM OBSERVATION_TYPE";
	public static final String PERSON_QUERY = "SELECT P_ID as PersonId, PNAME as personName, USERNAME as username, PASSWORD as password, ADDRESS as address, DOB as dob, GENDER as gender FROM PERSON";
	public static final String RECOMMENDATION_QUERY = "SELECT R_ID, DESCRIPTION as description, FREQUENCY as frequency, LOWER_LIMIT as lowerLimit, UPPER_LIMIT as upperLimit, METRIC as metric, STRING_VALUE as value FROM RECOMMENDATION";
	public static final String RECRD_DISEASE_QUERY = "SELECT P_ID as PersonId, D_ID as diseaseId, RECORD_TIME FROM RECORD_DISEASE";
	public static final String RECORD_OBSERVATION_QUERY = "SELECT OB_ID as observationId, P_ID as PersonId, RECORD_TIME, OB_TIME FROM RECORD_OBSERVATION";
	public static final String SICK_PERSON_QUERY = "SELECT P_ID as PersonId, HS1_ID as HealthSupporter1Id, HS2_ID as HealthSupporter2Id, HS1_AUTH_DATE as hs1AuthDate, HS2_AUTH_DATE as hs2AuthDate FROM SICK_PERSON";
	public static final String SPE_RECOMMENDATION_QUERY = "SELECT P_ID as PersonId, R_ID as recommendationId, RECO_TIME as recordTime FROM SPECIFIC_RECOMMENDATION";
	public static final String STD_RECOMMENDATION_QUERY = "SELECT D_ID as diseaseId, R_ID as recommendationId FROM STANDARD_RECOMMENDATION";
	public static final String WELL_PERSON_QUERY = "SELECT P_ID as PersonId, HS1_ID as HealthSupporter1Id, HS2_ID as HealthSupporter2Id, HS1_AUTH_DATE as hs1AuthDate, HS2_AUTH_DATE as hs2AuthDate FROM WELL_PERSON";

	/** Prepared Statements **/
	public static final String LOGIN_QUERY = PERSON_QUERY.concat(" WHERE USERNAME = ? AND PASSWORD = ?");

	/** Messages **/

	public static final String LOGIN_MESSAGE = "Welcome to Patient Health Management Application!";

	/** Queries for User Homepage **/

		public static final String VIEW_EXISTING_HEALTH_SUPPORTERS = "SELECT HS1_ID AND HS2_ID FROM SICK_PERSON WHERE P_ID = ?;"
																	+ "UNION"
																	+ "SELECT HS1_ID AND HS2_ID FROM WELL_PERSON WHERE P_ID = ?;";

		public static final String VIEW_DISEASES = "SELECT D.DNAME "
													+ "FROM DISEASE D, RECORD_DISEASE RD"
													+ "WHERE D.D_ID = RD.D_ID AND P_ID = ?;";

		public static final String VIEW_ALERTS = "SELECT DESCRIPTION FROM ALERT WHERE P_ID = ? AND IS_VIEWED = 'F';";

		public static final String MARK_VIEWED_ALERTS = "UPDATE ALERT SET IS_VIEWED = 'T' WHERE P_ID = ?;";

		public static final String VIEW_OBSERVATIONS = "SELECT OB_VALUE, OB_TIME FROM OBSERVATION WHERE P_ID = ? ;";

		public static final String UPDATE_SICK_PERSON_FIRST_HEALTH_SUPPORTER = "UPDATE SICK_PERSON SET HS1_ID = ? WHERE P_ID = ?;";

		public static final String UPDATE_SICK_PERSON_SECOND_HEALTH_SUPPORTER = "UPDATE SICK_PERSON SET HS2_ID = ? WHERE P_ID = ?;";

		public static final String UPDATE_WELL_PERSON_FIRST_HEALTH_SUPPORTER = "UPDATE WELL_PERSON SET HS1_ID = ? WHERE P_ID = ?;";

		public static final String UPDATE_WELL_PERSON_SECOND_HEALTH_SUPPORTER = "UPDATE WELL_PERSON SET HS2_ID = ? WHERE P_ID = ?;";

		public static final String DELETE_SICK_PERSON_FIRST_HEALTH_SUPPORTER = "UPDATE SICK_PERSON SET HS1_ID = NULL WHERE P_ID = ?;";

		public static final String DELETE_SICK_PERSON_SECOND_HEALTH_SUPPORTER = "UPDATE SICK_PERSON SET HS2_ID = NULL WHERE P_ID = ?;";

		public static final String DELETE_WELL_PERSON_FIRST_HEALTH_SUPPORTER = "UPDATE WELL_PERSON SET HS1_ID = NULL WHERE P_ID = ?;";

		public static final String DELETE_WELL_PERSON_SECOND_HEALTH_SUPPORTER = "UPDATE WELL_PERSON SET HS2_ID = NULL WHERE P_ID = ?;";

		public static final String SHOW_DISEASES = "SELECT * FROM DISEASE;";

		public static final String ADD_DISEASE = "INSERT INTO RECORD_DISEASE VALUES (P_ID?, D_ID?, SYSTIMESTAMP);";

		public static final String ADD_OBSERVATION = "INSERT INTO OBSERVATION VALUES (PHMSQL.NEXTVAL, P_ID?, R_ID?, OB_VALUE?, SYSTIMESTAMP);";
		

}

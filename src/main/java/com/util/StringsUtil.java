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
}

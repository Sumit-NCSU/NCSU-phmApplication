/**
 * 
 */
package com.util;

/**
 * @author Sumit
 *
 */
public class StringsUtil {

	public static final String ALERT_QUERY = "SELECT A_ID as alertId, P_ID as PersonId, DESCRIPTION as description FROM ALERT";
	public static final String DISEASE_QUERY = "SELECT D_ID as diseaseId, DNAME as diseaseName FROM DISEASE";
	public static final String DISEASE_OBSERVATION_QUERY = "SELECT D_ID as diseaseId, OB_TYPE as observationType FROM DISEASE_OBSERVATION";
	public static final String OBSERVATION_QUERY = "SELECT OB_ID as observationId, OB_TYPE as observationType, OB_VALUE FROM OBSERVATION";
	public static final String OBSERVATION_TYPE_QUERY = "SELECT OB_TYPE as observationType, FREQUENCY as frequency, DESCRIPTION as description, MEASURE as measure, METRIC as metric, LOWER_BOUND as lowerBound, UPPER_BOUND as upperBound FROM OBSERVATION_TYPE";
	public static final String PERSON_QUERY = "SELECT P_ID as PersonId, PNAME as personName, USERNAME as username, PASSWORD as password, ADDRESS as address, DOB as dob, GENDER as gender FROM PERSON";
	public static final String RECOMMENDATION_QUERY = "SELECT R_ID, DESCRIPTION as description, FREQUENCY as frequency, LOWER_LIMIT as lowerLimit, UPPER_LIMIT as upperLimit FROM RECOMMENDATION";
	public static final String RECRD_DISEASE_QUERY = "SELECT P_ID as PersonId, D_ID as diseaseId, RECORD_TIME FROM RECORD_DISEASE";
	public static final String RECORD_OBSERVATION_QUERY = "SELECT OB_ID as observationId, P_ID as PersonId, RECORD_TIME, OB_TIME FROM RECORD_OBSERVATION";
	public static final String SICK_PERSON_QUERY = "SELECT P_ID as PersonId, HS1_ID as HealthSupporter1Id, HS2_ID as HealthSupporter2Id FROM SICK_PERSON";
	public static final String SPE_RECOMMENDATION_QUERY = "SELECT P_ID as PersonId, R_ID, RECO_TIME as recordTime FROM SPECIFIC_RECOMMENDATION";
	public static final String STD_RECOMMENDATION_QUERY = "SELECT D_ID as diseaseId, R_ID, RECO_TIME as recordTime FROM STANDARD_RECOMMENDATION";
	public static final String WELL_PERSON_QUERY = "SELECT P_ID as PersonId, HS1_ID as HealthSupporter1Id, HS2_ID as HealthSupporter2Id FROM WELL_PERSON";
}

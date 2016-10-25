package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.PhmException;
import com.model.AlertDTO;
import com.model.DiseaseDTO;
import com.model.ObservationDTO;
import com.model.PersonDTO;
import com.model.RecommendationDTO;
import com.model.RecordDiseaseDTO;
import com.model.SickPersonDTO;
import com.model.SpecificRecommendationDTO;
import com.model.StandardRecommendationDTO;
import com.model.WellPersonDTO;
import com.util.StringsUtil;

/**
 * @author Sumit
 *
 */
public class SelectQueries {

	/**
	 * Method to fetch the record of Login User from database.
	 * 
	 * @param username
	 *            the user name
	 * @param password
	 *            the password
	 * @param connection
	 *            the database connection
	 * @return the object of Person DTO if login successful or null if user does
	 *         not exist.
	 */
	public static PersonDTO getLoginPerson(String username, String password, Connection connection)
			throws PhmException {
		PersonDTO person = null;
		try {
			PreparedStatement ps = connection.prepareStatement(StringsUtil.LOGIN_QUERY);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				person = new PersonDTO(resultSet.getString("personId"), resultSet.getString("personName"),
						resultSet.getString("username"), resultSet.getString("password"),
						resultSet.getString("address"), resultSet.getString("dob"), resultSet.getString("gender"));
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch Person While Login. " + e.getMessage());
			throw new PhmException("Failed to fetch Person While Login. " + e.getMessage());
		}
		return person;
	}

	/**
	 * Method to fetch all rows from ALERT table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of AlertDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static List<AlertDTO> getAllAlerts(Connection connection) throws PhmException {
		List<AlertDTO> alertDTOs = new ArrayList<AlertDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.ALERT_QUERY);
			while (resultSet.next()) {
				AlertDTO alertDTO = new AlertDTO(resultSet.getInt("alertId"), resultSet.getString("personId"),
						resultSet.getString("description"), resultSet.getString("isMandatory"),
						resultSet.getString("isViewed"));
				alertDTOs.add(alertDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Alerts." + e.getMessage());
			throw new PhmException("Failed to fetch all Alerts." + e.getMessage());
		}
		return alertDTOs;
	}

	/**
	 * Method to fetch all rows from DISEASE table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of DiseaseDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static List<DiseaseDTO> getAllDiseases(Connection connection) throws PhmException {
		List<DiseaseDTO> diseaseDTOs = new ArrayList<DiseaseDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.DISEASE_QUERY);
			while (resultSet.next()) {
				DiseaseDTO diseaseDTO = new DiseaseDTO(resultSet.getInt("diseaseId"),
						resultSet.getString("diseaseName"));
				diseaseDTOs.add(diseaseDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Diseases." + e.getMessage());
			throw new PhmException("Failed to fetch all Diseases." + e.getMessage());
		}
		return diseaseDTOs;
	}

	/**
	 * Method to fetch all rows from OBSERVATION table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of ObservationDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static List<ObservationDTO> getAllObservations(Connection connection) throws PhmException {
		List<ObservationDTO> observationDTOs = new ArrayList<ObservationDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.OBSERVATION_QUERY);
			while (resultSet.next()) {
				ObservationDTO observationDTO = new ObservationDTO(resultSet.getInt("observationId"),
						resultSet.getString("personId"), resultSet.getInt("recommendationId"),
						resultSet.getString("observationValue"), resultSet.getDate("recordTime"),
						resultSet.getDate("observationTime"));
				observationDTOs.add(observationDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Observations." + e.getMessage());
			throw new PhmException("Failed to fetch all Observations." + e.getMessage());
		}
		return observationDTOs;
	}

	/**
	 * Method to fetch all rows from PERSON table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of PersonDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static List<PersonDTO> getAllPersons(Connection connection) throws PhmException {
		List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.PERSON_QUERY);
			while (resultSet.next()) {
				PersonDTO personDTO = new PersonDTO(resultSet.getString("personId"), resultSet.getString("personName"),
						resultSet.getString("username"), resultSet.getString("password"),
						resultSet.getString("address"), resultSet.getString("dob"), resultSet.getString("gender"));
				personDTOs.add(personDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Persons." + e.getMessage());
			throw new PhmException("Failed to fetch all Persons." + e.getMessage());
		}
		return personDTOs;
	}

	/**
	 * Method to fetch all rows from RECOMMENDATION table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of AlertDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static List<RecommendationDTO> getAllRecommendations(Connection connection) throws PhmException {
		List<RecommendationDTO> recommendationDTOs = new ArrayList<RecommendationDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.RECOMMENDATION_QUERY);
			while (resultSet.next()) {
				RecommendationDTO recommendationDTO = new RecommendationDTO(resultSet.getInt("recommendationId"),
						resultSet.getString("description"), resultSet.getString("frequency"),
						resultSet.getString("lowerLimit"), resultSet.getString("upperLimit"),
						resultSet.getString("metric"), resultSet.getString("value"));
				recommendationDTOs.add(recommendationDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Recommendations." + e.getMessage());
			throw new PhmException("Failed to fetch all Recommendations." + e.getMessage());
		}
		return recommendationDTOs;
	}

	/**
	 * Method to fetch all rows from RECORD_DISEASE table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of RecordDiseaseDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static List<RecordDiseaseDTO> getAllRecordDiseases(Connection connection) throws PhmException {
		List<RecordDiseaseDTO> recordDiseaseDTOs = new ArrayList<RecordDiseaseDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.RECRD_DISEASE_QUERY);
			while (resultSet.next()) {
				RecordDiseaseDTO recordDiseaseDTO = new RecordDiseaseDTO(resultSet.getString("personId"),
						resultSet.getInt("diseaseId"), resultSet.getTimestamp("recordTime"));
				recordDiseaseDTOs.add(recordDiseaseDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Record Diseases." + e.getMessage());
			throw new PhmException("Failed to fetch all Record Diseases." + e.getMessage());
		}
		return recordDiseaseDTOs;
	}

	/**
	 * Method to fetch all rows from SICK_PERSON table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of SickPersonDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static List<SickPersonDTO> getAllSickPersons(Connection connection) throws PhmException {
		List<SickPersonDTO> sickPersonDTOs = new ArrayList<SickPersonDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.SICK_PERSON_QUERY);
			while (resultSet.next()) {
				SickPersonDTO sickPersonDTO = new SickPersonDTO(resultSet.getString("personId"),
						resultSet.getString("healthSupporter1Id"), resultSet.getString("healthSupporter2Id"),
						resultSet.getDate("hs1AuthDate"), resultSet.getDate("hs2AuthDate"));
				sickPersonDTOs.add(sickPersonDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Sick Persons." + e.getMessage());
			throw new PhmException("Failed to fetch all Sick Persons." + e.getMessage());
		}
		return sickPersonDTOs;
	}

	/**
	 * Method to fetch all rows from SPECIFIC_RECOMMENDATION table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of SpecificRecommendationDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static List<SpecificRecommendationDTO> getAllSpecificRecommendations(Connection connection)
			throws PhmException {
		List<SpecificRecommendationDTO> specificRecommendationDTOs = new ArrayList<SpecificRecommendationDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.SPE_RECOMMENDATION_QUERY);
			while (resultSet.next()) {
				SpecificRecommendationDTO specificRecommendationDTO = new SpecificRecommendationDTO(
						resultSet.getInt("recommendationId"), resultSet.getString("personId"));
				specificRecommendationDTOs.add(specificRecommendationDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Specific Recommendations." + e.getMessage());
			throw new PhmException("Failed to fetch all Specific Recommendations." + e.getMessage());
		}
		return specificRecommendationDTOs;
	}

	/**
	 * Method to fetch all rows from STANDARD_RECOMMENDATION table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of StandardRecommendationDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static List<StandardRecommendationDTO> getAllStandardRecommendations(Connection connection)
			throws PhmException {
		List<StandardRecommendationDTO> standardRecommendationDTOs = new ArrayList<StandardRecommendationDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.STD_RECOMMENDATION_QUERY);
			while (resultSet.next()) {
				StandardRecommendationDTO standardRecommendationDTO = new StandardRecommendationDTO(
						resultSet.getInt("diseaseId"), resultSet.getInt("recommendationId"));
				standardRecommendationDTOs.add(standardRecommendationDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Standard Recommendations." + e.getMessage());
			throw new PhmException("Failed to fetch all Standard Recommendations." + e.getMessage());
		}
		return standardRecommendationDTOs;
	}

	/**
	 * Method to fetch all rows from WELL_PERSON table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of WellPersonDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public static List<WellPersonDTO> getAllWellPersons(Connection connection) throws PhmException {
		List<WellPersonDTO> wellPersonDTOs = new ArrayList<WellPersonDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.WELL_PERSON_QUERY);
			while (resultSet.next()) {
				WellPersonDTO wellPersonDTO = new WellPersonDTO(resultSet.getString("personId"),
						resultSet.getString("healthSupporter1Id"), resultSet.getString("healthSupporter2Id"),
						resultSet.getDate("hs1AuthDate"), resultSet.getDate("hs2AuthDate"));
				wellPersonDTOs.add(wellPersonDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Well Persons." + e.getMessage());
			throw new PhmException("Failed to fetch all Well Persons." + e.getMessage());
		}
		return wellPersonDTOs;
	}
}

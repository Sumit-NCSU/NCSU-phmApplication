/**
 * 
 */
package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.PhmException;
import com.model.AlertDTO;
import com.model.DiseaseDTO;
import com.model.DiseaseObservationDTO;
import com.model.ObservationDTO;
import com.model.ObservationTypeDTO;
import com.model.PersonDTO;
import com.model.RecommendationDTO;
import com.model.RecordDiseaseDTO;
import com.model.RecordObservationDTO;
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
	 * Method to fetch all rows from ALERT table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of AlertDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public List<AlertDTO> getAllAlerts(Connection connection) throws PhmException {
		List<AlertDTO> alertDTOs = new ArrayList<AlertDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.ALERT_QUERY);
			while (resultSet.next()) {
				AlertDTO alertDTO = new AlertDTO(resultSet.getInt("alertId"), resultSet.getInt("personId"),
						resultSet.getString("description"));
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
	public List<DiseaseDTO> getAllDiseases(Connection connection) throws PhmException {
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
	 * Method to fetch all rows from DISEASE_OBSERVATION table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of DiseaseObservationDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public List<DiseaseObservationDTO> getAllDiseaseObservations(Connection connection) throws PhmException {
		List<DiseaseObservationDTO> diseaseOservationDTOs = new ArrayList<DiseaseObservationDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.DISEASE_OBSERVATION_QUERY);
			while (resultSet.next()) {
				DiseaseObservationDTO diseaseOservationDTO = new DiseaseObservationDTO(resultSet.getInt("diseaseId"),
						resultSet.getString("observationType"));
				diseaseOservationDTOs.add(diseaseOservationDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Disease Oservations." + e.getMessage());
			throw new PhmException("Failed to fetch all Disease Oservations." + e.getMessage());
		}
		return diseaseOservationDTOs;
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
	public List<ObservationDTO> getAllObservations(Connection connection) throws PhmException {
		List<ObservationDTO> observationDTOs = new ArrayList<ObservationDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.OBSERVATION_QUERY);
			while (resultSet.next()) {
				ObservationDTO observationDTO = new ObservationDTO(resultSet.getInt("observationId"),
						resultSet.getString("observationType"), resultSet.getString("observationValue"));
				observationDTOs.add(observationDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Observations." + e.getMessage());
			throw new PhmException("Failed to fetch all Observations." + e.getMessage());
		}
		return observationDTOs;
	}

	/**
	 * Method to fetch all rows from OBSERVATION_TYPE table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of ObservationTypeDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public List<ObservationTypeDTO> getAllObservationTypes(Connection connection) throws PhmException {
		List<ObservationTypeDTO> observationTypeDTOs = new ArrayList<ObservationTypeDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.OBSERVATION_TYPE_QUERY);
			while (resultSet.next()) {
				ObservationTypeDTO observationTypeDTO = new ObservationTypeDTO(resultSet.getString("observationType"),
						resultSet.getString("frequency"), resultSet.getString("description"),
						resultSet.getString("measure"), resultSet.getString("metric"),
						resultSet.getString("lowerBound"), resultSet.getString("upperBound"));
				observationTypeDTOs.add(observationTypeDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Observation Types." + e.getMessage());
			throw new PhmException("Failed to fetch all Observation Types." + e.getMessage());
		}
		return observationTypeDTOs;
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
	public List<PersonDTO> getAllPersons(Connection connection) throws PhmException {
		List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.PERSON_QUERY);
			while (resultSet.next()) {
				PersonDTO personDTO = new PersonDTO(resultSet.getInt("personId"), resultSet.getString("personName"),
						resultSet.getString("username"), resultSet.getString("password"),
						resultSet.getString("address"), resultSet.getDate("dob"), resultSet.getString("gender"));
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
	public List<RecommendationDTO> getAllRecommendations(Connection connection) throws PhmException {
		List<RecommendationDTO> recommendationDTOs = new ArrayList<RecommendationDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.RECOMMENDATION_QUERY);
			while (resultSet.next()) {
				RecommendationDTO recommendationDTO = new RecommendationDTO(resultSet.getInt("recommendationId"),
						resultSet.getString("description"), resultSet.getString("frequency"),
						resultSet.getString("lowerLimit"), resultSet.getString("upperLimit"));
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
	public List<RecordDiseaseDTO> getAllRecordDiseases(Connection connection) throws PhmException {
		List<RecordDiseaseDTO> recordDiseaseDTOs = new ArrayList<RecordDiseaseDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.RECRD_DISEASE_QUERY);
			while (resultSet.next()) {
				RecordDiseaseDTO recordDiseaseDTO = new RecordDiseaseDTO(resultSet.getInt("personId"),
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
	 * Method to fetch all rows from RECORD_OBSERVATION table in database.
	 * 
	 * @param connection
	 *            the database connection to use
	 * @return List of RecordObservationDTO objects
	 * @throws PhmException
	 *             if some error occurs
	 */
	public List<RecordObservationDTO> getAllRecordObservations(Connection connection) throws PhmException {
		List<RecordObservationDTO> recordObservationDTOs = new ArrayList<RecordObservationDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.RECORD_OBSERVATION_QUERY);
			while (resultSet.next()) {
				RecordObservationDTO recordOservationDTO = new RecordObservationDTO(resultSet.getInt("observationId"),
						resultSet.getInt("personId"), resultSet.getTimestamp("recordTime"),
						resultSet.getTimestamp("observationTime"));
				recordObservationDTOs.add(recordOservationDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Record Oservations." + e.getMessage());
			throw new PhmException("Failed to fetch all Record Oservations." + e.getMessage());
		}
		return recordObservationDTOs;
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
	public List<SickPersonDTO> getAllSickPersons(Connection connection) throws PhmException {
		List<SickPersonDTO> sickPersonDTOs = new ArrayList<SickPersonDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.SICK_PERSON_QUERY);
			while (resultSet.next()) {
				SickPersonDTO sickPersonDTO = new SickPersonDTO(resultSet.getInt("personId"),
						resultSet.getInt("healthSupporter1Id"), resultSet.getInt("healthSupporter2Id"));
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
	public List<SpecificRecommendationDTO> getAllSpecificRecommendations(Connection connection) throws PhmException {
		List<SpecificRecommendationDTO> specificRecommendationDTOs = new ArrayList<SpecificRecommendationDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.SPE_RECOMMENDATION_QUERY);
			while (resultSet.next()) {
				SpecificRecommendationDTO specificRecommendationDTO = new SpecificRecommendationDTO(
						resultSet.getInt("diseaseId"), resultSet.getInt("recommendationId"),
						resultSet.getTimestamp("recordTime"));
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
	public List<StandardRecommendationDTO> getAllStandardRecommendations(Connection connection) throws PhmException {
		List<StandardRecommendationDTO> standardRecommendationDTOs = new ArrayList<StandardRecommendationDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.STD_RECOMMENDATION_QUERY);
			while (resultSet.next()) {
				StandardRecommendationDTO standardRecommendationDTO = new StandardRecommendationDTO(
						resultSet.getInt("diseaseId"), resultSet.getInt("recommendationId"),
						resultSet.getTimestamp("recordTime"));
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
	public List<WellPersonDTO> getAllWellPersons(Connection connection) throws PhmException {
		List<WellPersonDTO> wellPersonDTOs = new ArrayList<WellPersonDTO>();
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(StringsUtil.WELL_PERSON_QUERY);
			while (resultSet.next()) {
				WellPersonDTO wellPersonDTO = new WellPersonDTO(resultSet.getInt("personId"),
						resultSet.getInt("healthSupporter1Id"), resultSet.getInt("healthSupporter2Id"));
				wellPersonDTOs.add(wellPersonDTO);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch all Well Persons." + e.getMessage());
			throw new PhmException("Failed to fetch all Well Persons." + e.getMessage());
		}
		return wellPersonDTOs;
	}
}

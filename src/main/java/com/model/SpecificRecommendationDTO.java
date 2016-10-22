package com.model;

import java.sql.Timestamp;

public class SpecificRecommendationDTO {

	private int personId;
	// private int diseaseId; //modified as per changes from  dev_Nikhil branch
	private int recommendationId;
	private Timestamp recordTime;

	/**
	 * Parameterized constructor
	 * 
	 * @param recommendationId
	 *            the recommendation ID
	 * @param recordTime
	 *            the record time
	 */
	public SpecificRecommendationDTO(int recommendationId, Timestamp recordTime) {
		// public SpecificRecommendationDTO(int diseaseId, int recommendationId,
		// Timestamp recordTime) {
		// this.diseaseId = diseaseId;
		this.recommendationId = recommendationId;
		this.recordTime = recordTime;
	}

	/**
	 * @return the personId
	 */
	public int getPersonId() {
		return personId;
	}

	/**
	 * @param personId
	 *            the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}

	// /**
	// * @return the diseaseId
	// */
	// public int getDiseaseId() {
	// return diseaseId;
	// }
	//
	// /**
	// * @param diseaseId
	// * the diseaseId to set
	// */
	// public void setDiseaseId(int diseaseId) {
	// this.diseaseId = diseaseId;
	// }

	/**
	 * @return the recommendationId
	 */
	public int getRecommendationId() {
		return recommendationId;
	}

	/**
	 * @param recommendationId
	 *            the recommendationId to set
	 */
	public void setRecommendationId(int recommendationId) {
		this.recommendationId = recommendationId;
	}

	/**
	 * @return the recordTime
	 */
	public Timestamp getRecordTime() {
		return recordTime;
	}

	/**
	 * @param recordTime
	 *            the recordTime to set
	 */
	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}
}

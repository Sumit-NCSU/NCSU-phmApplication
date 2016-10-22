package com.model;

public class StandardRecommendationDTO {

	private int diseaseId;
	private int recommendationId;
	// private Timestamp recordTime; //modified as per changes from  dev_Nikhil branch

	/**
	 * Parameterized constructor
	 * 
	 * @param diseaseId
	 *            the disease ID
	 * @param recommendationId
	 *            the recommendation ID
	 * @param recordTime
	 *            the record time
	 */
	public StandardRecommendationDTO(int diseaseId, int recommendationId) {
		this.diseaseId = diseaseId;
		this.recommendationId = recommendationId;
		// this.recordTime = recordTime;
	}

	/**
	 * @return the diseaseId
	 */
	public int getDiseaseId() {
		return diseaseId;
	}

	/**
	 * @param diseaseId
	 *            the diseaseId to set
	 */
	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}

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

	// /**
	// * @return the recordTime
	// */
	// public Timestamp getRecordTime() {
	// return recordTime;
	// }
	//
	// /**
	// * @param recordTime
	// * the recordTime to set
	// */
	// public void setRecordTime(Timestamp recordTime) {
	// this.recordTime = recordTime;
	// }
}

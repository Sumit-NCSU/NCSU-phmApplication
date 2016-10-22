package com.model;

public class ObservationDTO {

	private int observationId;
	// private String observationType;
	private int recommendationId;  //modified as per changes from  dev_Nikhil branch
	private String observationValue;

	/**
	 * Parameterized constructor
	 * 
	 * @param observationId
	 *            the observation ID
	 * @param observationType
	 *            the observation type
	 * @param observationValue
	 *            the observation Value
	 */
	public ObservationDTO(int observationId, int recommendationId, String observationValue) {
		this.observationId = observationId;
		this.recommendationId = recommendationId;
		this.observationValue = observationValue;
	}

	/**
	 * @return the observationId
	 */
	public int getObservationId() {
		return observationId;
	}

	/**
	 * @param observationId
	 *            the observationId to set
	 */
	public void setObservationId(int observationId) {
		this.observationId = observationId;
	}

	// /**
	// * @return the observationType
	// */
	// public String getObservationType() {
	// return observationType;
	// }
	//
	// /**
	// * @param observationType
	// * the observationType to set
	// */
	// public void setObservationType(String observationType) {
	// this.observationType = observationType;
	// }

	/**
	 * @return the observationValue
	 */
	public String getObservationValue() {
		return observationValue;
	}

	/**
	 * @param observationValue
	 *            the observationValue to set
	 */
	public void setObservationValue(String observationValue) {
		this.observationValue = observationValue;
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

}

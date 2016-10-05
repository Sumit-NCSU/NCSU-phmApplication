package com.model;

public class ObservationDTO {

	private int observationId;
	private String observationType;
	private String observationValue;

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

	/**
	 * @return the observationType
	 */
	public String getObservationType() {
		return observationType;
	}

	/**
	 * @param observationType
	 *            the observationType to set
	 */
	public void setObservationType(String observationType) {
		this.observationType = observationType;
	}

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

}

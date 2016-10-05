package com.model;

public class DiseaseObservationDTO {

	private int diseaseId;
	private String observationType;

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
}

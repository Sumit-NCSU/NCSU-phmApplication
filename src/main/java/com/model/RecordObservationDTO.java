package com.model;

import java.sql.Timestamp;

public class RecordObservationDTO {

	private int observationId;
	private int personId;
	private Timestamp recordTime;
	private Timestamp observationTime;

	/**
	 * Parameterized constructor
	 * 
	 * @param observationId
	 *            the observation ID
	 * @param personId
	 *            the person ID
	 * @param recordTime
	 *            the record time
	 * @param observationTime
	 *            the observation time
	 */
	public RecordObservationDTO(int observationId, int personId, Timestamp recordTime, Timestamp observationTime) {
		this.observationId = observationId;
		this.personId = personId;
		this.recordTime = recordTime;
		this.observationTime = observationTime;
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

	/**
	 * @return the observationTime
	 */
	public Timestamp getObservationTime() {
		return observationTime;
	}

	/**
	 * @param observationTime
	 *            the observationTime to set
	 */
	public void setObservationTime(Timestamp observationTime) {
		this.observationTime = observationTime;
	}
}

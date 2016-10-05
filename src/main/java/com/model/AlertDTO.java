package com.model;

public class AlertDTO {

	private int alertId;
	private int personId;
	private String description;

	/**
	 * Parameterized constructor
	 * 
	 * @param alertId
	 *            the alert ID
	 * @param personId
	 *            the person ID
	 * @param description
	 *            the description
	 */
	public AlertDTO(int alertId, int personId, String description) {
		this.alertId = alertId;
		this.personId = personId;
		this.description = description;
	}

	/**
	 * @return the alertId
	 */
	public int getAlertId() {
		return alertId;
	}

	/**
	 * @param alertId
	 *            the alertId to set
	 */
	public void setAlertId(int alertId) {
		this.alertId = alertId;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}

package com.model;

public class WellPersonDTO {

	private int personId;
	private int healthSupporter1Id;
	private int healthSupporter2Id;

	/**
	 * Parameterized constructor
	 * 
	 * @param personId
	 *            the person ID
	 * @param healthSupporter1Id
	 *            the health supporter 1 ID
	 * @param healthSupporter2Id
	 *            the health supporter 2 ID
	 */
	public WellPersonDTO(int personId, int healthSupporter1Id, int healthSupporter2Id) {
		this.personId = personId;
		this.healthSupporter1Id = healthSupporter1Id;
		this.healthSupporter2Id = healthSupporter2Id;
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
	 * @return the healthSupporter1Id
	 */
	public int getHealthSupporter1Id() {
		return healthSupporter1Id;
	}

	/**
	 * @param healthSupporter1Id
	 *            the healthSupporter1Id to set
	 */
	public void setHealthSupporter1Id(int healthSupporter1Id) {
		this.healthSupporter1Id = healthSupporter1Id;
	}

	/**
	 * @return the healthSupporter2Id
	 */
	public int getHealthSupporter2Id() {
		return healthSupporter2Id;
	}

	/**
	 * @param healthSupporter2Id
	 *            the healthSupporter2Id to set
	 */
	public void setHealthSupporter2Id(int healthSupporter2Id) {
		this.healthSupporter2Id = healthSupporter2Id;
	}

}
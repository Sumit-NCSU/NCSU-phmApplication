package com.model;

public class RecommendationDTO {

	private int recommendationId;
	private String description;
	private String frequency;
	private String lowerLimit;
	private String upperLimit;

	/**
	 * Parameterized constructor
	 * 
	 * @param recommendationId
	 *            the recommendation ID
	 * @param description
	 *            the description
	 * @param frequency
	 *            the frequency
	 * @param lowerLimit
	 *            the lower limit
	 * @param upperLimit
	 *            the upper limit
	 */
	public RecommendationDTO(int recommendationId, String description, String frequency, String lowerLimit,
			String upperLimit) {
		this.recommendationId = recommendationId;
		this.description = description;
		this.frequency = frequency;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
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

	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency
	 *            the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the lowerLimit
	 */
	public String getLowerLimit() {
		return lowerLimit;
	}

	/**
	 * @param lowerLimit
	 *            the lowerLimit to set
	 */
	public void setLowerLimit(String lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	/**
	 * @return the upperLimit
	 */
	public String getUpperLimit() {
		return upperLimit;
	}

	/**
	 * @param upperLimit
	 *            the upperLimit to set
	 */
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit;
	}

}

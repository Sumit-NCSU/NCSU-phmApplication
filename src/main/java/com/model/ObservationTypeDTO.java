package com.model;

public class ObservationTypeDTO {

	private String observationType;
	private int recommendationId; //modified as per changes from  dev_Nikhil branch
	// private String frequency;
	// private String description;
	// private String measure;
	// private String metric;
	// private String lowerBound;
	// private String upperBound;

	/**
	 * Parameterized constructor
	 * 
	 * @param observationType
	 *            the observation type
	 */
	public ObservationTypeDTO(String observationType, int recommendationId) {
		this.observationType = observationType;
		this.recommendationId = recommendationId;
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
	// * @return the frequency
	// */
	// public String getFrequency() {
	// return frequency;
	// }
	//
	// /**
	// * @param frequency
	// * the frequency to set
	// */
	// public void setFrequency(String frequency) {
	// this.frequency = frequency;
	// }
	//
	// /**
	// * @return the description
	// */
	// public String getDescription() {
	// return description;
	// }
	//
	// /**
	// * @param description
	// * the description to set
	// */
	// public void setDescription(String description) {
	// this.description = description;
	// }
	//
	// /**
	// * @return the measure
	// */
	// public String getMeasure() {
	// return measure;
	// }
	//
	// /**
	// * @param measure
	// * the measure to set
	// */
	// public void setMeasure(String measure) {
	// this.measure = measure;
	// }
	//
	// /**
	// * @return the metric
	// */
	// public String getMetric() {
	// return metric;
	// }
	//
	// /**
	// * @param metric
	// * the metric to set
	// */
	// public void setMetric(String metric) {
	// this.metric = metric;
	// }
	//
	// /**
	// * @return the lowerBound
	// */
	// public String getLowerBound() {
	// return lowerBound;
	// }
	//
	// /**
	// * @param lowerBound
	// * the lowerBound to set
	// */
	// public void setLowerBound(String lowerBound) {
	// this.lowerBound = lowerBound;
	// }
	//
	// /**
	// * @return the upperBound
	// */
	// public String getUpperBound() {
	// return upperBound;
	// }
	//
	// /**
	// * @param upperBound
	// * the upperBound to set
	// */
	// public void setUpperBound(String upperBound) {
	// this.upperBound = upperBound;
	// }
}

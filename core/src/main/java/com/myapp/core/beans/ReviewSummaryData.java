package com.myapp.core.beans;

public class ReviewSummaryData 
{
	private Long id;
	private String storeId;
	private Integer numberOfRatings;
	private Integer numberOfReviews;
	private Double avgReviewRating;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public Integer getNumberOfRatings() {
		return numberOfRatings;
	}
	public void setNumberOfRatings(Integer numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}
	public Integer getNumberOfReviews() {
		return numberOfReviews;
	}
	public void setNumberOfReviews(Integer numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}
	public Double getAvgReviewRating() {
		return avgReviewRating;
	}
	public void setAvgReviewRating(Double avgReviewRating) {
		this.avgReviewRating = avgReviewRating;
	}
}

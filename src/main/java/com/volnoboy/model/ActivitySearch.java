package com.volnoboy.model;

import java.util.List;

/**
 * @author Volodymyr Volnoboy (vvolnoboy@luxoft.com)
 * @since 2/4/15 1:29 PM
 */
public class ActivitySearch {

	private int durationFrom;
	private int durationTo;

	private List<String> description;

	private ActivitySearchType searchType;

	public ActivitySearchType getSearchType() {
		return searchType;
	}

	public void setSearchType(ActivitySearchType searchType) {
		this.searchType = searchType;
	}

	public int getDurationFrom() {
		return durationFrom;
	}

	public void setDurationFrom(int durationFrom) {
		this.durationFrom = durationFrom;
	}

	public int getDurationTo() {
		return durationTo;
	}

	public void setDurationTo(int durationTo) {
		this.durationTo = durationTo;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}
}

package com.volnoboy.repository;

import com.volnoboy.model.Activity;

import java.util.List;

/**
 * Created by Reuven on 1/25/15.
 */
public interface ActivityRepository {
	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void createActivity();
}

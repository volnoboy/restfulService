package com.volnoboy.repository;

import java.util.List;

import com.volnoboy.model.Activity;
import com.volnoboy.model.ActivitySearch;

/**
 * Created by Reuven on 1/25/15.
 */
public interface ActivityRepository {
	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void createActivity();

	Activity update(Activity activity);

	void delete(String activityId);

	List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

	List<Activity> findByConstraints(ActivitySearch search);
}

package com.volnoboy.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.volnoboy.model.Activity;
import com.volnoboy.model.ActivitySearch;
import com.volnoboy.model.User;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Reuven on 1/25/15.
 */
public class ActivityRepositoryStub implements ActivityRepository {

	@Override
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		activities.add(generateActivity());
		activities.add(generateActivity());
		return activities;
	}

	@Override
	public Activity findActivity(String activityId) {
		if(activityId.equals("7777")) {
			return null;
		}
		return generateActivity();
	}

	@Override
	public void createActivity() {
		System.out.print("Created...");
	}

	@Override
	public Activity update(Activity activity) {
		return activity;
	}

	@Override
	public void delete(String activityId) {

	}

	@Override
	public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {
		List<Activity> activities = new ArrayList<Activity>();
		activities.add(generateActivity());
		return activities;
	}

	@Override
	public List<Activity> findByConstraints(ActivitySearch search) {
		System.out.println(search.toString());
		System.out.println(search.getSearchType());
		List<Activity> activities = new ArrayList<Activity>();
		activities.add(generateActivity());
		return activities;
	}


	private Activity generateActivity() {
		Activity activity = new Activity();
		activity.setId(new RandomStringUtils().randomNumeric(5));
		activity.setDuration(new Random().nextInt());
		activity.setDescription(new RandomStringUtils().randomAlphabetic(10));
		activity.setUser(generateUser());
		return activity;
	}

	private User generateUser() {
		User user = new User();
		user.setId(new RandomStringUtils().randomNumeric(5));
		user.setName(new RandomStringUtils().randomAlphabetic(10));
		return user;
	}

}

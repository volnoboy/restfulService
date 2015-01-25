package com.volnoboy.repository;

import com.volnoboy.model.Activity;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	private Activity generateActivity() {
		Activity activity = new Activity();
		activity.setDuration(new Random().nextInt());
		activity.setDescription(new RandomStringUtils().randomAlphabetic(200));
		return activity;
	}
}

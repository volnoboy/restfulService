package com.volnoboy.client;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.volnoboy.model.Activity;
import com.volnoboy.model.ActivitySearch;
import com.volnoboy.model.ActivitySearchType;
import org.junit.Test;

/**
 * @author Volodymyr Volnoboy (vvolnoboy@luxoft.com)
 * @since 1/27/15 12:06 PM
 */
public class ActivityClientTest {

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();

		Activity activity = client.get("1234");

		System.out.println(activity.getUser().getName()+ activity.getUser().getId() + activity.getDescription()  + activity.getDuration() + activity.getId());

		assertNotNull(activity);
	}

	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		List<Activity> activities  = client.get();
		assertNotNull(activities);
	}

	@Test(expected = RuntimeException.class)
	public void testGetWithBadRequest() {
		ActivityClient client = new ActivityClient();
		client.get("123");
	}

	@Test(expected = RuntimeException.class)
	public void testGetWithNotFound() {
		ActivityClient client = new ActivityClient();
		client.get("7777");
	}

	@Test
	public void testCreate() {
		ActivityClient client = new ActivityClient();
		Activity activity = new Activity();
		activity.setDescription("sdf");
		activity.setDuration(11);
		activity = client.create(activity);
		assertNotNull(activity);
	}

	@Test
	public void testPut() {
		Activity activity = new Activity();
		activity.setId("123");
		activity.setDescription("asf");
		activity.setDuration(20);
		ActivityClient activityClient = new ActivityClient();
		activity = activityClient.update(activity);
		assertNotNull(activity);
	}

	@Test
	public void testDelete() {
		ActivityClient activityClient = new ActivityClient();
		activityClient.delete("77772");
	}

	@Test
	public void testSearch() {
		ActivitySearchClient activitySearchClient = new ActivitySearchClient();
		String param = "description";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("egfj");
		searchValues.add("dgfv");

		String secondParam = "durationFrom";
		int durationFrom = 30;
		String thirdParam = "durationTo";
		int durationTo = 55;

		List<Activity> activities = activitySearchClient.search(param, searchValues, secondParam, durationFrom, thirdParam, durationTo);

		System.out.println(activities);

		assertNotNull(activities);
	}

	@Test
	public void testSearchObject() {
		ActivitySearchClient activitySearchClient = new ActivitySearchClient();

		List<String> searchValues = new ArrayList<String>();
		searchValues.add("wdcf");
		searchValues.add("dfdswf");


		ActivitySearch search = new ActivitySearch();
		search.setDescription(searchValues);
		search.setDurationFrom(1);
		search.setDurationTo(3);
		search.setSearchType(ActivitySearchType.SEARCH_BY_DESCRIPTION);

		List<Activity> activities = activitySearchClient.search(search);
		assertNotNull(activities);
	}
}

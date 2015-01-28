package com.volnoboy.client;

import org.junit.Test;

import com.volnoboy.model.Activity;

import java.util.List;

import static org.junit.Assert.assertNotNull;

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
}

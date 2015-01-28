package com.volnoboy;

import com.volnoboy.model.Activity;
import com.volnoboy.model.User;
import com.volnoboy.repository.ActivityRepository;
import com.volnoboy.repository.ActivityRepositoryStub;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Reuven on 1/25/15.
 */
@Path("activities")
public class ActivityResource {

private ActivityRepository activityRepository = new ActivityRepositoryStub();

	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivity(Activity activity) {
		return activity;
	}

	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(Activity activity) {
		activity = activityRepository.update(activity);
		return Response.ok().entity(activity).build();
	}


	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivityParam(MultivaluedMap<String, String> formParams) {
		System.out.print(formParams.getFirst("description"));
		System.out.print(formParams.getFirst("duration"));
		Activity activity = new Activity();
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.valueOf(formParams.getFirst("duration")));
		activityRepository.createActivity();
		return activity;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities() {
		return activityRepository.findAllActivities();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}")
	public Response getActivity(@PathParam("activityId") String activityId) {
		if(activityId == null || activityId.length() < 4) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		Activity activity = activityRepository.findActivity(activityId);

		if (activity == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.ok().entity(activity).build();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}/user")
	public User getActivityUser(@PathParam("activityId") String activityId) {
		return activityRepository.findActivity(activityId).getUser();
	}
 }

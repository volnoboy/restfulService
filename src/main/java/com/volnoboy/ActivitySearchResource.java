package com.volnoboy;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.volnoboy.model.Activity;
import com.volnoboy.model.ActivitySearch;
import com.volnoboy.repository.ActivityRepository;
import com.volnoboy.repository.ActivityRepositoryStub;

/**
 * @author Volodymyr Volnoboy (vvolnoboy@luxoft.com)
 * @since 2/3/15 10:52 AM
 */
@Path("search/activities")
public class ActivitySearchResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchForActivities(@QueryParam(value = "description") List<String> descriptions,
	                                    @QueryParam(value = "durationFrom") int durationFrom,
										@QueryParam(value = "durationTo") int durationTo) {
		System.out.println(descriptions.toString() + durationFrom + durationTo);

		List<Activity> activities = activityRepository.findByDescription(descriptions, durationFrom, durationTo);

		if(activities == null || activities.size()<=0) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.ok().entity(new GenericEntity<List<Activity>>(activities){}).build();
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchForActivities(ActivitySearch search) {
		System.out.println(search.getDescription() + ", " + search.getDurationFrom());
		List<Activity> activities = activityRepository.findByConstraints(search);

		if (activities == null || activities.size() <= 0) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().entity(new GenericEntity<List<Activity>>(activities){}).build();
	}
}

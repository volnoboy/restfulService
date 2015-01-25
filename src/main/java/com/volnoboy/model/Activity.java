package com.volnoboy.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Reuven on 1/25/15.
 */
@XmlRootElement
public class Activity {

	private String Id;
	private String description;
	private int duration;
	private User user;

	public String getId() {
		return Id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(String id) {
		Id = id;
	}

	@XmlElement(name = "desc")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "duration")
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}

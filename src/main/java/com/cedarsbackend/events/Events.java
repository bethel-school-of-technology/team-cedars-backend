package com.cedarsbackend.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "events")
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "eventTitle")
	private String eventTitle;
	
	@Column(name = "hostName")
	private String hostName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "images")
	private String image;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "eventDescription")
	private String description;

	
	
	public Events(long id, String eventTitle, String hostName, String location, String image, String month, String date,
			String time, String description) {
		super();
		this.id = id;
		this.eventTitle = eventTitle;
		this.hostName = hostName;
		this.location = location;
		this.image = image;
		this.month = month;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	
	
	
	
	public Events() {
		
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}

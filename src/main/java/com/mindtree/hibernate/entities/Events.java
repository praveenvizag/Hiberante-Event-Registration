package com.mindtree.hibernate.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * Hibernate ORM class for Database Table: Events.
 * 
 * @author M1043827
 *
 */
/**
 * @author M1043827
 *
 */
@Entity
@Table(name = "EVENTS")
public class Events implements Serializable{

	private static final long serialVersionUID = -424760360882107181L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENT_ID")
	private Integer eventId;
	@Column(name = "EVENT_TITLE")
	private String eventTitle;
	@Column(name = "DESCRIPTION")
	private String description;
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Employees> employeeList = new ArrayList<Employees>();
	
	/**
	 * Default Constructor As Required by Hibernate.
	 */
	public Events() {
	}

	
	/**
	 * Constructor required to initialized the data.
	 * @param eventTitle EventTitle
	 * @param description Event Description
	 */
	public Events(String eventTitle, String description) {
		super();
		this.eventTitle = eventTitle;
		this.description = description;
	}


	public Collection<Employees> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Collection<Employees> employeeList) {
		this.employeeList = employeeList;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employeeList == null) ? 0 : employeeList.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((eventTitle == null) ? 0 : eventTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Events other = (Events) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeList == null) {
			if (other.employeeList != null)
				return false;
		} else if (!employeeList.equals(other.employeeList))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (eventTitle == null) {
			if (other.eventTitle != null)
				return false;
		} else if (!eventTitle.equals(other.eventTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName());
		builder.append(" [eventId=");
		builder.append(eventId);
		builder.append(", eventTitle=");
		builder.append(eventTitle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", employeeList=");
		builder.append(employeeList);
		builder.append("]");
		return builder.toString();
	}


}

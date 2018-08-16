package com.mindtree.hibernate.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Hibernate ORM class for Database Table: Employees.
 * 
 * @author M1043827
 *
 */
@Entity
@Table(name = "EMPLOYEES", schema = "eventregistration")
public class Employees implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer serial_number;
	@Column(name = "MID")
	private String mID;
	@Column(name = "NAME")
	private String name;
	@Column(name = "JOIN_DATE")
	private Date join_date;
	@Column(name = "EMAIL_ID")
	private String email_id;
	@ManyToMany(mappedBy="employeeList")
	private Collection<Events> eventList = new ArrayList<Events>();

	/**
	 * Default Constructor As Required by Hibernate.
	 */
	public Employees() {
	}

	/**
	 * Constructor Required to initialize the Data.
	 * 
	 * @param mID
	 *            Mindtree ID
	 * @param name
	 *            Employee Name
	 * @param join_date
	 *            Joining Date
	 * @param email_id
	 *            emali Id
	 */
	public Employees(String mID, String name, Date join_date, String email_id) {
		super();
		this.mID = mID;
		this.name = name;
		this.join_date = join_date;
		this.email_id = email_id;
	}

	public Integer getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(Integer serial_number) {
		this.serial_number = serial_number;
	}

	public String getmID() {
		return mID;
	}

	public void setmID(String mID) {
		this.mID = mID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Collection<Events> getEventList() {
		return eventList;
	}

	public void setEventList(Collection<Events> eventList) {
		this.eventList = eventList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email_id == null) ? 0 : email_id.hashCode());
		result = prime * result + ((eventList == null) ? 0 : eventList.hashCode());
		result = prime * result + ((join_date == null) ? 0 : join_date.hashCode());
		result = prime * result + ((mID == null) ? 0 : mID.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + serial_number;
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
		Employees other = (Employees) obj;
		if (email_id == null) {
			if (other.email_id != null)
				return false;
		} else if (!email_id.equals(other.email_id))
			return false;
		if (eventList == null) {
			if (other.eventList != null)
				return false;
		} else if (!eventList.equals(other.eventList))
			return false;
		if (join_date == null) {
			if (other.join_date != null)
				return false;
		} else if (!join_date.equals(other.join_date))
			return false;
		if (mID == null) {
			if (other.mID != null)
				return false;
		} else if (!mID.equals(other.mID))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (serial_number != other.serial_number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName());
		builder.append(" [serial_number=");
		builder.append(serial_number);
		builder.append(", mID=");
		builder.append(mID);
		builder.append(", name=");
		builder.append(name);
		builder.append(", join_date=");
		builder.append(join_date);
		builder.append(", email_id=");
		builder.append(email_id);
		builder.append(", eventList=");
		builder.append(eventList);
		builder.append("]");
		return builder.toString();
	}

}

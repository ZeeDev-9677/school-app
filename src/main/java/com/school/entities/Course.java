package com.school.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private long refId;
	/*
	 * @Column private Date dateTime;
	 * 
	 * public Date getDateTime() { return dateTime; }
	 * 
	 * public void setDateTime(Date dateTime) { this.dateTime = dateTime; }
	 */

	public long getRefId() {
		return refId;
	}

	public void setRefId(long refId) {
		this.refId = refId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * @Override public String toString() { return "Course [id=" + id + ", title=" +
	 * title + ", description=" + description + "]"; }
	 */

	/*
	 * public Course(long id, String title, String description) { super(); this.id =
	 * id; this.title = title; this.description = description; }
	 */

	public Course() {
		super(); // TODO Auto-generated constructor stub }
	}

}

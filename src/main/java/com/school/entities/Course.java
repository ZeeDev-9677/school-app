package com.school.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

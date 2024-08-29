package com.school.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name = "student")
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stud_id", unique = true, nullable = false)
	private Long studId;

	@Column(length = 255)
	private String active;

	@Column(name = "first_name", length = 255)
	private String firstName;

	@Column(name = "last_name", length = 255)
	private String lastName;

	// bi-directional many-to-one association to Course
	/*
	 * @ManyToOne(cascade= {CascadeType.ALL},fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="course_id",nullable=false) private Course course;
	 */

	// generate below from db table
//	@ManyToOne(cascade={CascadeType.ALL})
//	@JoinColumn(name="student_crs_id", nullable=false)
//	private Course course;

	public Student() {
	}

	public Student(Long studId, String active, String firstName, String lastName) {
		super();
		this.studId = studId;
		this.active = active;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getStudId() {
		return this.studId;
	}

	public void setStudId(Long studId) {
		this.studId = studId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public Course getCourse() {
//		return this.course;
//	}
//
//	public void setCourse(Course course) {
//		this.course = course;
//	}

}
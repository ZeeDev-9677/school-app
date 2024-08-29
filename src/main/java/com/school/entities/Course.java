package com.school.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name = "course")
@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crs_id", unique = true, nullable = false)
	private Long crsId;

	@Column(length = 255)
	private String active;

	@Column(name = "crs_enroll", length = 255)
	private String crsEnroll;

	@Column(name = "crs_name", length = 255)
	private String crsName;

	// bi-directional many-to-one association to Student
	/*
	 * @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	 * 
	 * @JoinColumn
	 * 
	 * @OneToMany(mappedBy="course", cascade= {CascadeType.ALL}) private
	 * List<Student2> student;
	 */

//	mappedBy="course", 
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "student_crs_id_fkey")
	private List<Student> students;

	public Course() {
	}

	public Long getCrsId() {
		return this.crsId;
	}

	public void setCrsId(Long crsId) {
		this.crsId = crsId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCrsEnroll() {
		return this.crsEnroll;
	}

	public void setCrsEnroll(String crsEnroll) {
		this.crsEnroll = crsEnroll;
	}

	public String getCrsName() {
		return this.crsName;
	}

	public void setCrsName(String crsName) {
		this.crsName = crsName;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

//	public Student addStudent(Student student) {
//		getStudents().add(student);
//		student.setCourse(this);
//
//		return student;
//	}

//	public Student removeStudent(Student student) {
//		getStudents().remove(student);
//		student.setCourse(null);
//
//		return student;
//	}

}
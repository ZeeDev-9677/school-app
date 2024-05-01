package com.school.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_details", schema="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long empId;
	@Column(name = "emp_Name")
	private String empName;
	@Column(name = "emp_Salary")
	private Long empSalary;
	@Column(name = "emp_City")
	private String empCity;
}

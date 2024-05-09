package com.school.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

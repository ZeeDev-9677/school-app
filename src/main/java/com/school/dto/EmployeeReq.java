package com.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeReq {
	
	private long empId;
	private String empName;
	private long empSalary;
	private String empCity;
}

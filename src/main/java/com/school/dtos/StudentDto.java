package com.school.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {

	private Long studId;
	private String firstName;
	private String lastName;
	private String active;
//	private Integer rfId;
}

package com.school.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.school.dtos.CourseDto;
import com.school.dtos.CourseRespDto;
import com.school.entities.Course;

public interface CourseService {

	public List<CourseRespDto> getCourse();

	public ResponseEntity<Course> addCourse(CourseDto courseDto) throws Exception;

	public ResponseEntity<String> updateCourse(CourseDto courseDto);

	public ResponseEntity<String> deleteCourse(CourseDto courseDto);


//	  public Course getCourse(long courseId);

//	public ResponseEntity<Course> addCourse(CourseDto courseDto);

//	  public ResponseEntity<String> updateCourse(CourseDto courseDto);
	/*
	 * public ResponseEntity<Object> deleteCourse(CourseDto courseDto);
	 * 
	 * public ResponseEntity<Object> deleteAllCourse();
	 * 
	 * public ResponseEntity<Object> deleteInBatch(List<Course> course);
	 * 
	 * public ResponseEntity<Object> deleteById(long courseId);
	 */

//	public Course findById(long courseId);

//	ResponseEntity<Course> addCourse(CourseDto courseDto);
}

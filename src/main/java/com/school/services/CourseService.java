package com.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.school.dtos.CourseDto;
import com.school.entities.Course;

public interface CourseService {

	public List<Course> getCourse();

	public Course getCourse(long courseId);

	public ResponseEntity<Object> addCourse(CourseDto courseDto);

	public ResponseEntity<Object> updateCourse(CourseDto courseDto);

	public ResponseEntity<Object> deleteCourse(CourseDto courseDto);

	public ResponseEntity<Object> deleteAllCourse();

	public ResponseEntity<Object> deleteInBatch(List<Course> course);

	public ResponseEntity<Object> deleteById(long courseId);

//	public Course findById(long courseId);

//	ResponseEntity<Course> addCourse(CourseDto courseDto);
}

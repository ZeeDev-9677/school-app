package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.dtos.CourseDto;
import com.school.entities.Course;
import com.school.services.CourseService;

@RestController
@RequestMapping("/v1")
public class SchoolController {

	@Autowired
	private CourseService courseservice;

	// ************testing of get request***********************
	@RequestMapping(value = "/testt", method = RequestMethod.GET)
	public String getHome() {
		String str = "Hello I am";
		return str;
	}

	// ************working end point for get request***********************
	@RequestMapping(value = "/crss", method = RequestMethod.GET)
	public List<Course> getCourse() throws Exception {

		return this.courseservice.getCourse();

	}

	// ******working end point for get request for particular deleted Id******

	// for dynamic value we have to write in curly bracket'{}' or if
	// we want get specific value of variable we use {} like
	// courseId here
	@RequestMapping(value = "/api/Singlecourse/{courseId}", method = RequestMethod.GET)
	public Course getSingleCourse(@PathVariable String courseId) {
		Course course = courseservice.getCourse(Long.parseLong(courseId));
//		courseservice.findById(Long.parseLong(courseId));
		return course;
	}

	// ************working end point for add request***********************
//	@RequestMapping(value = "/api/courseAdd", method = RequestMethod.POST)
//	public ResponseEntity<?> addCourse(@NonNull @RequestBody Course course) {
//		if (course.toString() == null) {
//			throw new NullPointerException("params getting null");
//		} else {
//			return this.courseservice.addCourse(course);
//		}
//	}

	@RequestMapping(value = "/api/courseAdd", method = RequestMethod.POST)
	public ResponseEntity<Object> addCourse(@RequestBody CourseDto courseDto) {
		this.courseservice.addCourse(courseDto);
		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	// ************working end point for update request***********************
	@RequestMapping(value = "/api/courses", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCourse(@RequestBody CourseDto courseDto) {
		this.courseservice.updateCourse(courseDto);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	// ************working end point deletion of particular Id********
	@RequestMapping(value = "/api/courseDel/{courseId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCourse(@PathVariable String courseId) {

		this.courseservice.deleteById(Long.parseLong(courseId));
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/api/courseDel", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCourse(@RequestBody CourseDto courseDto) {
		this.courseservice.deleteCourse(courseDto);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// ************working end point for delete in batch***********************

	@RequestMapping(value = "/api/deleteInbatch", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteInBatch(@RequestBody List<Course> course) {
		courseservice.deleteInBatch(course);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

	}

	// ******working end point for delete All request(all entity will delete****
	@RequestMapping(value = "/api/deleteAllCourses", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllCourse() {
		this.courseservice.deleteAllCourse();
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

	}
}
package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.dtos.CourseDto;
import com.school.dtos.CourseRespDto;
import com.school.dtos.StudentDto;
import com.school.dtos.StudentRespDto;
import com.school.services.CourseService;
import com.school.services.StudentService;

@RestController
@RequestMapping("/v1")
public class SchoolController {

	@Autowired
	private CourseService courseservice;
	@Autowired
	private StudentService studentService;

	// ************testing of get request***********************
	@RequestMapping(value = "/testt", method = RequestMethod.GET)
	public String getHome() {
		String str = "Hello I am";
		return str;
	}

	// ************working end point for get AllCourse***********************

	@RequestMapping(value = "/api/course", method = RequestMethod.GET)
	public List<CourseRespDto> getAllCourse() throws Exception {

		return this.courseservice.getCourse();
	}
	

	// ************working end point for get All Student***********************
	@RequestMapping(value = "/api/student", method = RequestMethod.GET)
	public List<StudentRespDto> getAllStudent() throws Exception {

		return this.studentService.getAllStudents();

	}
	
	// ************working end point for Adding Course***********************
	@RequestMapping(value = "/api/courseAdd", method = RequestMethod.POST)
	public ResponseEntity<String> addCourse(@RequestBody CourseDto courseDto) throws Exception {
		this.courseservice.addCourse(courseDto);
		return ResponseEntity.ok("Data Saved Successfully");
//		return new ResponseEntity<Course>(HttpStatus.OK);
	}

	// ************working end point for Update Course***********************

	@RequestMapping(value = "/api/updateCrs", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCourse(@RequestBody CourseDto courseDto) {
		this.courseservice.updateCourse(courseDto);
		return ResponseEntity.ok("Data Updated Successfully");
	}

	// ************working end point to delete Course by using CourseId********

	@RequestMapping(value = "/api/courseDel", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCourse(@RequestBody CourseDto courseDto) {
		this.courseservice.deleteCourse(courseDto);
		return ResponseEntity.ok("Deleted Successfully");
	}

	// ************working end point to delete Student by using StudentId********
	
	@RequestMapping(value = "/api/studDel", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudent(@RequestBody StudentDto studentDto) {
		this.studentService.deleteStudent(studentDto);
		return  ResponseEntity.ok("Deleted Successfully");
	}

	
	// ************working end point for get Single Student***********************
		@RequestMapping(value = "/api/student/ft", method = RequestMethod.GET)
		public ResponseEntity<StudentRespDto> getSingleStudent(@RequestBody StudentDto studentDto) {

			return this.studentService.getStudent(studentDto);

		}
	// ******working end point for get request for particular deleted Id******

	// for dynamic value we have to write in curly bracket'{}' or if // we want
	/*
	 * get specific value of variable we use {} like // courseId here
	 * 
	 * @RequestMapping(value = "/api/Singlecourse/{courseId}", method =
	 * RequestMethod.GET) public Course getSingleCourse(@PathVariable String
	 * courseId) { Course course =
	 * courseservice.getCourse(Long.parseLong(courseId)); //
	 * courseservice.findById(Long.parseLong(courseId)); return course; }
	 */

	// ************working end point for add request***********************
//	@RequestMapping(value = "/api/courseAdd", method = RequestMethod.POST)
//	public ResponseEntity<?> addCourse(@NonNull @RequestBody Course course) {
//		if (course.toString() == null) {
//			throw new NullPointerException("params getting null");
//		} else {
//			return this.courseservice.addCourse(course);
//		}
//	}


	// ************working end point for delete in batch***********************

//	@RequestMapping(value = "/api/deleteInbatch", method = RequestMethod.DELETE)
//	public ResponseEntity<Object> deleteInBatch(@RequestBody List<Course> course) {
//		courseservice.deleteInBatch(course);
//		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
//
//	}

	// ******working end point for delete All request(all entity will delete****

//	@RequestMapping(value = "/api/deleteAllCourses", method = RequestMethod.DELETE)
//	public ResponseEntity<?> deleteAllCourse() {
//		this.courseservice.deleteAllCourse();
//		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
//
//	}

}
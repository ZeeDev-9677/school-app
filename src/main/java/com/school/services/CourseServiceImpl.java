package com.school.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.dao.CourseDao;
import com.school.dtos.CourseDto;
import com.school.entities.Course;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	public CourseDao courseDao;
	ModelMapper modelMapper = new ModelMapper();

	public CourseServiceImpl() {
		/*
		 * list=new ArrayList<>(); list.add(new
		 * Course(145,"Java Basics","this is for beginners")); list.add(new
		 * Course(146,"React Basics","this is for intermediate"));
		 */
	}

	@Override
	public List<Course> getCourse() {
		log.debug("BEGIN:: getAllStudents() debug started here");

		log.debug("END:: getAllStudents() debug end here");

		return this.courseDao.findAll();

//		return courseDao.findByTitleAndRefId("golang",1123); //		---->> CUSTOM FINDER METHOD
	}

	@Override
	public Course getCourse(long courseId) {

		/*
		 * Course c=null; for(Course cors:list) { if(cors.getId()==courseId) { c=cors;
		 * break; } } return c;
		 */
		log.info("BEGIN:: getCourse()");

//		 return (Course) courseDao.getReferenceById(courseId);
		Course course = courseDao.findCourseById(courseId);
		Course courseObj = new Course();
		courseObj.setId(course.getId());
		courseObj.setDescription(course.getDescription());
		courseObj.setRefId(course.getRefId());
		courseObj.setTitle(course.getTitle());

		log.info("END:: getCourse()");
		return courseObj;
	}

	@Override
	public ResponseEntity<Object> addCourse(CourseDto courseDto) {
		log.info("BEGIN:: addCourse()");
		if (courseDto.getCourseDescription().equals("")) {
			throw new NullPointerException("Null arha hai bhai");
		}
		try {
			Course course = modelMapper.map(courseDto, Course.class);
			course.setId(Long.valueOf(courseDto.getId()));
			course.setDescription(String.valueOf(courseDto.getCourseDescription()));
			course.setTitle(String.valueOf(courseDto.getCourseTitle()));
			course.setRefId(Long.parseLong(courseDto.getCourseRefId()));
			courseDao.save(course);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("END:: addCourse()");
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updateCourse(@RequestBody CourseDto courseDto) {
		/*
		 * list.forEach(e->{ if(e.getId()==course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * }); return course;
		 */
		log.info("BEGIN:: updateCourse");
		if (courseDto == null) {
			throw new NullPointerException("courseDto should not be null");
		}
		try {
			Course course = modelMapper.map(courseDto, Course.class);
			course.setId(courseDto.getId());
			course.setDescription(String.valueOf(courseDto.getCourseDescription()));
			course.setTitle(String.valueOf(courseDto.getCourseTitle()));
			course.setRefId(Long.valueOf(courseDto.getCourseRefId()));
			courseDao.save(course);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("END:: updateCourse");
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

//	@Override
//	public ResponseEntity<Object> deleteCourse(@RequestBody long parseLong) {
//		/*
//		 * list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.
//		 * toList()); return null;
//		 */
//		courseDao.deleteById(parseLong);
//		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
//
//	}

	@Override
	public ResponseEntity<Object> deleteCourse(@RequestBody CourseDto courseDto) {
		/*
		 * list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.
		 * toList()); return null;
		 */
		log.info("BEGIN:: deleteCourse");
		if (courseDto == null) {
			throw new NullPointerException("courseDto should not be null");
		}
		try {
			Course course = modelMapper.map(courseDto, Course.class);
			course.setId(Long.valueOf(courseDto.getId()));
			course.setDescription(String.valueOf(courseDto.getCourseDescription()));
			course.setTitle(String.valueOf(courseDto.getCourseTitle()));
			course.setRefId(Long.parseLong(courseDto.getCourseRefId()));
			courseDao.delete(course);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("END:: deleteCourse");
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

	}

	@Override
	public ResponseEntity<Object> deleteAllCourse() {
		try {
			log.info("BEGIN:: deleteCourse");
			courseDao.deleteAll();
			log.info("END:: deleteCourse");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> deleteInBatch(List<Course> course) {
		try {
			log.info("BEGIN:: deleteInBatch");
			courseDao.deleteAllInBatch(course);
			log.info("END:: deleteInBatch");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Object> deleteById(long courseId) {
		try {
			log.info("BEGIN:: deleteById");
			courseDao.deleteById(courseId);
			log.info("END:: deleteById");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

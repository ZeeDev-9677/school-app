package com.school.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.dao.CourseDao;
import com.school.dtos.CourseDto;
import com.school.dtos.CourseRespDto;
import com.school.dtos.StudentDto;
import com.school.entities.Course;
//import com.school.entities.Course2;
//import com.school.entities.Student2;
import com.school.entities.Student;

//import jakarta.persistence.Query;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
//	@Autowired
//	public CourseDao courseDao;
//	public StudentDao studentDao;
	private final CourseDao courseDao;
//	private final StudentDao studentDao;
	ModelMapper modelMapper = new ModelMapper();

	public CourseServiceImpl(CourseDao courseDao) {
		this.courseDao = courseDao;
		/*
		 * list=new ArrayList<>(); list.add(new
		 * Course(145,"Java Basics","this is for beginners")); list.add(new
		 * Course(146,"React Basics","this is for intermediate"));
		 */
	}

	@Override
	public List<CourseRespDto> getCourse() {
		log.info("BEGIN:: getAllCourse()");
		List<CourseRespDto> list = new ArrayList<>();
		List<Course> courseList = courseDao.findAll();
		for (Course cr : courseList) {
			CourseRespDto courseResp = new CourseRespDto();
			courseResp.setCrsId(cr.getCrsId());
			courseResp.setActive(cr.getActive());
			courseResp.setCrsEnroll(cr.getCrsEnroll());
			courseResp.setCrsNm(cr.getCrsName());
			list.add(courseResp);
		}
		log.info("END:: getAllCourse()");
		return list;
	}


	/*
	 * @Override public Course getCourse(long courseId) {
	 * 
	 * 
	 * Course c=null; for(Course cors:list) { if(cors.getId()==courseId) { c=cors;
	 * break; } } return c;
	 * 
	 * log.info("BEGIN:: getCourse()");
	 * 
	 * // return (Course) courseDao.getReferenceById(courseId); Course course =
	 * courseDao.findCourseById(courseId); Course courseObj = new Course();
	 * courseObj.setCrId(course.getCrId());
	 * courseObj.setDescription(course.getDescription());
	 * courseObj.setRefId(course.getRefId()); courseObj.setTitle(course.getTitle());
	 * 
	 * log.info("END:: getCourse()"); return courseObj; }
	 */

	@Override
//	@Transactional
	public ResponseEntity<Course> addCourse(CourseDto courseDto) throws Exception {
		log.info("BEGIN:: addCourse()");
//		if (courseDto.getDescription().equals("")) {
//			throw new NullPointerException("Null arha hai bhai");
//		}
//		if(null==courseDto.getCrsId())
//		{
//			log.info("null value arha");
//		}
//		try {

		Course course = modelMapper.map(courseDto, Course.class);
//		Course cr=new Course();
////		Integer crsId=null;
//		if(null!=courseDto.getCrsId() || !"".equals(courseDto.getCrsId())) {
//			cr.setCrsId(Long.valueOf(courseDto.getCrsId()));
//			cr=courseDao.findByCrsId(Long.valueOf(courseDto.getCrsId()));
////			Long crsId=cr.getCrsId();
//			
//		}

		course.setCrsEnroll(String.valueOf(courseDto.getCrsEnroll()));
		course.setCrsName(String.valueOf(courseDto.getCrsNm()));
		course.setActive("Y");
		List<Student> studList = new ArrayList<>();
		for (StudentDto studentDto : courseDto.getStudentDto()) {
			Student student = new Student();
			student.setFirstName(studentDto.getFirstName());
			student.setLastName(studentDto.getLastName());
			student.setActive("Y");
			studList.add(student);
		}

		course.setStudents(studList);
		courseDao.save(course);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		log.info("END:: addCourse()");
		return new ResponseEntity<Course>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updateCourse(@RequestBody CourseDto courseDto) { // /* // * list.forEach(e->{
		/*
		 * if (e.getId() == course.getId()) { // * e.setTitle(course.getTitle());
		 * e.setDescription(course.getDescription()); } // * }); return course; //
		 */
		log.info("BEGIN:: updateCourse");
//		if (courseDto == null) {
//			throw new NullPointerException("courseDto should not be null");
//		}
//		try {
		Course course = modelMapper.map(courseDto, Course.class);
		course.setCrsId(Long.valueOf(courseDto.getCrsId()));
		course.setCrsName(String.valueOf(courseDto.getCrsNm()));
//		try{
		Course crsEn = courseDao.findByCrsId(Long.valueOf(courseDto.getCrsId()));
		if (null != courseDto.getCrsEnroll() && !courseDto.getCrsEnroll().equals(crsEn.getCrsEnroll())) {
			course.setCrsEnroll(String.valueOf(courseDto.getCrsEnroll()));
		}
//		}
//		catch(Exception e) { 
//			log.info(e.getMessage());
//		}
//		
		else {
			log.error(courseDto.getCrsEnroll() + " Already Exist!");
		}

		course.setActive("Y");
		courseDao.save(course);

//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		log.info("END:: updateCourse");
		return ResponseEntity.ok("Data Updated Successfully");

	}

	@Override
	public ResponseEntity<String> deleteCourse(CourseDto courseDto) {
		/*
		 * list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.
		 * toList()); return null;
		 */
		Course course = modelMapper.map(courseDto, Course.class);
		Course crsEn = courseDao.findByCrsId(Long.valueOf(courseDto.getCrsId()));
		course.setCrsId(crsEn.getCrsId());
		course.setCrsEnroll(crsEn.getCrsEnroll());
		course.setCrsName(crsEn.getCrsName());
		courseDao.delete(course);
		return ResponseEntity.ok("Deleted Successfully");

	}
//
//	@Override
//	public ResponseEntity<Object> deleteCourse(@RequestBody CourseDto courseDto) {
//		/*
//		 * list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.
//		 * toList()); return null;
//		 */
//		log.info("BEGIN:: deleteCourse");
//		if (courseDto == null) {
//			throw new NullPointerException("courseDto should not be null");
//		}
//		try {
//			Course course = modelMapper.map(courseDto, Course.class);
//			course.setCrId(Long.valueOf(courseDto.getCrId()));
//			course.setDescription(String.valueOf(courseDto.getCourseDescription()));
//			course.setTitle(String.valueOf(courseDto.getCourseTitle()));
//			course.setRefId(Integer.valueOf(courseDto.getCourseRefId()));
//			courseDao.delete(course);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		log.info("END:: deleteCourse");
//		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
//
//	}
//
//	@Override
//	public ResponseEntity<Object> deleteAllCourse() {
//		try {
//			log.info("BEGIN:: deleteCourse");
//			courseDao.deleteAll();
//			log.info("END:: deleteCourse");
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	public ResponseEntity<Object> deleteInBatch(List<Course> course) {
//		try {
//			log.info("BEGIN:: deleteInBatch");
//			courseDao.deleteAllInBatch(course);
//			log.info("END:: deleteInBatch");
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@Override
//	public ResponseEntity<Object> deleteById(long courseId) {
//		try {
//			log.info("BEGIN:: deleteById");
//			courseDao.deleteById(courseId);
//			log.info("END:: deleteById");
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

}

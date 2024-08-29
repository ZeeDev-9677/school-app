package com.school.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.dao.StudentDao;
import com.school.dtos.StudentDto;
import com.school.dtos.StudentRespDto;
import com.school.entities.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

	private final StudentDao studentDao;
	ModelMapper modelMapper = new ModelMapper();

	public StudentServiceImpl(StudentDao studentDao) {
//		studentService
		this.studentDao = studentDao;
//		this.studentDao = studentDao;
		/*
		 * list=new ArrayList<>(); list.add(new
		 * Course(145,"Java Basics","this is for beginners")); list.add(new
		 * Course(146,"React Basics","this is for intermediate"));
		 */
	}

//	public StudentServiceImpl() {
//
//		/*
//		 * list = new ArrayList<>(); list.add(new Student("Abdul", "12/c north road",
//		 * 123, "Samad", "Rehana", "45467768879")); list.add(new Student("sakir",
//		 * "642B, kyd road", 737, "Masam", "kayenath", "93735455")); list.add(new
//		 * Student("Sufi", "D.H samandh road", 2233, "Fahim", "Shaheen", "8548575757"));
//		 */
//
//	}

	@Override
	public List<StudentRespDto> getAllStudents() {

//		List<StudentRespDto> list = new ArrayList<>();
//		List<Student> studentList = studentDao.findAll();
//		StudentRespDto dsp=new StudentRespDto();
//		studentList.stream().forEach(x -> list.add(dsp.getActive(studentList.set)));
//		return list;

		List<StudentRespDto> list = new ArrayList<>();
		List<Student> studentList = studentDao.findAll();
		for (Student cr : studentList) {
			StudentRespDto studResp = new StudentRespDto();
			studResp.setStudId(cr.getStudId());
			studResp.setFirstName(cr.getFirstName());
			studResp.setLastName(cr.getLastName());
			studResp.setActive(cr.getActive());
			list.add(studResp);
		}

//		log.info("END:: getAllStudent()" + list); /* to check in Junit testCase working or not, will print passing data */
		log.info("END:: getAllStudent()");
		return list;
	}

	@Override
	public ResponseEntity<String> deleteStudent(StudentDto studentDto) {
		log.info("BEGIN:: deleteStudent()");
		Student student = modelMapper.map(studentDto, Student.class);
		Student crsEn = studentDao.findByStudId(Long.valueOf(studentDto.getStudId()));
		student.setStudId(crsEn.getStudId());
		student.setFirstName(crsEn.getFirstName());
		student.setFirstName(crsEn.getLastName());

		studentDao.delete(student);
		log.info("END:: deleteStudent()");
		return ResponseEntity.ok("Deleted Successfully");

	}

	@Override
	public ResponseEntity<StudentRespDto> getStudent(StudentDto studentDto) {
		log.info("BEGIN:: getStudent()");

		Student student = modelMapper.map(studentDto, Student.class);
		Student crsEn = studentDao.findByFirstName(student.getFirstName());
		StudentRespDto studentRespDto = new StudentRespDto();
		studentRespDto.setStudId(crsEn.getStudId());
		studentRespDto.setFirstName(crsEn.getFirstName());
		studentRespDto.setLastName(crsEn.getLastName());
		studentRespDto.setActive(crsEn.getActive());

		log.info("END:: getStudent()");
		return new ResponseEntity<StudentRespDto>(studentRespDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * @Override public void update(Long id) {
	 * 
	 * list.forEach(e-> { if(e.getName() == student_name.getName()) {
	 * e.setName(student_name.getName()); }
	 * 
	 * });
	 * 
	 * 
	 * } }
	 */

//	@Override
//	public Student getStudents(Long id) { 
//		java.util.Optional<Student> s = studentDao.findById(id);
//		return s.get();
//
//	}
//
//	@Override
//	public void delete(Long id) {
//		studentDao.deleteById(id);
//
//	}
//
//	@Override
//	public void update(Student student, Long id) {
//
//		studentDao.save(student);
//	}
//
//	@Override
//	public List<Student> getStudentByAge(Long age) {
//
//		return studentDao.getStudentByAge();
//	}
//
//	@Override
//	public ResponseEntity<HttpStatus> getByStudentId(Long id) {
//
//		try {
//			this.studentDao.findById(id);
//			System.out.println("Data is present in db");
//
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

}

package com.school.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.school.dtos.StudentDto;
import com.school.dtos.StudentRespDto;

public interface StudentService {

	public List<StudentRespDto> getAllStudents();

	public ResponseEntity<String> deleteStudent(StudentDto studentDto);

	ResponseEntity<StudentRespDto> getStudent(StudentDto studentDto);

//	public Student getStudents(Long id);
//
//	void delete(Long id);
//
//	public void update(Student student, Long id);
//
//	public List<Student> getStudentByAge(Long age);
//
//	public  ResponseEntity<HttpStatus> getByStudentId(Long id);

}

package com.school.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.school.entities.Student;

public interface StudentService {

	public Student addStudents(Student students);

	public List<Student> getAllStudents();

	public Student getStudents(Long id);

	void delete(Long id);

	public void update(Student student, Long id);

	public List<Student> getStudentByAge(Long age);

	public  ResponseEntity<HttpStatus> getByStudentId(Long id);

	

	

}

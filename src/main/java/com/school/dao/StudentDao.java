package com.school.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.entities.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Long> {

	@Query(value = "SELECT * FROM STUDENT s WHERE s.age= 107", nativeQuery = true)
	public List<Student> getStudentByAge();

}

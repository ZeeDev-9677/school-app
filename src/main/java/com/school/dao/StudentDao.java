package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entities.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

	Student findByStudId(Long studId);

	Student findByFirstName(String name);

//	@Query(value = "SELECT * FROM STUDENT s WHERE s.age= 107", nativeQuery = true)
//	public List<Student> getStudentByAge();

//	public List<Student> findByStudIdAndActive(long studId, String active);

//	public List<Student> findAllById();

}

package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entities.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {

	Course findByCrsId(Long crsId);
//	Boolean findByCrsName(String s);


//	Course findByCrsIdAndActive(Long crsId, String active);

	/*
	 * @Query("Select * from course where id=:29") Boolean isCourseExistById(Long
	 * id);
	 */

//	List<Course> findByTitleAndRefId(String title, long refId); //	---->> CUSTOM FINDER METHOD

//	Course findCourseById(long courseId);

}

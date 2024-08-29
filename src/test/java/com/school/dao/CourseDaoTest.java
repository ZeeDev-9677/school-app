package com.school.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.school.entities.Course;
import com.school.main.SchoolSpringProjectApplication;

@SpringBootTest(classes = SchoolSpringProjectApplication.class)
public class CourseDaoTest {

//	Course findByCrsId(Long crsId);

	@Autowired
	private CourseDao courseDao;

	/* will exceuted before each method */

//	@BeforeEach
//	void sumTest() {
//		System.out.println("BEFORE HERE BEFORE");
//	}

	@Disabled
	@Test
	void findByCrsIdTest1() {
		/* for success */
//		assertNotNull(courseDao.findByCrsId(3L));

		/* for failure */
//		assertNotNull(courseDao.findByCrsId(88L), "DATA NOT EXIST IN DB");

		/* to check CrsEnroll with its crsId is not empty */
		Course corse = courseDao.findByCrsId(3L);
		assertTrue(!corse.getCrsEnroll().isEmpty());

	}

	/*
	 * to check function working with given parameter value are exist in db or not
	 */
	@ParameterizedTest
	@ValueSource(longs = { 37, 67, 4, 8 })
	void findByCrsIdTest2(Long l) {

		assertNotNull(courseDao.findByCrsId(l), "FAILED FOR " + l);

	}
	/* will exceuted after each method */

//	@AfterEach
//	void prodTest() {
//		System.out.println("AFTER HERE AFTER");
//	}

	/* to check function works with parameter */
//	@ParameterizedTest
//	@CsvSource({ "1,2,3", "2,4,4", "5,1,6" })
//	public void parameterizedTest(int a, int b, int expected) {
//		assertEquals(expected, a + b);
//	}
}

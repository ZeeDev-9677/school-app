package com.school.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.school.main.SchoolSpringProjectApplication;

@SpringBootTest(classes = SchoolSpringProjectApplication.class)
public class StudentDaoTest {

	@Autowired
	StudentDao studentDao;
//	 Student findByStudId(Long studId);

	@AfterEach
	void aftr() {
		System.out.println("tearing up zeeshan");
	}

	@BeforeEach
	void bfr() {
		System.out.println("Setting down alam");
	}

	@Test
	void findByStudIdTest() {
		this.studentDao.findByStudId(6L);
		/* checking value from db correct or not */

//		Student st=studentDao.findByStudId(6L);
//		String nm=st.getFirstName();
//		String rsl="Mainus";
//		
//		assertThat(nm).isEqualTo(rsl);

	}
}

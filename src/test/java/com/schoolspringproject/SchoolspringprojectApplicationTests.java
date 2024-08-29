//package com.schoolspringproject;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.school.dao.StudentDao;
//import com.school.entities.Student;
//import com.school.main.SchoolSpringProjectApplication;
//
//@SpringBootTest(classes = SchoolSpringProjectApplication.class)
//class SchoolspringprojectApplicationTests {
//
////	private Calculator c=new Calculator();
////	
////	@Test
////	
////	void contextLoads() {
////	}
////
////	@Test
////	
////	void mySum() {
////		int expect=4;
////		int actualResult=c.mySum(1, 3);
////		assertThat(actualResult).isEqualTo(expect);
////	}
////	@Test
////	void myMul() {
////		int expect=8;
////		int d=c.myMul(4, 2);
////		assertThat(expect).isEqualTo(d);
////	}
////	@Test
////	void myCompare() {
////		boolean cmp=c.myCompare(2,2);
////		assertThat(cmp).isTrue();
////		
////	}
//	@Autowired
//	private StudentDao studentDao;
//
//	@Test
//	public void testFindByStudId() {
////		Student student = studentDao.findByStudId((long) 3);
////		assertTrue(student.getStudId());
//		assertNotNull(studentDao.findByStudId((long) 7));
//	}
//	@Test
//	public void addKar() {
//		assertTrue(6 > 3);
//	}
//}

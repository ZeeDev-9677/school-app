package com.school.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.school.dao.StudentDao;
import com.school.entities.Student;
import com.school.main.SchoolSpringProjectApplication;

@SpringBootTest(classes = SchoolSpringProjectApplication.class)
public class StudentServiceImplTest {
//	@Autowired
//	private StudentDao studentDao;
//	@InjectMocks
//	StudentServiceImpl studentServiceImpl;

//	@Test
//	public void testFindByStudId() {
////		Student student = studentDao.findByStudId((long) 3);
////		assertTrue(student.getStudId());
//		assertNotNull(studentDao.findByStudId((long) 7));
//	}
//	@Test
//	@Disabled
//	public void getAllStudents() {
////		this.studentServiceImpl.getAllStudents();
//		assertNotNull(studentDao.findByStudId((long) 7));
//
//    }
//	@Test
//	public void addKar() {
//		assertTrue(6 > 3);
//	}
//---------------------------------Testing service layer method without calling dao layer------------------------------------------------------------------------------

//	@InjectMocks
	@Autowired
	StudentServiceImpl studentServiceImpl;

	@MockBean
	StudentDao studentDao;

	@Test
	void getAllStudentsTest() {
		when(studentDao.findAll())
				.thenReturn(Stream.of(new Student(24L, "Y", "Rahul", "Dev"), new Student(25L, "Y", "Qasim", "Naved"))
						.collect(Collectors.toList()));
		assertEquals(2, studentServiceImpl.getAllStudents().size());

	}
}

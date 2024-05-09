package com.school.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.dao.StudentDao;
import com.school.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {

	/* List<Student> list; */

	@Autowired
	private StudentDao studentDao;

	public StudentServiceImpl() {

		/*
		 * list = new ArrayList<>(); list.add(new Student("Abdul", "12/c north road",
		 * 123, "Samad", "Rehana", "45467768879")); list.add(new Student("sakir",
		 * "642B, kyd road", 737, "Masam", "kayenath", "93735455")); list.add(new
		 * Student("Sufi", "D.H samandh road", 2233, "Fahim", "Shaheen", "8548575757"));
		 */

	}

	@Override
	public List<Student> getAllStudents() {

		List<Student> St = new ArrayList<Student>();
		studentDao.findAll().forEach(student1 -> St.add(student1));
		return St;
	}

	/*
	 * @Override public Student getStudents(int roll_no) {
	 * 
	 * 
	 * 
	 * Student s = null;
	 * 
	 * for (Student stdu : list) { if (stdu.getRoll_no() == roll_no); { s = stdu;
	 * break; }
	 * 
	 * }
	 * 
	 * return studentDao.getOne(String id) }
	 */

	@Override
	public Student addStudents(Student students) {
		/*
		 * list.add(students); return students;
		 */
		return studentDao.save(students);
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

	@Override
	public Student getStudents(Long id) { 
		java.util.Optional<Student> s = studentDao.findById(id);
		return s.get();

	}

	@Override
	public void delete(Long id) {
		studentDao.deleteById(id);

	}

	@Override
	public void update(Student student, Long id) {

		studentDao.save(student);
	}

	@Override
	public List<Student> getStudentByAge(Long age) {

		return studentDao.getStudentByAge();
	}

	@Override
	public ResponseEntity<HttpStatus> getByStudentId(Long id) {

		try {
			this.studentDao.findById(id);
			System.out.println("Data is present in db");

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

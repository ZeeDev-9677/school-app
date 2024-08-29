package com.school.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.school.dao.EmployeeDao;
//import com.school.dao.EmployeeDao;
import com.school.dto.EmployeeReq;
import com.school.dto.EmployeeRes;
//import com.school.entities.Employee;

import lombok.extern.slf4j.Slf4j;

//import com.school.entities.Employee;
//@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

//	@Autowired
//	EmployeeDao employeeDao;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public EmployeeReq saveAll(EmployeeReq employeeReq) {

		EmployeeReq m = modelMapper.map(employeeReq, EmployeeReq.class);
		//m.setEmpCity("Kolkata");
		//m.setEmpId(123);
		//m.setEmpName("ahagay");
		//m.setEmpSalary(233757);
//		Employee e=modelMapper.map(m, Employee.class);
//		employeeDao.save(e);
		return m;
	}

	@Override
	public List<EmployeeRes> getAllBySalary(EmployeeReq employeeReq) {
		// TODO Auto-generated method stub
		EmployeeReq m = modelMapper.map(employeeReq, EmployeeReq.class);
//		List<Employee> eSal=employeeDao.getAllBySalary(employeeReq);
		
		return null;
	}

//	@Override
//	public EmployeeReq saveEmp(EmployeeReq employeeReq) {
//		// EmployeeReq list=modelMapper.map(employeeReq,EmployeeReq.class);
//		EmployeeReq m = modelMapper.map(employeeReq, EmployeeReq.class);
//		employeeDao.saveAll(m);
//		return m;
//	}
}

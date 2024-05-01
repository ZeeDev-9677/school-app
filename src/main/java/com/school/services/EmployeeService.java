package com.school.services;

import java.util.List;

import com.school.dto.EmployeeReq;
import com.school.dto.EmployeeRes;

public interface EmployeeService {

	public EmployeeReq saveAll(EmployeeReq employeeReq);

	public List<EmployeeRes> getAllBySalary(EmployeeReq employeeReq);

}

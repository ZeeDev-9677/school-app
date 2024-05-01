package com.school.services;

import org.springframework.stereotype.Service;

import com.school.dto.PatientRes;
@Service
public class PatientServiceImpl implements PatientService{

	@Override
	public PatientRes findAll() {
		// TODO Auto-generated method stub
		
		PatientRes p=new PatientRes();
		p.setP_dob("29/02/2002");
		p.setP_name("Dak pro1");
		
		return p;
	}

}

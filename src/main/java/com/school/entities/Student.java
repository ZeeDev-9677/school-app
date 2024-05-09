package com.school.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO/* ,generator="native" */)
	/*
	 * @GenericGenerator( name = "native", strategy = "native" )
	 */
	@Column(unique = true, nullable = false)
	public Long id;

	@Column
	public String name;
	@Column
	public String address;
	@Column
	public String father_name;
	@Column
	public String mother_name;
	@Column
	public String ph_no;
	
	@Column
	public Integer age;
	@Column
	public Integer empId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getMother_name() {
		return mother_name;
	}
	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
    public Student() {
    	
    }
	
	public Student(Long id, String name, String address, String father_name, String mother_name, String ph_no,
			Integer age, Integer empId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.father_name = father_name;
		this.mother_name = mother_name;
		this.ph_no = ph_no;
		this.age = age;
		this.empId = empId;
	}
	
	
	
	
	

}

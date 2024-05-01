package com.schoolspringproject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class SchoolspringprojectApplicationTests {

	private Calculator c=new Calculator();
	
	@Test
	
	void contextLoads() {
	}

	@Test
	
	void mySum() {
		int expect=4;
		int actualResult=c.mySum(1, 3);
		assertThat(actualResult).isEqualTo(expect);
	}
	@Test
	void myMul() {
		int expect=8;
		int d=c.myMul(4, 2);
		assertThat(expect).isEqualTo(d);
	}
	@Test
	void myCompare() {
		boolean cmp=c.myCompare(2,2);
		assertThat(cmp).isTrue();
		
	}
}

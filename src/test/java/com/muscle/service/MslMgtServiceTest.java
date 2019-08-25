package com.muscle.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class MslMgtServiceTest{

	MslMgtService mslmgt;
	
	@Before
	public void setup() {
		this.mslmgt = new MslMgtServiceImpl();
	}
	
	
	@Test
	public void tst_basicMetabolismFormat() {
		String name = "iwatakhr";
		
		String basic = this.mslmgt.getBasalMetabolism(name);
		
		assertThat(basic, is("1489.9"));
	}

}

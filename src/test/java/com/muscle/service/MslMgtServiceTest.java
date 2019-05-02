package com.muscle.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class MslMgtServiceTest{

	@Before
	public void setup() {
		
	}
	
	@Test
	public void tst_getBasicMetabolismFormat() {
		MslMgtService mslMgtService = new MslMgtService(163d, 63d, 32);
		String basic = mslMgtService.getBasicMetabolismFormat();
		
		assertThat(basic, is("1493.75"));
	}
}

package com.muscle.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.muscle.repository.PersonalMapper;
import com.muscle.repository.entity.PersonalEntity;


public class MslMgtServiceTest{

	MslMgtServiceImpl mslmgt;
	
	@MockBean
	private PersonalMapper pmapper;
	
	@Before
	public void setup() {
		this.mslmgt = new MslMgtServiceImpl(pmapper);
	}
	
	
	// TODO モックを利用してテストできるようにする
	@Test
	public void tst_basicMetabolismFormat() {
		// テストパラメータ
		String name = "iwatakhr";
		
		// Mock
		PersonalEntity e1 = new PersonalEntity();
		e1.setId(1);
		e1.setName(name);
		e1.setHeight(160.3d);
		e1.setWeight(64.3d);
		e1.setAge(32);
		e1.setActivity(0);
		e1.setGoal(2);
		List<PersonalEntity> arrayList = new ArrayList<PersonalEntity>();
		arrayList.set(0, e1);
		
		Mockito.when(pmapper.selectByName(name)).thenReturn(arrayList);	
		Mockito.when(pmapper.selectById(any())).thenReturn(e1);
		
		String basic = this.mslmgt.getBasalMetabolism(name);
		
		assertThat(basic, is("1489.9"));
	}
	
//	@Test
//	public void tst_basicMetabolismFormat() {
//		String name = "iwatakhr";
//		
//		String basic = this.mslmgt.getBasalMetabolism(name);
//		
//		assertThat(basic, is("1489.9"));
//	}

}

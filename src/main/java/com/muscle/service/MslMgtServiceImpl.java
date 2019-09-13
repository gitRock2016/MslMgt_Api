package com.muscle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muscle.domain.Personal;
import com.muscle.repository.PersonalMapper;
import com.muscle.repository.entity.DBCode;
import com.muscle.repository.entity.PersonalEntity;

@Service
public class MslMgtServiceImpl implements MslMgtService {
	
	private final PersonalMapper personalMapper;
	
	// TODO コンストラクタでのインジェクションがいいって書いてた気がする、、、理由を理解しておくこと
	@Autowired
	public MslMgtServiceImpl(PersonalMapper personalMapper) {
		this.personalMapper = personalMapper;
	}

	@Override
	public String getBasalMetabolism(String name) {
		
		PersonalEntity pe = this.findPersonalByName(name);
		Personal p = new Personal( pe.getHeight()
												, pe.getWeight()
												, DBCode.getPersonalSex(pe.getSex())
												, pe.getAge()
												, DBCode.getPersonalActivity(pe.getActivity())
												, pe.getGoal());
		//	sample
		// Personal p = new Personal(160.3,64.3,32,0,2);
		String basalmetabolism = String.valueOf(p.getBasalMetabolism()); 
		return basalmetabolism;
	}
	
	// TODO このメソッドはrepository側にもたせたほうがいい？
	private PersonalEntity findPersonalByName(String name) {
		List<PersonalEntity> plist = personalMapper.selectByName(name);
		final Integer id = plist.get(0).getId(); // 運用上一意にきまる
		return personalMapper.selectById(id);
	}
	
	
	// TODO 後で作成
	@Override
	public String getCostCaloriesPerDay(String name) {
		return "120.1";
	}

}

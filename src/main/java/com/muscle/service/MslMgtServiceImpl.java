package com.muscle.service;

import domain.Personal;

public class MslMgtServiceImpl implements MslMgtService {

	@Override
	public String getBasalMetabolism(String name) {
		
		// TODO nameからDBの個人情報を取得する
		//		public Personal(double height, double weight, Integer age, Integer activitity, Integer goal) {
		//		160.3 	64.3 	32.0 	0.0 	2.0 	1.2
		Personal p = new Personal(160.3,64.3,32,0,2);
		String basalmetabolism = String.valueOf(p.getBasalMetabolism()); 

		//		return "120.1";
		return basalmetabolism;
	}
	
	// TODO 後で作成
	@Override
	public String getCostCaloriesPerDay(String name) {
		return "120.1";
	}

}

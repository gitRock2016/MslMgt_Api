package com.muscle.service.response;

import java.util.HashMap;
import java.util.Map;


public class BasalMetabolismResponse {
	private Map<String, Object> response;
	private static final String basalMetabolism = "basalMetabolism";
	
	public BasalMetabolismResponse(final String value) {
		this.response = new HashMap<String,Object>();
		this.response.put(basalMetabolism, value);
	}
	
//	public void setBasalMetabolism(String basalMetabolism) {
//		this.response.put(basalMetabolism, basalMetabolism);
//	}
	
	// 不変クラス
	public Map<String,Object> getResonse(){
		return new HashMap<String,Object>(this.response);
	}
	
	

}

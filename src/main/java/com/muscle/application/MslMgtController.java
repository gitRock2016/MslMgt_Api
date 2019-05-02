package com.muscle.application;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MslMgtController {
	
	@RequestMapping(value = "/get/basicMetabolism", method = RequestMethod.GET)
	public Map<String, Object> input(
			@RequestParam("height") String height,
			@RequestParam("weight") String weight,
			@RequestParam("age") String age) {
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("height", "163");
		hashMap.put("weight", "63");
		hashMap.put("age", "32");
		
		// https://dietgenius.jp/macro-nutrient-calculator/
		HashMap<String, Object> resp = new HashMap<String, Object>();
		resp.put("status", "OK");
		resp.put("basicMetabolism", "1493.75");
		
		
		return 	resp;
	}
}

package com.muscle.application;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muscle.service.MslMgtService;

@RestController
public class MslMgtController {
	
	@RequestMapping(value = "/get/basicMetabolism", method = RequestMethod.GET)
	public Map<String, Object> input(
			@RequestParam("height") String height,
			@RequestParam("weight") String weight,
			@RequestParam("age") String age) {
		
		// 動作確認レベルなので固定値で計算しとく
		MslMgtService mslMgtService = new MslMgtService(163d, 63d, 32);
		String basic = mslMgtService.getBasicMetabolismFormat();
		
		HashMap<String, Object> resp = new HashMap<String, Object>();
		resp.put("status", "OK");
		resp.put("basicMetabolism", basic);
		
		return 	resp;
	}
}

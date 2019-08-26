package com.muscle.application;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muscle.service.MslMgtService;
import com.muscle.service.MslMgtServiceImpl;
import com.muscle.service.response.BasalMetabolismResponse;

@RequestMapping(value = "/MslMgt/api")
@RestController
public class MslMgtController {
	
	// TODO Autowiredの各場所がコンストラクタになっていた。いつもフィールドにつけていたが、どこが正しいのか？
	// https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-first-application-annotations
	private final MslMgtService mslMgtService;
	
	@Autowired
	public MslMgtController(MslMgtServiceImpl mslMgtService) {
		this.mslMgtService = mslMgtService;
	}

	@RequestMapping(value = "/basalMetabolism", method = RequestMethod.GET)
	public Map<String, Object> basalMetabolism(@RequestParam("name") String name) {

		String b = mslMgtService.getBasalMetabolism(name);
		BasalMetabolismResponse res = new BasalMetabolismResponse(b);
		return res.getResonse();
	}

}

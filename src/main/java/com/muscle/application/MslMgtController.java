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

@RestController
public class MslMgtController {

	@Autowired
	private final MslMgtService mslMgtService = new MslMgtServiceImpl();

	@RequestMapping(value = "/basalMetabolism", method = RequestMethod.GET)
	public Map<String, Object> basalMetabolism(@RequestParam("name") String name) {

		String b = mslMgtService.getBasalMetabolism(name);
		BasalMetabolismResponse res = new BasalMetabolismResponse(b);
		return res.getResonse();
	}

}

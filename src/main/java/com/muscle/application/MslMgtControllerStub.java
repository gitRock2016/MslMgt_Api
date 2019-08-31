package com.muscle.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MslMgtControllerStub {
	
	@RequestMapping(value = "/mslmgt", method = RequestMethod.GET)
	public String stub() {
		return "mslmgt";
	}


}

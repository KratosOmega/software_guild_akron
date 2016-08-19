package com.swcguild.simplebank.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/helloworld")
public class HelloController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String hello(Map<String, Object> model) {
		model.put("message", "Hello from Controller!");
		return "hello";
	}

}

package com.cdac.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HelloController {

	@RequestMapping("/hello.mj")
	public String sayHello(Map model) {
		model.put("message", "Hello Everyone, Welcome to Spring MVC");
		return "hello.jsp"; //view
	}
	
	@RequestMapping("/hi.mj")
	public String sayHi(Map map) {
		map.put("message", "Hi All, Welcome to Spring MVC");
		return "hello.jsp";
	}
}

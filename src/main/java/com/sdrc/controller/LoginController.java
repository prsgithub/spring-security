package com.sdrc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api")
public class LoginController {

	@RequestMapping(value="/test")
	@ResponseBody
	public String tesst(){
		return "success";
	}
	
	
}

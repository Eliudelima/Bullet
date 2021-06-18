package com.bullet.bullet.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class IndexController {
	
	@RequestMapping(value="/bullet")
	public String index() {
		return "index";
	}
}

package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EcomUserBean;
import com.dao.EUserDao;

@Controller
public class EcomController {
	
	@Autowired
	EUserDao userdao;
	
	@GetMapping("/esignup")
	public String signup()
	{
		return "EcomSignup";
	}
	
	@PostMapping("/elogin")
	public String login(EcomUserBean euserbean)
	{
		
		userdao.insertUser(euserbean);
		
		return "EcomLogin";
	}
}

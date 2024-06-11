package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
	
	@PostMapping("/addstudent")
	public String saveStudent(){
		
		System.out.println("addstudent call...........");
		return "Home.jsp";
	}
}

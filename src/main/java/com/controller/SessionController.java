package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bean.UserBean;


@Controller
public class SessionController {

	@GetMapping("/login")
	public String login()
	{
		return "Login.jsp";
	}
	
	@GetMapping("/signup")
	public String signup()
	{
		return "Signup.jsp";
	}
	
	@GetMapping("/fp")
	public String forgetpassword()
	{
		return "ForgetPassword.jsp";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(UserBean userBean,Model model) {
		
		System.out.println("FirstName: "+userBean.getFname());
		System.out.println("Email: "+userBean.getEmail());
		System.out.println("Password: "+userBean.getPass());
		
		model.addAttribute("user",userBean);
		
		return "Home.jsp";
	}
	
}

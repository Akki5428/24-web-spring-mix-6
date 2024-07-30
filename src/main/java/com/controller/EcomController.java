package com.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EcomUserBean;
import com.bean.UserBean;
import com.dao.EUserDao;
import com.service.FileUploadService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EcomController {
	
	@Autowired
	EUserDao userdao;
	
	@Autowired
	FileUploadService fus;
	
	@GetMapping(value = {"/","/elogin"})
	public String firstpage()
	{
		return "EcomLogin";
	}
	
	@GetMapping("/esignup")
	public String signup()
	{
		return "EcomSignup";
	}
	
	@PostMapping("/esignup")
	public String login(EcomUserBean euserbean)
	{
		
		
		fus.uploadUserImage(euserbean.getProfilepic(),euserbean.getEmail());
		
		euserbean.setMasterpath("images\\profilepic\\"+euserbean.getEmail()+"\\"+euserbean.getProfilepic().getOriginalFilename());
		userdao.insertUser(euserbean);
		
		return "EcomLogin";
	}
	

	// authentication
	@PostMapping("/elogin")
	public String eLogin(EcomUserBean userBean, Model model, HttpSession session) {
		System.out.println("32 => " + userBean.getEmail());
		System.out.println("33 => " + userBean.getPassword());

		EcomUserBean dbUser = userdao.authenticate(userBean.getEmail(), userBean.getPassword());
		if (dbUser == null) {
			model.addAttribute("error", "Invalid Credentials");
			return "EcomLogin";
		} else {

			session.setAttribute("user", dbUser);
			model.addAttribute("firstName", dbUser.getFirstName());
			model.addAttribute("masterpath", dbUser.getMasterpath());	
			return "EcomHome";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//destroy session 
		session.invalidate();
		return "redirect:/elogin";
	}
}

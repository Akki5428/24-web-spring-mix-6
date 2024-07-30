package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.EmailService;

@Controller
public class PaymentController {
	
	@Autowired
	EmailService eservice;
	
	@GetMapping("/checkout")
	public String checkout() {
		return "Checkout";
	}
	
	@GetMapping("inputemail")
	public String inputEmail()
	{
		return "InputEmail";
	}
	
	@PostMapping("sendemail")
	public String sendemail(@RequestParam("email") String email) {
		eservice.sendDemoMail(email,"Welcome to Our Ecom Webpage");
		return "SendEmail";
	}
	
}

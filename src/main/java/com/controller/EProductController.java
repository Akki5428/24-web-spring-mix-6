package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.ProductBean;
import com.dao.EProductDao;

@Controller
public class EProductController {
	
	@Autowired
	EProductDao pdao;
	
	@GetMapping("/psignup")
	public String psignup() {
		return "NewProduct";
	}
	
	@PostMapping("/plogin")
	public String plogin(ProductBean pbean)
	{
		pdao.addProduct(pbean);
		
		return "Home";
	}
	
	
	
}

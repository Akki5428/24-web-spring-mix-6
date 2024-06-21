package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "redirect:/listproduct";
	}
	
	@GetMapping("/listproduct")
	public String listproduct(Model model)
	{
		List<ProductBean> list = pdao.getAllProducts();
		model.addAttribute("list",list);
		
		return "EcomListProduct"; 
	}
	
	@GetMapping("/deleteproduct")
	public String deleteproduct(@RequestParam("productId") Integer productId)
	{
		System.out.println("productID = "+productId);
		
		return "redirect:/listproduct";
	}
	
}

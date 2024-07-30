package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.ProductBean;
import com.dao.EProductDao;
import com.service.FileUploadService;

import ch.qos.logback.core.util.FileUtil;

@Controller
public class EProductController {
	
	@Autowired
	EProductDao pdao;
	
	@Autowired
	FileUploadService fus;
	
	@GetMapping("/psignup")
	public String psignup() {
		return "NewProduct";
	}
	
	@PostMapping("/plogin")
	public String plogin(ProductBean pbean,@RequestParam("masterImage") MultipartFile masterIamge)
	{
		
		fus.uploadImage(masterIamge);
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
		pdao.deleteProduct(productId);
		return "redirect:/listproduct";
	}
	
	@GetMapping("/productname")
	public String productname()
	{
		return "ProductName";
	}
	
	@PostMapping("/deleteproductbyname")
	public String deleteproductbyname(@RequestParam() String productName,Model model)
	{
		int flag=0;
		
		List<ProductBean> list = pdao.getAllProducts();
		for(ProductBean p:list)
		{
			if(p.getProductName().equals(productName))
			{
				flag=1;
				break;
			}
		}
		
		if(flag==1)
		{
			pdao.deleteProduct(productName);
			return "redirect:/listproduct";
		}
		else
		{
			model.addAttribute("errorName","Please Enter Product Name That Present in List" );
			return "ProductName";
		}
	}
	
	@GetMapping("/getproductbyid")
	public String getproductbyid(@RequestParam() Integer productId,Model model)
	{
		ProductBean pbean = pdao.getProductById(productId); 
		model.addAttribute("pbean", pbean);
		return "FullDetail";
	}
	
	
}

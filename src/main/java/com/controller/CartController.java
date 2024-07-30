package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.ECartBean;
import com.bean.EcomUserBean;
import com.bean.ProductBean;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	ECartDao cartdao;
	
	@GetMapping("/addtocart")
	public String addtocart(@RequestParam("productId") Integer productId,HttpSession session )
	{
		
		EcomUserBean userbean = (EcomUserBean)session.getAttribute("user");
		
		Integer userId = userbean.getUserId();
		
		ECartBean cartbean = new ECartBean();
		
		cartbean.setUserId(userId);
		cartbean.setProductId(productId);
		
		cartdao.addToCart(productId, userId);
		
		return "redirect:/listproduct";
	}
	
	@GetMapping("/mycart")
	public String mycart(HttpSession session,Model model)
	{
		EcomUserBean user =  (EcomUserBean) session.getAttribute("user");
		Integer userId = user.getUserId();
		List<ProductBean> products = cartdao.myCart(userId);
		model.addAttribute("products", products);
		return "MyCart";
		
	}
	
	@GetMapping("/removecartitem")
	public String removecartitem(@RequestParam("cartId") Integer cartId,@RequestParam("qty") Integer cqty)
	{
		cartdao.removecartitem(cartId,cqty);
		return "redirect:/mycart";
	}
}

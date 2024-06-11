package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.BoxPlayerBean;
import com.util.Validators;

@Controller
public class BoxCricketController {
	
	@GetMapping("/boxreges")
	public String boxreg()
	{
		return "Boxcricketreg";
	}
	
	@PostMapping("/playerdetail")
	public String boxdetail(BoxPlayerBean pBean,Model model)
	{
		String pname = pBean.getPname();
		String ptype = pBean.getPtype();
		String ftype = pBean.getFtype();
		String drink = pBean.getDrink();
		boolean isError = false;
		
		if(Validators.checkNull(pname))
		{
			isError = true;
			model.addAttribute("pnameError","Please Enter Player Name");
		}
		else if(Validators.isAlpha(pname) == false)
		{
			isError = true;
			model.addAttribute("pnameError","Please Enter valid Player Name");
		}
		else{
			model.addAttribute("pnameValue",pname);
		}
		
		if(ptype == null)
		{
			isError = true;
			model.addAttribute("ptypeError","Please Enter Player Type");
		}
		else
		{
			switch(ptype)
			{
				case "Batsman" : model.addAttribute("ptypeValue",ptype);
								 break;
				case "Bowler" : model.addAttribute("ptypeValue",ptype);
								break;
				case "All Rounder" : model.addAttribute("ptypeValue",ptype);
								break;
								
				default:break;
			}
		}
		
		if(ftype.equals("-1"))
		{
			isError = true;
			model.addAttribute("ftypeError","Please Enter Food Preference");
		}
		else
		{
			switch(ftype)
			{
				case "Regular" : model.addAttribute("ftypeValue",ftype);
								 break;
				case "Jain" : model.addAttribute("ftypeValue",ftype);
								break;
								
				default:break;
			}
		}
		
		if(drink == null)
		{
			isError = true;
			model.addAttribute("drinkError","Please Enter atleast one Drink");
		}
		else
		{
			model.addAttribute("drinkValue",drink);
		}
		
		if(isError)
		{
			return "Boxcricketreg";
		}
		else
		{
			System.out.println("Helloo");
			return "Boxplayerdetail";
		}
	}
}

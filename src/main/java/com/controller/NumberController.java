package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.NumBean;

@Controller
public class NumberController {

	@GetMapping("/takenum")
	public String enterNumber()
	{
		return "Takenumber.jsp";
	}
	
	@PostMapping("/sumnum")
	public String sumOfNumber(NumBean numBean,Model model)
	{
		int n1,n2,sum;
		n1=numBean.getN1();
		n2=numBean.getN2();
		sum=n1+n2;
		System.out.println("n1 :"+n1);
		System.out.println("n2 :"+n2);
		System.out.println("sum :"+sum);
		
		model.addAttribute("n1",n1);
		model.addAttribute("n2",n2);
		model.addAttribute("sum",sum);
		return "Sumofnumber.jsp";
	}
	
	
}

package com.myweather.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myweather.domain.User;
import com.myweather.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/register" ,method=RequestMethod.GET)
	public String registerPage(Model model){
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value ="/processRegistration" ,method=RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ){
		
		
	    if (!result.hasErrors()) {
	        userService.registerNewUserAccount(user);
	    }
	 
		if (result.hasErrors()) {
			return "register";
		}	
			return "redirect:/location";
	}
	
//	@RequestMapping(value ="/login" ,method=RequestMethod.GET)
//	public String loginPage(Model model){
//		model.addAttribute("userCredential", new UserCredential());
//		return "login";
//	}
//	
//	@RequestMapping(value ="/login" ,method=RequestMethod.POST)
//	public String loginSuccess(@Valid @ModelAttribute("userCredential") UserCredential userCredential,BindingResult result, Model model){
//
//		return "redirect:/location";
//	}
	
}

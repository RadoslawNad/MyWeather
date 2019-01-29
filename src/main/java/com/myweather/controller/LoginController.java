package com.myweather.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myweather.model.User;
import com.myweather.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "registration-form";
	}

	@RequestMapping(value = "/processRegistrationForm", method = RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

		System.out.println("Binding"+ result);
		
		if (result.hasErrors()) {
			return "registration-form";
		}
		
		boolean userExists =userService.saveUser(user);
		
		if(userExists!=true) {
			model.addAttribute("userExists", true);
			return "registration-form";
		}
		
		return "registration-confirmation";
	}
}

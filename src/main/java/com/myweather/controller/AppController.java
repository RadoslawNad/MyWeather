package com.myweather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myweather.model.User;
import com.myweather.model.WeatherObject;
import com.myweather.service.ApiService;
import com.myweather.service.UserService;

@Controller
public class AppController {

	@Autowired
	private ApiService apiService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String getLocationForm(Model model) {

		apiService.populateList();
		model.addAttribute("cities", apiService.getLocationsName());
		model.addAttribute("locationToShow", new WeatherObject());
		return "selectLocation";
	}

	@RequestMapping(value = "/weather", method = RequestMethod.POST)
	public String processLocationForm(@ModelAttribute WeatherObject weatherObject, Model model, BindingResult result) {

		if (result.hasErrors()) {
			return "selectLocation";
		}

		String[] suppressedField = result.getSuppressedFields();
		if (suppressedField.length > 0) {
			throw new RuntimeException("The attempt to bind non-permitted fields"
					+ StringUtils.arrayToCommaDelimitedString(suppressedField));
		}

		WeatherObject weatherData = apiService.getLocationByName(weatherObject.getStationName());
		userService.saveHistory(getLoggedInUsername(), weatherData);
		model.addAttribute("objectToDisplay", weatherData);
		return "displayWeather";
	}

	@RequestMapping("/history")
	public String displayAllHistory(Model model) {
		List<User> users = userService.getAllHistory();
		model.addAttribute("users", users);
		return "history";
	}

	@RequestMapping("/userhistory")
	public String displayYourHistory(Model model) {
		List<User> users = userService.getUserHistory(getLoggedInUsername());
		model.addAttribute("users", users);
		return "history";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("stationName");
	}

	private String getLoggedInUsername() {
		Authentication theAuth = SecurityContextHolder.getContext().getAuthentication();

		boolean isLoggedIn = (theAuth != null) && !("anonymousUser").equals(theAuth.getName());

		if (isLoggedIn) {
			return theAuth.getName();
		}
		return "guest";
	}

}

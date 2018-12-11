package com.myweather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myweather.domain.WeatherObject;
import com.myweather.service.ApiService;
import com.myweather.service.HistoryService;

@Controller
public class AppController {

	@Autowired
	private ApiService apiService;
	@Autowired
	private HistoryService historyService;

	
	@RequestMapping()
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
	public String processLocationForm(
			@ModelAttribute WeatherObject weatherObject, Model model,
			BindingResult result) {

		if (result.hasErrors()) {
			return "selectLocation";
		}
		String[] suppressedField = result.getSuppressedFields();
		if (suppressedField.length > 0) {
			throw new RuntimeException(
					"The attempt to bind non-permitted fields"
							+ StringUtils
									.arrayToCommaDelimitedString(suppressedField));
		}
		WeatherObject objectToDisplay = apiService
				.getLocationByName(weatherObject.getStationName());
		historyService.saveHistory(objectToDisplay);
		model.addAttribute("objectToDisplay", objectToDisplay);
		return "displayWeather";
	}

	@RequestMapping("/history")
	public String displayHistory(Model model) {
		List<WeatherObject> history = historyService.getHistory();
		model.addAttribute("allHistory", history);
		return "history";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("stationName");
	}

}

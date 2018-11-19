package com.myweather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myweather.domain.WeatherObject;
import com.myweather.service.ApiService;
import com.myweather.service.DisplayObjectService;
import com.myweather.service.HistoryService;

@Controller
public class AppController {

	@Autowired
	private ApiService apiService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private DisplayObjectService displayObjectService;

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

	@RequestMapping(value = "/location", method = RequestMethod.POST)
	public String processLocationForm(
			@ModelAttribute("locationToShow") WeatherObject weatherObject) {

		displayObjectService.setObject(weatherObject);
		return "redirect:/display";
	}

	@RequestMapping("/display")
	public String displayWeather(Model model) {

		historyService.saveHistory(displayObjectService.getObject());
		model.addAttribute("objectToDisplay", displayObjectService.getObject());
		return "displayWeather";
	}

	@RequestMapping("/history")
	public String displayHistory(Model model) throws Exception {
		List<WeatherObject> history = historyService.getHistory();
		model.addAttribute("allHistory", history);
		return "history";
	}

}

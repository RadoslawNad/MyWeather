package com.myweather.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class GlobalControllerExceptionHandler {
	
	private static final Logger logger = LogManager.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(value = SessionFactoryError.class)
	public String handleSessionFactoryException(SessionFactoryError e,Model model) {
		logger.error("handleException(). Exception ocurred. Message: "+ e);
		String message="Can not get a connection to the database.";
		model.addAttribute("message", message);
		return "exception";
	}
}

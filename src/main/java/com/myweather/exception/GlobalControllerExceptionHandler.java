package com.myweather.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class GlobalControllerExceptionHandler {
	private static Logger logger = LogManager.getRootLogger();


	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		logger.error("GlobalControllerExceptionHandler/handleException(). Exception ocurred "+ e);
		return "error";
	}

}

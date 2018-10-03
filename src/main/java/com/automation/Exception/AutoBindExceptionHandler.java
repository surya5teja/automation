/**
 *
 */
package com.automation.Exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author surteja
 *
 */
@ControllerAdvice
public class AutoBindExceptionHandler {

	@ExceptionHandler(AutoBindException.class)
	@ResponseStatus(HttpStatus.PARTIAL_CONTENT)
	@ResponseBody
	public List<ObjectError> handleException(AutoBindException exp) {
		return exp.getAllErrors();
	}

}

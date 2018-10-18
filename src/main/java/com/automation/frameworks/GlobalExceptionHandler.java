/**
 *
 */
package com.automation.frameworks;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author surteja
 *
 */
public class GlobalExceptionHandler {

	@Resource
	Environment environment;

	/**
	 * Intercepts global exception
	 *
	 * @param exp
	 * @return TdpResponseWsDTO<Object>
	 */
	@ExceptionHandler(GlobalException.class)
	@ResponseStatus(HttpStatus.PARTIAL_CONTENT)
	@ResponseBody
	public GlobalResponseDTO<Object> handleException(GlobalException exp) {
		StackTraceElement[] traceElements = exp.getGlobalStackTrace();
		if (null != traceElements && traceElements.length > 0) {
			StackTraceElement traceElement = traceElements[0];
			if (null != traceElement) {
				System.out.println(traceElement.getMethodName());
			}
		}

		GlobalResponseDTO<Object> responseDTO = new GlobalResponseDTO<Object>();
		if (CollectionUtils.isNotEmpty(exp.getErrors())) {
			responseDTO.setErrors(exp.getErrors());
		} else {
			GlobalErrorModel error = new GlobalErrorModel();
			error.setMessage(StringUtils.isNotEmpty(exp.getMessage()) ? exp.getMessage()
					: environment.getProperty(exp.getCode()));
			error.setType(exp.getType());
			error.setCode(exp.getCode());
			List<GlobalErrorModel> errors = new ArrayList<GlobalErrorModel>();
			errors.add(error);
			responseDTO.setErrors(errors);
		}

		return responseDTO;
	}

	/**
	 * Intercepts any exception that is not covered by tdp and bind exception
	 *
	 * @param exp
	 * @return List<TdpErrorWsDTO>
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public GlobalResponseDTO<Object> handleException(Exception exp) {
		GlobalResponseDTO<Object> responseDTO = new GlobalResponseDTO<Object>();
		List<GlobalErrorModel> errors = new ArrayList<GlobalErrorModel>();
		GlobalErrorModel error = new GlobalErrorModel();
		error.setCause(exp.getCause().toString());
		error.setMessage(exp.getMessage());
		errors.add(error);
		responseDTO.setErrors(errors);
		return responseDTO;
	}
}

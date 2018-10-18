/**
 *
 */
package com.automation.frameworks;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author surteja
 *
 */
@ControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		// TODO Auto-generated method stub
		GlobalResponseBody tdpResponseBody = methodParameter.getMethodAnnotation(GlobalResponseBody.class);
		return generateResponseBody(tdpResponseBody.success(), tdpResponseBody.methodName(), object);
	}

	private GlobalResponseDTO<Object> generateResponseBody(Boolean flag, String methodName, Object object) {

		return new GlobalResponseDTO<Object>(object, null, flag);
	}

}

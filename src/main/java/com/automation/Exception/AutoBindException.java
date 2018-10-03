/**
 *
 */
package com.automation.Exception;

import org.springframework.util.Assert;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

/**
 * @author surteja
 *
 */
public class AutoBindException extends BindException {

	private StackTraceElement[] tpdStackTrace;

	public AutoBindException(BindingResult bindingResult) {
		super(bindingResult);
		this.tpdStackTrace = this.getStackTrace();
		Assert.notNull(bindingResult, "requestHeader must not be null");
	}
}

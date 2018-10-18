/**
 *
 */
package com.automation.frameworks;

import java.util.List;

/**
 * @author surteja
 *
 */
public class GlobalException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	private String message;

	private String type;

	private List<GlobalErrorModel> errors;

	private StackTraceElement[] globalStackTrace;

	public GlobalException() {
		super();
	}

	public GlobalException(final String code) {
		super();
		this.code = code;
		this.globalStackTrace = this.getStackTrace();
	}

	public GlobalException(final Throwable cause) {
		super(cause);
		this.globalStackTrace = this.getStackTrace();
	}

	public GlobalException(final String code, final Throwable cause) {
		super();
		this.code = code;
		this.globalStackTrace = cause != null ? cause.getStackTrace() : this.getStackTrace();
	}

	public GlobalException(final String code, final String type, final Throwable cause) {
		super();
		this.code = code;
		this.type = type;
		this.globalStackTrace = cause != null ? cause.getStackTrace() : this.getStackTrace();
	}

	public GlobalException(final String code, final String message, final String type) {
		super();
		this.code = code;
		this.message = message;
		this.type = type;
		this.globalStackTrace = this.getStackTrace();
	}

	public GlobalException(final String code, final String message, final String type, final Throwable cause) {
		super();
		this.code = code;
		this.message = message;
		this.type = type;
		this.globalStackTrace = cause != null ? cause.getStackTrace() : this.getStackTrace();
	}

	public GlobalException(final List<GlobalErrorModel> errors) {
		super();
		this.errors = errors;
		this.globalStackTrace = this.getStackTrace();
	}

	public GlobalException(final List<GlobalErrorModel> errors, final Throwable cause) {
		super();
		this.errors = errors;
		this.globalStackTrace = cause != null ? cause.getStackTrace() : this.getStackTrace();
	}

	/**
	 * get tdp stackTrace.
	 *
	 * @return tdp stackTrace.
	 */
	public StackTraceElement[] getGlobalStackTrace() {
		return globalStackTrace;
	}

	/**
	 * set stackTrace
	 *
	 * @param globalStackTrace
	 */
	public void setGlobalStackTrace(StackTraceElement[] globalStackTrace) {
		this.globalStackTrace = globalStackTrace;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<GlobalErrorModel> getErrors() {
		return errors;
	}

	public void setErrors(List<GlobalErrorModel> errors) {
		this.errors = errors;
	}
}

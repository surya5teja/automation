/**
 *
 */
package com.automation.frameworks;

/**
 * @author surteja
 *
 */
public class GlobalErrorModel {

	private String code;

	private String cause;

	private String message;

	private String type;

	public GlobalErrorModel(String code, String cause, String message, String type) {
		this.code = code;
		this.cause = cause;
		this.message = message;
		this.type = type;
	}

	public GlobalErrorModel() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

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

}

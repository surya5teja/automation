/**
 *
 */
package com.automation.frameworks;

import java.util.ArrayList;
import java.util.List;

/**
 * @author surteja
 *
 */
public class GlobalResponseDTO<T> {

	private boolean success;
	private T data;
	private List<GlobalErrorModel> errors;

	public GlobalResponseDTO() {

	}

	public GlobalResponseDTO(T data, List<GlobalErrorModel> errors, Boolean success) {
		this.data = data;
		this.errors = errors;
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GlobalErrorModel> getErrors() {
		if (errors == null) {
			return new ArrayList<GlobalErrorModel>();
		}
		return errors;
	}

	public void setErrors(List<GlobalErrorModel> errors) {
		this.errors = errors;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}

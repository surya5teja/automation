/**
 *
 */
package com.automation.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.automation.model.Patient;

/**
 * @author surteja
 *
 */
@Component
public class PatientReqValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PatientReqValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Patient patientReq = (Patient) target;
		if (StringUtils.isBlank(patientReq.getBrandProgram())) {
			errors.reject("Brand program should not be empty");
		}
		if (StringUtils.isBlank(patientReq.getIndication())) {
			errors.reject("Indication should not be empty");
		}
		if (patientReq.getPatientCount() <= 0) {
			errors.reject("patient count should be greater than zero");
		}
	}

}

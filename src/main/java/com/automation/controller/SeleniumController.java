/**
 *
 */
package com.automation.controller;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.automation.Exception.AutoBindException;
import com.automation.model.Patient;
import com.automation.selenium.PatientsAutomation;
import com.automation.validator.PatientReqValidator;

/**
 * @author surteja
 *
 */
@RestController
@RequestMapping(value = "/selenium")
public class SeleniumController {

	@Autowired
	PatientReqValidator patReqValidator;

	@RequestMapping(value = "/automation", method = RequestMethod.POST)
	public void createPatients(@RequestBody Patient patient) throws IOException, AutoBindException {
		validatePatientReq(patient, patReqValidator);
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		PatientsAutomation sa = new PatientsAutomation(new ChromeDriver());
		System.out.println(System.getenv("sfUsrname") + "::" + System.getenv("JAVA_HOME"));
		sa.login(patient);
	}

	private void validatePatientReq(final Object object, final Validator validator) throws AutoBindException {
		MapBindingResult bindingResult = new MapBindingResult(new HashMap<String, String>(), "");
		validator.validate(object, bindingResult);
		if (bindingResult.hasErrors()) {
			throw new AutoBindException(bindingResult);
		}
	}
}

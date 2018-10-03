/**
 *
 */
package com.automation.model;

/**
 * @author surteja
 *
 */
public class Patient {

	private String lastName;
	private String firstName;
	private String dob;
	private String gender;
	private String patientStatus;
	private String affiliate;
	private String phoneNumber;
	private String phoneNumberType;
	private String email;
	private String lillyplusVersion;
	private Program program;
	private int patientCount;
	private String brandProgram;
	private String indication;

	public String getBrandProgram() {
		return brandProgram;
	}

	public void setBrandProgram(String brandProgram) {
		this.brandProgram = brandProgram;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public int getPatientCount() {
		return patientCount;
	}

	public void setPatientCount(int patientCount) {
		this.patientCount = patientCount;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

	public String getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(String affiliate) {
		this.affiliate = affiliate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumberType() {
		return phoneNumberType;
	}

	public void setPhoneNumberType(String phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLillyplusVersion() {
		return lillyplusVersion;
	}

	public void setLillyplusVersion(String lillyplusVersion) {
		this.lillyplusVersion = lillyplusVersion;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

}

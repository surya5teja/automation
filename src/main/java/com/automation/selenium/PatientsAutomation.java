/**
 *
 */
package com.automation.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.model.Patient;

/**
 * @author surteja
 *
 */
public class PatientsAutomation {

	private final WebDriver driver;

	public PatientsAutomation(WebDriver driver) {
		this.driver = driver;
	}

	public void login(Patient patient) throws IOException {
		driver.get("https://test.salesforce.com");
		driver.findElement(By.name("username")).sendKeys("");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("");
		driver.findElement(By.cssSelector("input[id='Login']")).click();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlContains("salesforce.com/"));
		String currUrl = driver.getCurrentUrl();
		String currUrlAfterModified = currUrl.substring(0, currUrl.indexOf("salesforce.com"));
		System.out.println(currUrlAfterModified);
		String finalUrl = currUrlAfterModified + "salesforce.com";
		System.out.println(finalUrl);
		driver.findElement(By.cssSelector("a[title='Patients Tab']")).click();
		createPatients(finalUrl, wait, patient);
	}

	public void createPatients(String finalUrl, WebDriverWait wait, Patient patient) {
		for (int i = 1; i <= patient.getPatientCount(); i++) {
			driver.findElement(By.cssSelector("input[name='new']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("00N60000002zkh4")).sendKeys(patient.getLastName()); // last
																							// name
			driver.findElement(By.id("00N60000002zkgz")).sendKeys(String.valueOf(i) + patient.getFirstName()); // first
			// name
			driver.findElement(By.id("00N60000002zkgy")).sendKeys(patient.getDob()); // dob
			driver.findElement(By.id("00N60000002zkh1")).sendKeys(patient.getGender()); // gender
			driver.findElement(By.id("00N60000002zkhC")).sendKeys(patient.getPatientStatus()); // patient
			// status
			driver.findElement(By.id("00N60000002zkgm")).sendKeys(patient.getAffiliate()); // affiliate
			driver.findElement(By.id("00N60000002zkhY")).sendKeys(patient.getPhoneNumber()); // phonenumber
			driver.findElement(By.id("00N60000002zkhS")).sendKeys(patient.getPhoneNumberType()); // phonenumber
			// type
			driver.findElement(By.id("00N60000002zkhA"))
					.sendKeys(patient.getEmail() + String.valueOf(i) + "@gmail.com"); // email
			driver.findElement(By.id("00Nf20000031Hxi")).sendKeys(patient.getLillyplusVersion()); // lillyplus
			driver.findElement(By.name("save")).click();
			createPrograms(finalUrl, wait, patient);
			driver.get(finalUrl + "/a1B/o");
		}
	}

	public void createPrograms(String finalUrl, WebDriverWait wait, Patient patient) {
		System.out.println(driver.getCurrentUrl().replaceAll(finalUrl, ""));
		String id = driver.getCurrentUrl().replaceAll(finalUrl, "");
		String idWithoutBackslash = id.replace("/", "");
		if (patient.getBrandProgram().equalsIgnoreCase("olu") || patient.getBrandProgram().equalsIgnoreCase("mixed")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("new00N60000002zklU")));
			driver.findElement(By.cssSelector("input[value='New Program']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("00N60000002zkij")));
			driver.findElement(By.id("00N60000002zkij")).sendKeys("US"); // affiliate
			driver.findElement(By.id("00N60000002zkis")).sendKeys("Olumiant US"); // brand
			// program
			// status
			driver.findElement(By.id("00N60000002zkjn")).sendKeys("Enrolled"); // DTPC_status
			driver.findElement(By.id("CF00N60000002zkin")).sendKeys("Olumiant Claudia US LillyPlus"); // assigned
			// claudia
			driver.findElement(By.id("CF00N60000002zkmR")).sendKeys("Olumiant_US_Test_ RS"); // reimbursement
			// specialist
			driver.findElement(By.id("CF00N60000002zkjA")).sendKeys("Rheumatoid Arthritis"); // dtpc
			// indication
			driver.findElement(By.name("save")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href=" + '"' + id + '"' + "]")));
			driver.findElement(By.cssSelector("a[href=" + '"' + id + '"' + "]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(finalUrl + "/apex/DTPC_PatientProvisionAccessPage?id=" + idWithoutBackslash);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(finalUrl + "/apex/DTPC_VC_CreatePatientProfile?id=" + idWithoutBackslash);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		if (patient.getBrandProgram().equalsIgnoreCase("ixe") || patient.getBrandProgram().equalsIgnoreCase("mixed")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("new00N60000002zklU")));
			driver.findElement(By.cssSelector("input[value='New Program']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("00N60000002zkij")));
			driver.findElement(By.id("00N60000002zkij")).sendKeys("US"); // affiliate
			driver.findElement(By.id("00N60000002zkis")).sendKeys("Ixekizumab US"); // brand
			// program
			// status
			driver.findElement(By.id("00N60000002zkjn")).sendKeys("Enrolled"); // DTPC_status
			driver.findElement(By.id("CF00N60000002zkin")).sendKeys("Ixe Claudia US LillyPlus"); // assigned
			// claudia
			driver.findElement(By.id("CF00N60000002zkmR")).sendKeys("IXE_US_Test_ RS"); // reimbursement
			// specialist
			if (patient.getIndication().equalsIgnoreCase("PSO")) {
				driver.findElement(By.id("CF00N60000002zkjA")).sendKeys("Psoriasis"); // dtpc
				// indication
			} else if (patient.getIndication().equalsIgnoreCase("PSA")) {
				driver.findElement(By.id("CF00N60000002zkjA")).sendKeys("Psoriatic Arthritis"); // dtpc
				// indication
			} else {
				driver.findElement(By.id("CF00N60000002zkjA")).sendKeys("Psoriasis and Psoriatic Arthritis"); // dtpc
				// indication
			}
			driver.findElement(By.name("save")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href=" + '"' + id + '"' + "]")));
			driver.findElement(By.cssSelector("a[href=" + '"' + id + '"' + "]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(finalUrl + "/apex/DTPC_PatientProvisionAccessPage?id=" + idWithoutBackslash);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(finalUrl + "/apex/DTPC_VC_CreatePatientProfile?id=" + idWithoutBackslash);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\surteja\\Downloads\\chromedriver.exe");
		PatientsAutomation sa = new PatientsAutomation(new ChromeDriver());
		Patient p = new Patient();
		p.setPatientCount(1);
		sa.login(p);
	}
}

package com.automation.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesforceAuto {

	Properties prop = new Properties();
	InputStream input = null;
	private final WebDriver driver;

	public SalesforceAuto(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String username, String password) throws IOException {

		driver.get("https://test.salesforce.com");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[id='Login']")).click();
		// clickAlerts(createIdSet());
	}

	public Set<String> createIdSet() throws IOException {
		Set<String> idSet = new HashSet<String>();
		input = new FileInputStream(
				"C:\\Users\\surteja\\eclipse-workspace-j2ee\\automation\\src\\main\\resources\\automation.properties");
		prop.load(input);
		String ids = prop.getProperty("id");
		String idsArr[] = ids.split(",");
		for (String id : idsArr) {
			idSet.add(id);
		}
		return idSet;
	}

	public void clickAlerts(Set<String> idSet) {
		for (String id : idSet) {
			System.out.println(id);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.urlContains("salesforce.com/"));
			String currUrl = driver.getCurrentUrl();
			String currUrlAfterModified = currUrl.substring(0, currUrl.indexOf("salesforce.com"));
			System.out.println(currUrlAfterModified);
			String finalUrl = currUrlAfterModified + "salesforce.com";
			System.out.println(finalUrl);
			driver.get(finalUrl + "/" + id);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(finalUrl + "/apex/DTPC_PatientProvisionAccessPage?id=" + id);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert conf = driver.switchTo().alert();
			String alertText = conf.getText();
			System.out.println(alertText);
			driver.switchTo().alert().accept();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(finalUrl + "/apex/DTPC_VC_CreatePatientProfile?id=" + id);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert secAlert = driver.switchTo().alert();
			String secAlertText = secAlert.getText();
			System.out.println(secAlertText);
			driver.switchTo().alert().accept();
		}

	}

	public static void main(String[] args) throws IOException {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\surteja\\Downloads\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		SalesforceAuto sa = new SalesforceAuto(new ChromeDriver());
		// sa.login("kalmanoor_yashodarshan@gso3.lly.deldev1", "yash>>1996");
		sa.login("kalmanoor_yashodarshan@gso3.lilly.delmdi", "yash>>@1996");
	}
}

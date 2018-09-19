package com.qa.divine.ddt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class OpenReport {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void openReport() {
		driver.get("file:///C:/Users/Admin/eclipse-workspace/DataDrivenTesting/DDT.html");
	}

}

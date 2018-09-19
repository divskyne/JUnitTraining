package com.qa.divine.ddt;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDTReadWrite {

	WebDriver driver;
	ExtentTest test;
	ExtentReports report;

	@Before
	public void setUp() throws Exception {
		ExcelUtils.setExcelFile(Constants.pathTestData + Constants.fileTestData, 0);

		System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		report = new ExtentReports("ExcelUtilsDemoTestReport.html", true);

		for (int i = 1; i < ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows(); i++) {

			test = report.startTest("Excel Data Test: " + i);

			action(i);
			
			report.endTest(test);
		}

		report.flush();
	}
	
	private void action(int i) throws InterruptedException {
		
		Navigation navPage = PageFactory.initElements(driver, Navigation.class);
		Login loginPage = PageFactory.initElements(driver, Login.class);
		
		test.log(LogStatus.INFO, "Opening Browser");

		Thread.sleep(1000);

		driver.get(Constants.websiteURL);

		test.log(LogStatus.INFO, "Navigated to thedemosite.co.uk");

		test.log(LogStatus.INFO, "Set up Excel Utils path - Opened file stream");

		driver.get(Constants.registerURL);
		test.log(LogStatus.INFO, "Clicked on link to addUser page");
		loginPage.setUsername(ExcelUtils.getCellData(i, 0));
		test.log(LogStatus.INFO, "Input Username");
		loginPage.setPassword(ExcelUtils.getCellData(i, 1));
		test.log(LogStatus.INFO, "Input password");
		loginPage.submit().click();
		test.log(LogStatus.INFO, "Created New User");

		driver.get(Constants.loginURL);
		test.log(LogStatus.INFO, "Navigated to login page");
		loginPage.setUsername(ExcelUtils.getCellData(i, 0));
		test.log(LogStatus.INFO, "Input Username");
		loginPage.setPassword(ExcelUtils.getCellData(i, 1));
		test.log(LogStatus.INFO, "Input password");
		loginPage.submit().click();
		test.log(LogStatus.INFO, "Logged In");

		Actions action = new Actions(driver);

		action.moveByOffset(10, 10).perform();
		
		if(loginPage.getLoginMessage().equals(Constants.successMessage))
		{
			assertEquals(Constants.successMessage, loginPage.getLoginMessage());
			test.log(LogStatus.PASS, "Successfully created a user and logged in with it");
			ExcelUtils.setCellData("Pass", i, 2);
		}
		else
		{
			test.log(LogStatus.FAIL, loginPage.getLoginMessage());
			ExcelUtils.setCellData("Fail", i, 2);
		}
	}

}

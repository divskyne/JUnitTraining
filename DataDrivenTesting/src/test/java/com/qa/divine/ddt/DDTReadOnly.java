package com.qa.divine.ddt;

import static org.junit.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDTReadOnly {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String LoginData = "";
	FileInputStream file = null;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		report = new ExtentReports("DDT.html");
	}
	
	private void sleep() throws InterruptedException {
		Thread.sleep(200);
	}
	
	

	@Test
	public void excelTest() throws InterruptedException, IOException {
		file = new FileInputStream("LoginData.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			test = report.startTest("DDT Read and Login Website: "+i);
			actions(i);
			report.endTest(test);
		}
	}
	
	
	private void actions(int i) throws InterruptedException {
		Cell username = sheet.getRow(i).getCell(0);
		Cell password = sheet.getRow(i).getCell(1);

		String user = username.getStringCellValue();
		String pass = password.getStringCellValue();

		driver.get("http://thedemosite.co.uk/");
		Navigation navPage = PageFactory.initElements(driver, Navigation.class);
		Login loginPage = PageFactory.initElements(driver, Login.class);
		navPage.getNewUser().click();
		
		test.log(LogStatus.INFO, "navigating to demosite register page");
		test.log(LogStatus.INFO, "inputting new username: "+user);
		loginPage.setUsername(user);
		test.log(LogStatus.INFO, "inputting new password: "+pass);
		loginPage.setPassword(pass);
		test.log(LogStatus.INFO, "Saving new user");
		loginPage.submit().click();

		test.log(LogStatus.INFO, "navigate to login");
		navPage.getLogin().click();
		test.log(LogStatus.INFO, "Entering username on login screen");
		loginPage.setUsername(user);
		test.log(LogStatus.INFO, "Entering password in login screen");
		loginPage.setPassword(pass);
		loginPage.submit().click();
		if(loginPage.getLoginMessage().equals("**Successful Login**"))
		{
			assertEquals("**Successful Login**", loginPage.getLoginMessage());
			test.log(LogStatus.PASS, "Successfully created a user and logged in with it");
		}
		else
		{
			test.log(LogStatus.FATAL, loginPage.getLoginMessage());
		}
	}

	@After
	public void tearDown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
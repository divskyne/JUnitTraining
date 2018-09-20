package com.qa.div;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TestPassionForTea {
	
	WebDriver driver;
	String url;
	private PassionTea website;
	private String greentea = "Green Tea";
	private String checkoutConfi = "Pay with Credit Card or Log In";
	
	private ExtentReports report;
	ExtentTest test;
	

	@Before
	public void setUp()  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		website = PageFactory.initElements(driver, PassionTea.class);
		
		report = testRunner.report;
	}

	@After
	public void tearDown()  {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
	
	static int cpunter = 0;
	
	@Given("^the correct web address$")
	public void the_correct_web_address()  {
		website.navigate(driver);
		cpunter++;
		test = report.startTest("TestPassionForTea"+cpunter);
		test.log(LogStatus.INFO, "Browser navigated");
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page()  {
		website.getMenu().click();
		test.log(LogStatus.PASS, "I navigate to the 'Menu' page");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products()  {
	    if (website.getGreenTea().getText().equals(greentea)) {
	    	Assert.assertEquals(greentea, website.getGreenTea().getText());
	    	test.log(LogStatus.PASS, "I can browse a list of the available products");
		}
	    else
	    {
	    	test.log(LogStatus.FAIL, "I can't browse a list of the available products");
	    } 
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button()  {

		i_navigate_to_the_Menu_page();
		website.getCheckout().click();
		test.log(LogStatus.PASS, "I click the checkout button");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page()  {
	    if (website.getConfirmCheckout().getText().equals(checkoutConfi)) {
	    	Assert.assertEquals(checkoutConfi, website.getConfirmCheckout().getText());
	    	test.log(LogStatus.PASS, "I am taken to the checkout page");
		}
	    else
	    {
	    	test.log(LogStatus.FAIL, "I am taken to the checkout page");
	    }
	}
}

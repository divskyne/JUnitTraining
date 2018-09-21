package com.qa.assessment;
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

public class TestJenkins {

	WebDriver driver = null;
	static ExtentReports report;
	ExtentTest test;
	String url;
	
	private AdminLogin adminLogin;
	private ManageUsers manageUsers;
	
	@Before
	public void setUp()  {
		System.setProperty(Constants.driverName, Constants.chromeDriverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		adminLogin = PageFactory.initElements(driver, AdminLogin.class);
		manageUsers = PageFactory.initElements(driver, ManageUsers.class);
		report = AllTests.report;
	}

	@After
	public void tearDown()  {
		driver.close();
		report.endTest(test);
		report.flush();
	}
	
	private void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int counter = 0;
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen()  {
		counter++;
		test = report.startTest("Jenkins Management System Test "+counter);
		test.log(LogStatus.INFO, "Accessing: "+Constants.websiteURL);
	    driver.get(Constants.websiteURL);
	    adminLogin.login(Constants.adminUsername,Constants.adminPassword);
	    manageUsers.userPage();
	    test.log(LogStatus.INFO, "Page: "+driver.getCurrentUrl());
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen()  {
		manageUsers.createUser("blaaah", "blaaah", "blaaah", "blaaah", "blaaah@gm.co");
		test.log(LogStatus.INFO,"filling in user details");
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen()  {
		manageUsers.submitNewUser();
		test.log(LogStatus.INFO,"Submitted New User");
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen()  {
		Assert.assertEquals("blaaah", manageUsers.userVisible("blaaah", driver));
		test.log(LogStatus.PASS,"Test user blaaah is visible");
		test.log(LogStatus.INFO, "Screenshots: \n"+test.addScreenCapture(ScreenshotHelper.takeScreenShot(driver)));
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5)  {
		manageUsers.createUser(arg1,arg2,arg3,arg4,arg5);
		test.log(LogStatus.INFO,"filled in user details");
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1)  {
		Assert.assertEquals(arg1, manageUsers.userVisible(arg1, driver));
		test.log(LogStatus.PASS,arg1+" visible on UsersScreen");
		test.log(LogStatus.INFO, "Screenshots: \n"+test.addScreenCapture(ScreenshotHelper.takeScreenShot(driver)));
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1)  {
		counter++;
		test = report.startTest("Jenkins Management System Test "+arg1);
		driver.get(Constants.websiteURL);
	    adminLogin.login(Constants.adminUsername,Constants.adminPassword);
	    manageUsers.manageAllUser();
	    Assert.assertEquals(arg1, manageUsers.userVisible(arg1, driver));
	    test.log(LogStatus.INFO,arg1+" is visible on UsersScreen");
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1)  {
		manageUsers.findUser(arg1, driver);
		test.log(LogStatus.INFO,"redirecting to userpage for: "+arg1);
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1)  {
		Assert.assertEquals(arg1, manageUsers.assertUser(arg1, driver));
		test.log(LogStatus.PASS,"User Profile should displays details for: "+arg1);
		test.log(LogStatus.INFO, "Screenshots: \n"+test.addScreenCapture(ScreenshotHelper.takeScreenShot(driver)));
	}
	static String name;
	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1)  {
		counter++;
		test = report.startTest("Jenkins Management System Test "+arg1);
		driver.get(Constants.websiteURL);
	    adminLogin.login(Constants.adminUsername,Constants.adminPassword);
	    manageUsers.manageAllUser();
		manageUsers.findUser(arg1, driver);
		name = arg1;
		Assert.assertEquals(Constants.userParentLink+"user/"+arg1.toLowerCase()+"/", driver.getCurrentUrl());
		test.log(LogStatus.INFO,"profile page has been loaded for: "+arg1);
	}
	
	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page()  {
		System.out.println(name);
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(Constants.userParentLink+"user/"+name.toLowerCase()+"/",driver.getCurrentUrl());
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1)  {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page()  {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String arg1)  {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
}

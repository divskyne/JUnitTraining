import static org.junit.Assert.assertEquals;

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

public class TestDemoSite {
	
	WebDriver driver = null;
	static ExtentReports report;
	ExtentTest test;
	String url;
	
	private Navigation page;
	private Login login;
	private String successMessage = "**Successful Login**";
	
	@Before
	public void setUp()  {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		page = PageFactory.initElements(driver, Navigation.class);
		login = PageFactory.initElements(driver, Login.class);
		report = testRunner.report;
	}

	@After
	public void tearDown()  {
		driver.close();
		report.endTest(test);
		report.flush();
	}
	
	static int cphunter;
	
	@Given("^I go to website$")
	public void i_go_to_website()  {
		driver.get("http://thedemosite.co.uk/");
		cphunter++;
		test = report.startTest("Demosite login "+cphunter);
		test.log(LogStatus.INFO, "Browser navigated to home");
	}

	@When("^add new user with \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_new_user_with(String user, String pass)  {
		page.getNewUser().click();
		login.setUsername(user);
		login.setPassword(pass);
		login.submit().click();		
		test.log(LogStatus.PASS, "I add a user with name "+user);
	}

	@Then("^I should be able to login as that \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_should_be_able_to_login_as_that_with(String user, String pass)  {
		page.getLogin().click();
		login.setUsername(user);
		login.setPassword(pass);
		login.submit().click();
		if(login.getLoginMessage().equals(successMessage))
		{
			test.log(LogStatus.PASS, "I login as user "+user);
			assertEquals(successMessage , login.getLoginMessage());
		}
		else
		{
			test.log(LogStatus.FAIL, "Login Failed");
		}
	}
}

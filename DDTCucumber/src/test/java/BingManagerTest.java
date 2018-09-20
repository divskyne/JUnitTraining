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

public class BingManagerTest {
	
	WebDriver driver = null;
	static ExtentReports report;
	ExtentTest test;
	String url;
	
	private BingPageManager page;

	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		page = PageFactory.initElements(driver, BingPageManager.class);
		report = testRunner.report;
	}
	
	static int cphunter;
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1)  {
		
	   driver.get(arg1);
	   url = driver.getCurrentUrl();
	   
	    cphunter++;
		test = report.startTest("TestPassionForTea"+cphunter);
		test.log(LogStatus.INFO, "Browser navigated to "+arg1);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1)  {
	    page.searchFor(arg1);
	    test.log(LogStatus.PASS, "I search for "+arg1);
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search()  {
		if (!url.equals(driver.getCurrentUrl())) {
			Assert.assertTrue(!url.equals(driver.getCurrentUrl()));
	    	test.log(LogStatus.PASS, "I am taken to a list of data for that search");
		}
	    else
	    {
	    	test.log(LogStatus.FAIL, "I am taken to a list of data for that search");
	    }
	}

	@After
	public void tearDown()
	{
		driver.close();
		report.endTest(test);
		report.flush();
	}
}

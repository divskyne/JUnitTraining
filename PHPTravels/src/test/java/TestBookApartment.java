import static org.junit.Assert.*;

import javax.naming.directory.SearchResult;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBookApartment {
	
	WebDriver driver = null;
	static ExtentReports report;
	ExtentTest test;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@BeforeClass
	public static void init()
	{
		report = new ExtentReports("report.html",true);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");
		BookApartment page = PageFactory.initElements(driver, BookApartment.class);
		page.bookIt("London", "19/09/2018", "21/09/2018", "3 Adult 0 Child", driver);
		
		SearchResults result = PageFactory.initElements(driver, SearchResults.class);
		WebElement wait = (new WebDriverWait(driver, 8)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div")));
		System.out.println(result.results.size());
		int results = result.results.size();
		assertTrue("Search doesn't work", results > 0);
		
		test = report.startTest("Book Hotel");
		
		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		
		

		if (results>0) {
			// report the test as a pass
			test.log(LogStatus.PASS, "All Worked!");
		} else {
			test.log(LogStatus.FAIL, "Verify results are > 0");
		}

		report.endTest(test);
		report.flush();
	}
}

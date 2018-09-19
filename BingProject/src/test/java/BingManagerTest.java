import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BingManagerTest {
	
	WebDriver driver = null;
	static ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public static void init()
	{
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\file.html",true);
	}

	@Before
	public void setup() throws Exception
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void bingSearchBox() {
		driver.manage().window().maximize();
		driver.get("https://bing.com");
		BingPageManager page = PageFactory.initElements(driver, BingPageManager.class);
		page.searchFor("birds");
		WebElement searchBox = driver.findElement(By.id("sb_form_q"));
		assertEquals("birds", searchBox.getAttribute("value"));
		
		test = report.startTest("bingSearchBox");
		
		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		
		String title = driver.getTitle();
		
		test.log(LogStatus.ERROR, LogStatus.ERROR.toString());
		test.log(LogStatus.FAIL, LogStatus.FAIL.toString());
		test.log(LogStatus.FATAL, LogStatus.FATAL.toString());
		test.log(LogStatus.INFO, LogStatus.INFO.toString());
		test.log(LogStatus.PASS, LogStatus.PASS.toString());
		test.log(LogStatus.SKIP, LogStatus.SKIP.toString());
		test.log(LogStatus.UNKNOWN, LogStatus.UNKNOWN.toString());
		test.log(LogStatus.WARNING, LogStatus.WARNING.toString());
		


		if (title.contains("Bing")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "verify Title of the page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
		}

		report.endTest(test);
		report.flush();
	}
	@Test
	@Ignore
	public void bingSearchTitle() {
		driver.get("https://bing.com");
		BingPageManager page = PageFactory.initElements(driver, BingPageManager.class);
		page.searchFor("birds");
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li/div/div[2]/h2"));
		assertEquals("Bird", checkElement.getText());
	}
	@After
	public void tearDown()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}

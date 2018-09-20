@RunWith(Suite.class)
@SuiteClasses({ DDTReadOnly.class, OpenReport.class })
public class AllTests {

}

@RunWith(Cucumber.class)
@CucumberOptions(features = "TeaTesting.feature")
public class testRunner
{	
	static ExtentReports report = new ExtentReports("report.html",true);	
}
	<dependencies>
  	<dependency>
  		<groupId>junit</groupId>
  		<artifactId>junit</artifactId>
  		<version>4.12</version>
  	</dependency>
  	<dependency>
  		<groupId>org.seleniumhq.selenium</groupId>
  		<artifactId>selenium-java</artifactId>
  		<version>3.14.0</version>
  	</dependency>
  	<dependency>
  		<groupId>com.relevantcodes</groupId>
  		<artifactId>extentreports</artifactId>
  		<version>2.41.2</version>
  	</dependency>
  	<dependency>
  		<groupId>org.apache.poi</groupId>
  		<artifactId>poi-ooxml</artifactId>
  		<version>4.0.0</version>
  	</dependency>
  	<dependency>
  		<groupId>info.cukes</groupId>
  		<artifactId>cucumber-java</artifactId>
  		<version>1.2.5</version>
  	</dependency>
  	<dependency>
  		<groupId>info.cukes</groupId>
  		<artifactId>cucumber-junit</artifactId>
  		<version>1.2.5</version>
  	</dependency>
  </dependencies>
  
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

Wait for WebElement (not done) and Screenshot (done)
Write to Excel File
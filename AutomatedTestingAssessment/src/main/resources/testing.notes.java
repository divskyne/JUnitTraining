// Test Suite
@RunWith(Suite.class)
@SuiteClasses({ DDTReadOnly.class, OpenReport.class })
public class AllTests {

}

// Cucumber Test
@RunWith(Cucumber.class)
@CucumberOptions(features = "TeaTesting.feature")
public class testRunner
{	
	static ExtentReports report = new ExtentReports("report.html",true);	
}

// Dependenices
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
// Default setup  
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

	// Asserts
	assertTrue(â€œBoolean was Falseâ€�, Boolean)
	assertFalse(â€œBoolean was Trueâ€�, Boolean)
	assertEquals(â€œActual was not Expectedâ€�, Expected, Actual)
	assertEquals(â€œActual was not expected within the Toleranceâ€�, Expected, Actual, Tolerance)
	fail(â€œMethod Failed the Testâ€�)
	assertNull(â€œThe object is not Nullâ€�, Object)
	assertNotNull(â€œThe object is Nullâ€�, Object)
	assertSame(â€œThe objects are not the sameâ€�, Expected, Actual)
	assertNotSame(â€œThe objects not the sameâ€�, Expected, Actual)
	
	// Drivers
	(Chrome example)
	System.setProperty("webdriver.chrome.driver","C:\\filepath\\chromedriver.exe");
	(FireFox example)
	System.setProperty("webdriver.gecko.driver", "C:\\filepath\\geckodriver.exe");
	
	// Find WebElement
	By.name(String)
	By.id(String)
	By.className(String)
	By.linkText(String
	By.XPath(String)
	By.CSSSelector(String)
	By.partialLinkText(String)
	By.tagName
	
	// WebElement
	Webdriver.get()
	Webdriver.findElement(By.)
	Webdriver.findElements(By.)
	.click()
	.sendKeys()
	isDisplayed()
	.getAttribute()
	.submit()
	
	.sendKeys(Keys.chord(Keys.SHIFT, "qa consulting")); // capitalise keys, simulates user...
	
	// Actions
	DoubleClick
	ContextClick
	keyDown(Keys key)
	keyUp(Keys key)
	sendKeys(CharSequence keys)
	
	// Wait
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); (dont use, implicit wait)
	WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("elementID"))); 


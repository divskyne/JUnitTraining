import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestDemoSite {
	
	private WebDriver driver = null;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("http://thedemosite.co.uk/");
		Navigation navPage = PageFactory.initElements(driver, Navigation.class);
		Login loginPage = PageFactory.initElements(driver, Login.class);
		navPage.getNewUser().click();
		sleep();
		loginPage.setUsername("iamtesting");
		loginPage.setPassword("mypassword");
		loginPage.submit().click();
		sleep();
		navPage.getLogin().click();
		loginPage.setUsername("iamtesting");
		loginPage.setPassword("mypassword");
		sleep();
		sleep();
		loginPage.submit().click();
		sleep();
		assertEquals("**Successful Login**", loginPage.getLoginMessage());
	}
	private void sleep() throws InterruptedException {
		Thread.sleep(200);
	}
}

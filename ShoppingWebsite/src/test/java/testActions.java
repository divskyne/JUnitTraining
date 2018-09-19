import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class testActions {
	
	WebDriver driver = null;

	@Before
	public void setUp() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void findBlouse() {
		driver.get("http://automationpractice.com");
		Actions page = PageFactory.initElements(driver, Actions.class);
		page.search("Blouse");
		assertEquals("Blouse".toUpperCase(), page.getResultSearch());
	}
	
	@Test
	public void findBeef() {
		driver.get("http://automationpractice.com");
		Actions page = PageFactory.initElements(driver, Actions.class);
		page.search("Beef");
		assertNotEquals("Beef".toUpperCase(), page.getResultSearch());
		assertEquals(0, Integer.parseInt(String.valueOf(page.getResultSearch().charAt(0))));
	}
}

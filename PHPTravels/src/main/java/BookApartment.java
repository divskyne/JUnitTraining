import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookApartment {
	
	String dropDown = "//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div/span";
	
	@FindBy(id="s2id_autogen8")
	private WebElement hiddenLocation;
	
	public void bookIt(String locations, String fromdate, String todate, String ticket, WebDriver driver) throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(hiddenLocation);
		act.click();
		act.sendKeys(locations).perform();
		
		WebElement locationSearch = (new WebDriverWait(driver, 8)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(dropDown)));

		act.moveToElement(locationSearch);

		act.click();
		
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(fromdate).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(todate).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(ticket).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
	}
}
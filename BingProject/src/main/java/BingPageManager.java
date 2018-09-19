import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingPageManager {
	
	@FindBy(id="sb_form_q")
	private WebElement searchBox;
	
	public void searchFor(String text)
	{
		searchBox.sendKeys(text);
		searchBox.submit();
	}

}

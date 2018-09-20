import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation {
	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement newUser;
	
	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement login;
	
	public WebElement getNewUser() {
		return newUser;
	}

	public WebElement getLogin() {
		return login;
	}
}
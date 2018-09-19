import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUser {
					
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	WebElement username;
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	WebElement password;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	WebElement submitButton;
	
	public String getUsername() {
		return username.getAttribute("value");
	}
	public void setUsername(String username) {
		this.username.sendKeys(username);
	}
	public String getPassword() {
		return password.getAttribute("value");
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	private WebElement submit() {
		return submitButton;
	}
}

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	@FindBy(name="username")
	private WebElement userName;
	@FindBy(name="password")
	private WebElement passWord;
	@FindBy(name="FormsButton2")
	private WebElement submitButton;
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement loginMessage;
	
	public String getLoginMessage() {
		return loginMessage.getText();
	}
	
	public String getUsername() {
		return userName.getAttribute("value");
	}
	
	public void setUsername(String username) {
		this.userName.sendKeys(username);
	}
	
	public String getPassword() {
		return passWord.getAttribute("value");
	}
	
	public void setPassword(String password) {
		this.passWord.sendKeys(password);
	}
	
	public WebElement submit() {
		return submitButton;
	}
	
}

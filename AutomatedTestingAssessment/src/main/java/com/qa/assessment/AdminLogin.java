package com.qa.assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
	
	@FindBy(id="j_username")
	WebElement adminUsername;
	
	@FindBy(name="j_password")
	WebElement adminPassword;
	
	public void login(String username, String password)
	{
		adminUsername.sendKeys(username);
		adminPassword.sendKeys(password);
		submit();
	}
	
	private void submit()
	{
		adminPassword.submit();
	}
}

package com.qa.div;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassionTea {
	
	@FindBy(xpath="//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]")
	private WebElement menu;

	@FindBy(xpath="//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	private WebElement greenTea;
	
	@FindBy(xpath="//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]")
	private WebElement checkout;
	
	@FindBy(xpath="//*[@id=\"wsb-element-00000000-0000-0000-0000-000451989411\"]/div/p/span/strong")
	private WebElement confirmCheckout;
	
	public WebElement getMenu() {
		return menu;
	}

	public WebElement getGreenTea() {
		return greenTea;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getConfirmCheckout() {
		return confirmCheckout;
	}
	
	public void navigate(WebDriver driver)
	{
		driver.get("http://www.practiceselenium.com/");
	}

}

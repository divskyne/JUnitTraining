package com.qa.assessment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageUsers {
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageJenkins;
	
	@FindBy(xpath="//*[@id=\"management-links\"]/tbody/tr[16]/td[2]/div[1]/a")
	private WebElement manageUsers;
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUser;
	
	@FindBy(id="username")
	private WebElement userName;

	@FindBy(name="password1")
	private WebElement password1;

	@FindBy(name="password2")
	private WebElement password2;
	
	@FindBy(name="fullname")
	private WebElement fullName;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(xpath="//*[@id=\"people\"]/tbody/tr")
	private WebElement hiddenUsers;
	
	@FindBy(id="main-panel")
	private WebElement addedUserName;
	
	public String assertUser(String name, WebDriver driver) {
		addedUserName = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-panel\"]/div[2]")));
		return addedUserName.getText().substring(17);
	}
	
	public void manageAllUser()
	{
		manageJenkins();
		manageUsers();
	}
	
	public void userPage()
	{
		manageAllUser();
		createUser();
	}
	
	private void manageJenkins() {
		manageJenkins.click();
	}
	
	private void manageUsers() {
		manageUsers.click();
	}
	
	private void createUser() {
		createUser.click();
	}
	
	public void createUser(String username, String password, String confirmPasword, String name, String emai)
	{
		createUser.click();
		userName.sendKeys(username);
		password1.sendKeys(password);
		password2.sendKeys(confirmPasword);
		fullName.sendKeys(name);
		email.sendKeys(emai);
	}
	
	public void submitNewUser()
	{
		email.submit();
	}
	
	public String userConfig(String name, WebDriver driver)
	{
		List <WebElement> av = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"tasks\"]/div[4]/a[1]")));
		for (WebElement webElement : av) {
			System.out.println(webElement.getAttribute("href"));
			
			if(webElement.getAttribute("href").equals(Constants.userParentLink+"user/"+name.toLowerCase()+"/configure"))
			{
				webElement.click();
				return webElement.getText();
			}
			else if (webElement.getAttribute("href").equals(Constants.userParentLink+"user/"+"d%EF%BF%BDv"+"/configure"))
			{
				webElement.click();
				return webElement.getText();
			}
		}
		return null;
	}
	
	public String userVisible(String name, WebDriver driver)
	{
		List <WebElement> av = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(name)));
		for (WebElement webElement : av) {
			
			if(webElement.getAttribute("href").equals(Constants.userParentLink+"user/"+name.toLowerCase()+"/"))
			{
				return webElement.getText();
			}
			else if (webElement.getAttribute("href").equals(Constants.userParentLink+"user/"+"d%EF%BF%BDv"+"/"))
			{
				return webElement.getText();
			}
		}
		return null;
	}
	
	public String findUser(String name, WebDriver driver)
	{
		
		List <WebElement> av = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(name)));
		for (WebElement webElement : av) {
			
			if(webElement.getAttribute("href").equals(Constants.userParentLink+"user/"+name.toLowerCase()+"/"))
			{
				hiddenUsers = webElement;
			}
			else if (webElement.getAttribute("href").equals(Constants.userParentLink+"user/"+"d%EF%BF%BDv"+"/"))
			{
				hiddenUsers = webElement;
			}
		}
		
		hiddenUsers.click();
		return assertUser(name,driver);
	}
}
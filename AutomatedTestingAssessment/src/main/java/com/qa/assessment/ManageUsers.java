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
	List<WebElement> users;
	
	@FindBy(xpath="//*[@id=\"people\"]/tbody/tr")
	WebElement hiddenUsers;
	
	public void userPage()
	{
		manageJenkins();
		manageUsers();
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
	
	public void findUser(String name, WebDriver driver)
	{
		hiddenUsers = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText(name)));
		hiddenUsers.click();
	}
}
package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Pom {
	@FindBy(css="img[alt='logo']")
	private WebElement logo;
	
	@FindBy(linkText="vtiger")
	private WebElement vtigerlink;
	
	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	@FindBy(xpath="//div[contains(text(),'You must specify a valid username and password']")
	private WebElement err_msg;
	/*
	 * public LoginPage_Pom(WebDriver driver) { 
	 * PageFactory.initElements(driver,this); }
	 */
	public WebElement getlogo()
	{
		return logo;
	}
	public WebElement getVtigerlink()
	{
		return vtigerlink;
	}
	public WebElement getUsername()
	{
		return username;
	}
	public WebElement getpassword()
	{
		return password;
	}
	public WebElement getloginbtn()
	{
		return loginbtn;
	}
	public void login_to_app_vtiger(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
	}
}

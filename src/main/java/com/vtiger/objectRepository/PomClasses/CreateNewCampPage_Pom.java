package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCampPage_Pom {
	@FindBy(name="campaignname")
	private WebElement txtboxcampName;
	
	@FindBy(css="input[type='submit']")
	private WebElement savecamp;
	
	public WebElement getcampName()
	{
		return txtboxcampName;
	}
	public WebElement getsaveCamp()
	{
		return savecamp;
	}
	
	public void enterCampName(String campName)
	{
		txtboxcampName.sendKeys(campName);
	}
	public void clickOnSave()
	{
		savecamp.click();
	}
}

package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewOrgPage_Pom {
	@FindBy(name="accountname")
	private WebElement tbOrgname;
	
	@FindBy(css="input[value='  Save  ']")
	private WebElement saveOrg;
	
	public WebElement getOrgname()
	{
		return tbOrgname;
	}
	public WebElement getsaveOrg()
	{
		return saveOrg;
	}
	
	public void enterOrgName(String OrgName)
	{
		tbOrgname.sendKeys(OrgName);
	}
	public void clickOnSave_Org()
	{
		saveOrg.click();
	}
}

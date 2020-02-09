package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewOpportunityPage_Pom {
	@FindBy(name="potentialname")
	private WebElement tbOpponame;
	
	@FindBy(xpath="//input[@name='related_to_display']//following-sibling::img")
	private WebElement relatedTo;
	public WebElement getrelatedTo()
	{
		return relatedTo;
	}
	public void clickOnrelatedTo()
	{
		relatedTo.click();
	}
	//-------------------------
	public WebElement gettbOpponame()
	{
		return tbOpponame;
	}
	@FindBy(css="input[value='  Save  ']")
	private WebElement saveOppo;
	public WebElement getsaveOppo()
	{
		return saveOppo;
	}
	
	public void enterOppoName(String Opponame)
	{
		tbOpponame.sendKeys(Opponame);
	}
	public void clickOnSave_Oppo()
	{
		saveOppo.click();
	}
}

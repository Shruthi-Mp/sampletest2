package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignPage_Pom {
	
	@FindBy(css="img[title='Create Campaign...']")
	private WebElement createCamp;

	public WebElement getCreateCamp()
	{
		return createCamp;
	}
	
	public void NavigatetoCreateNewCampaign()
	{
		createCamp.click();
	}
	
}

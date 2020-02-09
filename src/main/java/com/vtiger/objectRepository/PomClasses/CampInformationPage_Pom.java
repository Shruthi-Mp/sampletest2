package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampInformationPage_Pom {
	@FindBy(xpath="//span[contains(text(),'Campaign Information')]")
	private WebElement campsuccessMsg;
	
	public WebElement getCampaignsuccessMsg()
	{
		return campsuccessMsg;
	}
	
	public String successMsgText()
	{
		return campsuccessMsg.getText();
	}
}

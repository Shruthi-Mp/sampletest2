package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunityPage_Pom {
	@FindBy(css="img[title='Create Opportunity...']")
	private WebElement createOppo;
	
	public WebElement getCreateOpportunity()
	{
		return createOppo;
	}
	public void NavigateToCreateNewOpportunity()
	{
		createOppo.click();
	}
}

package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationsPage_Pom {
	@FindBy(css="img[title='Create Organization...']")
	private WebElement createOrg;
	
	public WebElement getCreateProduct()
	{
		return createOrg;
	}
	public void NavigateToCreateNewOrganization()
	{
		createOrg.click();
	}
}

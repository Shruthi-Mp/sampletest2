package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage_Pom {

	@FindBy(css="img[title='Create Product...']")
	private WebElement createproduct;
	
	public WebElement getCreateProduct()
	{
		return createproduct;
	}
	public void NavigateToCreateNewProduct()
	{
		createproduct.click();
	}
}

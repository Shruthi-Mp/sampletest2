package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewProductPage_Pom {
	@FindBy(name="productname")
	private WebElement tbproductname;
	
	@FindBy(css="input[value='  Save  ']")
	private WebElement saveProduct;
	
	public WebElement getproductname()
	{
		return tbproductname;
	}
	public WebElement getsaveProduct()
	{
		return saveProduct;
	}
	
	public void enterProductName(String PName)
	{
		tbproductname.sendKeys(PName);
	}
	public void clickOnSave_Product()
	{
		saveProduct.click();
	}
}

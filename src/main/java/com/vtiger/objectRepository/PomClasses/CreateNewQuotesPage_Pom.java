package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewQuotesPage_Pom {
	@FindBy(name="subject")
	private WebElement tbsubjectname;
	public WebElement getsubjectname()
	{
		return tbsubjectname;
	}
	public void enterQuoteName(String QName)
	{
		tbsubjectname.sendKeys(QName);
	}
	
	@FindBy(xpath="//input[@name='account_id']//following-sibling::img")
	private WebElement selectOrgname;
	public WebElement getselectOrgname()
	{
		return selectOrgname;
	}
	public void launchToOrg()
	{
		selectOrgname.click();	
	}
	
	@FindBy(css="input[id='search_txt']")
	private WebElement tbxSearch;
	public WebElement gettbxSearch()
	{
		return tbxSearch;
	}
	public void sendsearchValue(String searchv)
	{
		tbxSearch.sendKeys(searchv);
	}
	
	@FindBy(name="search")
	private WebElement searchNow;
	public WebElement getsearchNow()
	{
		return searchNow;
	}
	public void ClickonSearch()
	{
		searchNow.click();
	}
	
	@FindBy(xpath="//a[@class='listFormHeaderLinks']/../../following-sibling::tr/td/a")
	private WebElement selectOrgName;
	public WebElement getselectOrgName()
	{
		return selectOrgName;
	}
	public void selectOrgznName()
	{
		selectOrgName.click();
	}
	
	@FindBy(xpath="//input[@name='potential_id']//following-sibling::img")
	private WebElement selectOpportunityname;
	public WebElement getselectOpportunityname()
	{
		return selectOpportunityname;
	}
	public void launchToOpportunity()
	{
		selectOpportunityname.click();	
	}
	
	@FindBy(name="bill_street")
	private WebElement billaddress;
	/*
	 * public WebElement getbilladdress() { return billaddress; } public void
	 * enterbilladdress(String address) { billaddress.sendKeys(address); }
	 */
	
	@FindBy(name="ship_street")
	private WebElement shipaddress;
	public WebElement getshipaddress()
	{
		return shipaddress;
	}
	public void entershipaddress(String address)
	{
		shipaddress.sendKeys(address);
	}
	
	@FindBy(name="cpy")
	private WebElement cpyshipaddress;
	public WebElement getcpyshipaddress()
	{
		return cpyshipaddress;
	}
	public void copyshipaddress()
	{
		cpyshipaddress.click();
	}
	
	@FindBy(id="searchIcon1")
	private WebElement selProdicon;
	public WebElement getselProdicon()
	{
		return selProdicon;
	}
	public void selectProduct()
	{
		selProdicon.click();
	}
	
	@FindBy(xpath="//a[text()='abcd1234']")
	private WebElement selproduct;
	public WebElement getselproduct()
	{
		return selproduct;
	}
	public void selectProductfromtable()
	{
		selproduct.click();
	}
	
	@FindBy(id="qty1")
	private WebElement prodqty;
	public WebElement getprodqty()
	{
		return prodqty;
	}
	public void enterProdQty(String qty)
	{
		prodqty.sendKeys(qty);
		//return Double.parseDouble(qty);
	
	}
	
	@FindBy(css="input[value='  Save  ']")
	private WebElement saveQuote;
	public WebElement getsaveQuote()
	{
		return saveQuote;
	}
	public void clickOnSave_Quotes()
	{
		saveQuote.click();
	}
	
	
}

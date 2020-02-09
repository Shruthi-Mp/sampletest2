package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotesPage_Pom {
	@FindBy(css="img[title='Create Quote...']")
	private WebElement createQuote;
	
	public WebElement getCreateQuote()
	{
		return createQuote;
	}
	
	public void NavigatetoCreateNewQuote()
	{
		createQuote.click();
	}
	
	@FindBy(name="search_text")
	private WebElement searchfor;
	
	public WebElement getsearchfor()
	{
		return searchfor;
	}
	public void sendsearchforValue(String squote)
	{
		searchfor.sendKeys(squote);
	}
	
	@FindBy(id="bas_searchfield")
	private WebElement inddselect;
	
	public WebElement getinddselect()
	{
		return inddselect;
	}
	/*
	 * public void selectsubjectfromdd() { inddselect.click(); }
	 */
	
	@FindBy(xpath="//option[text()='Subject']")
	private WebElement ddvistext;
	
	public WebElement getddvistext()
	{
		return ddvistext;
	}
	public String selectdditemvalue()
	{
		return ddvistext.getText();
	}
	
	@FindBy(name="submit")
	private WebElement searchnow;
	
	public WebElement getsearchnow()
	{
		return searchnow;
	}
	
	public void clickonSearchNow()
	{
		searchnow.click();
	}
	
	@FindBy(xpath="(//input[@name='selected_id'])[last()-1]")
	private WebElement quotecreated1;
	
	public WebElement getquotecreated()
	{
		return quotecreated1;
	}
	public String quotecreated()
	{
		return quotecreated1.getAttribute("id");
	}
	
	@FindBy(xpath="(//input[@name='selected_id'])[last()]")
	private WebElement dquotecreated2;
	
	public WebElement getduplicatequotecreated()
	{
		return dquotecreated2;
	}
	public String duplicatequotecreated()
	{
		return dquotecreated2.getAttribute("id");
	}
}

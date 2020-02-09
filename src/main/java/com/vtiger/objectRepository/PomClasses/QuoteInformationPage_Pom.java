package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteInformationPage_Pom {
	@FindBy(xpath="//span[contains(text(),'Quote Information')]")
	private WebElement quotesuccessmsg;
	public WebElement getsuccessmsg()
	{
		return quotesuccessmsg;
	}
	public String successMsgText()
	{
		return quotesuccessmsg.getText();
	}
	
	@FindBy(css="input[title='Duplicate [Alt+U]']")
	private WebElement duplicate;
	public WebElement getduplicate()
	{
		return duplicate;
	}
	public void Clickonduplicate()
	{
		duplicate.click();
	}
	
	@FindBy(xpath="//td[@class='moduleName']/a")
	private WebElement quoteslink;
	public WebElement getquoteslink()
	{
		return quoteslink;
	}
	public void Clickonquoteslink()
	{
		quoteslink.click();
	}
	
}

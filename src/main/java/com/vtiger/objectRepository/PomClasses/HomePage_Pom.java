package com.vtiger.objectRepository.PomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericlib.BaseClass;

public class HomePage_Pom {
	@FindBy(linkText="Home")
	private WebElement homelink;
	@FindBy(linkText="Calendar")
	private WebElement calender;
	@FindBy(linkText="Leads")
	private WebElement leads;
	@FindBy(linkText="Organizations")
	private WebElement orgs;
	@FindBy(linkText="Contacts")
	private WebElement contacts;
	@FindBy(linkText="Opportunities")
	private WebElement opportunities;
	@FindBy(linkText="Products")
	private WebElement products;
	@FindBy(linkText="Documents")
	private WebElement documents;
	@FindBy(linkText="Email")
	private WebElement email;
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubletickets;
	@FindBy(linkText="Dashboard")
	private WebElement dashboard;
	@FindBy(id="qccombo")
	private WebElement quickcreate;
	
	@FindBy(linkText="More")
	private WebElement more;
	
	@FindBy(name="Quotes")
	private WebElement quotes;
	
	@FindBy(name="Campaigns")
	private WebElement mc_campaigns;
	
	@FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td[1]")
	private WebElement ddsignout;
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;
	
	public WebElement getLalender()
	{
		return calender;
	}
	public WebElement getLeads()
	{
		return leads;
	}
	public WebElement getOrgs()
	{
		return orgs;
	}
	public WebElement getContacts()
	{
		return contacts;
	}
	public WebElement getOpportunies()
	{
		return opportunities;
	}
	public WebElement getProducts()
	{
		return products;
	}
	public WebElement getDocuments()
	{
		return documents;
	}
	public WebElement getEmail()
	{
		return email;
	}
	public WebElement getTroubletickets()
	{
		return troubletickets;
	}
	public WebElement getDashboard()
	{
		return dashboard;
	}
	public WebElement getQuickCreate()
	{
		return quickcreate;
	}

	public WebElement getMore()
	{
		return more;
	}
	public WebElement getquotes()
	{
		return quotes;	
	}
	public WebElement getMACampaigns()
	{
		return mc_campaigns;
	}
	
	/*
	 * public void clickonMore() {
	 *  Actions act= new Actions(BaseClass.driver);
	 * act.moveToElement(more).perform(); }
	 */
	public void clickonCalender()
	{
		calender.click();
	}
	public void clickonCampLink_in_More()
	{
		mc_campaigns.click();
	}
	public void logout_app_vtiger()
	{
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(ddsignout).perform();
		signout.click();
	}
	public void clickonproducts()
	{
		products.click();
	}
	public void clickonOrganization()
	{
		orgs.click();
	}

	public void clickonQuotes()
	{
		quotes.click();
	}
	public void clickonOpportunities()
	{
		opportunities.click();
	}
}

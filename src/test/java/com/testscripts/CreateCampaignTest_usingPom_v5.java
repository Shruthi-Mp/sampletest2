package com.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.vtiger.genericlib.BaseClass;
import com.vtiger.genericlib.FileLib;
import com.vtiger.objectRepository.PomClasses.CampInformationPage_Pom;
import com.vtiger.objectRepository.PomClasses.CampaignPage_Pom;
import com.vtiger.objectRepository.PomClasses.CreateNewCampPage_Pom;
import com.vtiger.objectRepository.PomClasses.HomePage_Pom;

public class CreateCampaignTest_usingPom_v5 extends BaseClass{
		@Test
		public void createCampaignusingPom() throws IOException
		{
		// TODO Auto-generated method stub
		FileLib f = new FileLib();
		HomePage_Pom hp1 = PageFactory.initElements(driver,HomePage_Pom.class);
		CampaignPage_Pom cp = PageFactory.initElements(driver,CampaignPage_Pom.class);
		CreateNewCampPage_Pom newcp = PageFactory.initElements(driver,CreateNewCampPage_Pom.class);
		CampInformationPage_Pom cmpinfo = PageFactory.initElements(driver,CampInformationPage_Pom.class);
		
		//hp1.clickonMore();
		WebElement more=hp1.getMore();
		Actions act= new Actions(driver);
		act.moveToElement(more).perform();
		hp1.clickonCampLink_in_More();
		cp.NavigatetoCreateNewCampaign();
		
		String campaignName= f.fetchDatafromExcel("Campaign", 1, 0);
		newcp.enterCampName(campaignName);
		newcp.clickOnSave();
		String actText=cmpinfo.successMsgText();
		String expText=f.fetchDatafromExcel("Campaign", 1, 1);
		if(actText.contains(expText))
		{
			System.out.println("validation pass-Campaign created");
		}
		else
		{
			System.out.println("validation failed");
		}
		
	}

}

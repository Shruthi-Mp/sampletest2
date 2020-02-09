package com.testscripts;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vtiger.genericlib.BaseClass;

public class Createcamp2UsingTestNG_annotn_extendingBaseClass extends com.vtiger.genericlib.BaseClass
{
	@Test
	public void createCamp2() throws IOException 
	{			
				//Mouse Action
				WebElement more= driver.findElement(By.linkText("More"));
				Actions act= new Actions(driver);			
				act.moveToElement(more).perform();
				//driver.findElement(By.xpath("//a[text()=' Marketing']")).click();
				driver.findElement(By.name("Campaigns")).click();
						
				//Create campaign
				driver.findElement(By.cssSelector("img[title='Create Campaign...']")).click();
				driver.findElement(By.name("campaignname")).sendKeys(f.fetchDatafromExcel("Campaign",1,0));
				driver.findElement(By.cssSelector("input[type='submit']")).click();//save
				
	}

}

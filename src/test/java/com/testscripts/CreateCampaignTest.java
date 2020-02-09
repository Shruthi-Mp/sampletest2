package com.testscripts;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.genericlib.FileLib;

public class CreateCampaignTest {
	public static void main(String[] args) throws IOException
	{
		FileLib f = new FileLib();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(f.fetchDataformProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(f.fetchDataformProperty("usn"));
		driver.findElement(By.name("user_password")).sendKeys(f.fetchDataformProperty("pwd"));
		driver.findElement(By.id("submitButton")).click();
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
		
		String actmsg= driver.findElement(By.xpath("//span[contains(text(),'Campaign Information')]")).getText();
		String expmsg= f.fetchDatafromExcel("Campaign",1,1);
		System.out.println(expmsg);
		System.out.println(actmsg);
		if(actmsg.contains(expmsg))
		{
			System.out.println("Campaign created!");
		}
		else
		{
			System.out.println("failed");
		}
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.cssSelector("input[class='txtBox']")).sendKeys(f.fetchDatafromExcel("Campaign",1,0), Keys.TAB);
		//listbox
		WebElement name = driver.findElement(By.id("bas_searchfield"));
		Select option=new Select(name);
		option.selectByVisibleText("Campaign Name");
		
		driver.findElement(By.cssSelector("input[value=' Search Now ']")).click();
		List<WebElement> complist= driver.findElements(By.xpath("(//input[@name='selected_id'])"));
		System.out.println(complist.size());
		driver.findElement(By.xpath("(//input[@name='selected_id'])[last()]")).click();
		driver.findElement(By.cssSelector("input[value='Delete']")).click();
		//alert pop up
		Alert  alt= driver.switchTo().alert();
		alt.accept();
		
		String acttxt = driver.findElement(By.xpath("//span[contains(text(),'No Campaign Found !')]")).getText();
		String exptxt = f.fetchDatafromExcel("Campaign",1,3);
		
		if(exptxt.equals(acttxt))
		{
			System.out.println("validation pass");
		}
		else
		{				
			System.out.println("validation fail");
		}
			System.out.println(acttxt);
			System.out.println(exptxt);
		
		List<WebElement> complist2= driver.findElements(By.xpath("(//input[@name='selected_id'])"));
		System.out.println(complist2.size());
		
	}
}

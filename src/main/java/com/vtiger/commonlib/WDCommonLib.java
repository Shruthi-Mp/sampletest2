package com.vtiger.commonlib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.genericlib.BaseClass;

public class WDCommonLib
{
	String mainId;
	String childId;
	public void waitforelement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(BaseClass.driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void moveMousePointer(WebElement element)
	{
		Actions act=new Actions(BaseClass.driver);
		act.moveToElement(element).perform();
	}
	public void selectItemfromlist(WebElement element,String item)
	{
		Select s=new Select(element);
		s.selectByVisibleText(item);	
	}
	public void naviagtetochildwindow()
	{
		Set<String> allid = BaseClass.driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		mainId= it.next();
		childId=it.next();
		BaseClass.driver.switchTo().window(childId);
	}
	public void naviagtetoParentwindow()
	{
		//String mainId = BaseClass.driver.getWindowHandle();
		BaseClass.driver.switchTo().window(mainId);
		
	}
	public void acceptAlert()
	{
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.accept();
	}
	public void rejectAlert()
	{
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.dismiss();
	}
}

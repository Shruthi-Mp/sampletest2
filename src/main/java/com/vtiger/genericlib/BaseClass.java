package com.vtiger.genericlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectRepository.PomClasses.HomePage_Pom;
import com.vtiger.objectRepository.PomClasses.LoginPage_Pom;
public class BaseClass
{
	public static FileLib f = new FileLib();
	public static WebDriver driver;
	@BeforeSuite
	public void connectDB()
	{
		System.out.println("-----DB connection -----");
	}
	@BeforeClass
	public void openBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(f.fetchDataformProperty("url"));
		System.out.println("browser launched");
	}
	@BeforeMethod
	public void login() throws IOException
	{
		System.out.println("Login starts");
		String username=f.fetchDataformProperty("usn");
		String passwd=f.fetchDataformProperty("pwd");
		LoginPage_Pom lp = PageFactory.initElements(driver, LoginPage_Pom.class);
		lp.login_to_app_vtiger(username,passwd);
	}
	@AfterMethod
	public void logout()
	{
		/*driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]")).click();
		WebElement sgnout =driver.findElement(By.linkText("Sign Out"));
		Actions act = new Actions(driver);
		act.moveToElement(sgnout).perform(); */ //this code will not workout 
		
		HomePage_Pom hp = PageFactory.initElements(driver, HomePage_Pom.class);
		hp.logout_app_vtiger();
		System.out.println("logged out");
	}
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("closing browser");
		driver.close();
	}
	@AfterSuite
	public void closeDB()
	{
		System.out.println("----closing DB----");
	}
}

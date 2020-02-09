package com.testscripts;

import java.io.IOException;
import java.util.Random;

//import org.junit.internal.Throwables;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.commonlib.WDCommonLib;
import com.vtiger.genericlib.BaseClass;
import com.vtiger.genericlib.FileLib;
import com.vtiger.objectRepository.PomClasses.CreateNewOpportunityPage_Pom;
import com.vtiger.objectRepository.PomClasses.CreateNewOrgPage_Pom;
import com.vtiger.objectRepository.PomClasses.CreateNewProductPage_Pom;
import com.vtiger.objectRepository.PomClasses.CreateNewQuotesPage_Pom;
import com.vtiger.objectRepository.PomClasses.HomePage_Pom;
import com.vtiger.objectRepository.PomClasses.OpportunityPage_Pom;
import com.vtiger.objectRepository.PomClasses.OrganizationsPage_Pom;
import com.vtiger.objectRepository.PomClasses.ProductsPage_Pom;
import com.vtiger.objectRepository.PomClasses.QuoteInformationPage_Pom;
import com.vtiger.objectRepository.PomClasses.QuotesPage_Pom;

public class Create_duplicate_N_ValidateQuotes extends BaseClass
{
	@Test
	public void createQuotation() throws IOException, InterruptedException
	{
		WDCommonLib comlib=new WDCommonLib();
		FileLib f = new FileLib();
		HomePage_Pom hp1 = PageFactory.initElements(BaseClass.driver,HomePage_Pom.class);
		
		OrganizationsPage_Pom op = PageFactory.initElements(BaseClass.driver, OrganizationsPage_Pom.class);
		CreateNewOrgPage_Pom cnop = PageFactory.initElements(BaseClass.driver, CreateNewOrgPage_Pom.class);
		
		OpportunityPage_Pom opp = PageFactory.initElements(BaseClass.driver, OpportunityPage_Pom.class);
		CreateNewOpportunityPage_Pom cnopp = PageFactory.initElements(BaseClass.driver, CreateNewOpportunityPage_Pom.class);
		
		ProductsPage_Pom pp = PageFactory.initElements(BaseClass.driver, ProductsPage_Pom.class);
		CreateNewProductPage_Pom cnpp = PageFactory.initElements(BaseClass.driver, CreateNewProductPage_Pom.class);
		
		QuotesPage_Pom qp=PageFactory.initElements(BaseClass.driver, QuotesPage_Pom.class);
		CreateNewQuotesPage_Pom cnp = PageFactory.initElements(BaseClass.driver, CreateNewQuotesPage_Pom.class);
		QuoteInformationPage_Pom qinfo = PageFactory.initElements(BaseClass.driver, QuoteInformationPage_Pom.class);
		
		Random r=new Random();
		int num=r.nextInt();
		hp1.clickonOrganization();
		op.NavigateToCreateNewOrganization();
		String OrgName=f.fetchDatafromExcel("Org", 1, 0);
		String orgnameis=OrgName+num;
		cnop.enterOrgName(orgnameis);
		cnop.clickOnSave_Org();
		System.out.println("Organization created");
		Thread.sleep(4000);
		
		hp1.clickonOpportunities();
		opp.NavigateToCreateNewOpportunity();
		String OppoName=f.fetchDatafromExcel("Opportunity", 1, 0);
		String OppoNameis=OppoName+num;
		cnopp.enterOppoName(OppoNameis);
		cnopp.clickOnrelatedTo();
		
		comlib.naviagtetochildwindow();
		cnp.sendsearchValue(OppoNameis);
		cnp.ClickonSearch();
		cnp.selectOrgznName();
		try {
			comlib.acceptAlert();
			}
			catch(Exception e)
			{
				//Thread.sleep(5000);
			}
		comlib.naviagtetoParentwindow();
		cnopp.clickOnSave_Oppo();
		System.out.println("Opportunity created");
		Thread.sleep(2000);
		
		hp1.clickonproducts();
		pp.NavigateToCreateNewProduct();
		String ProdName=f.fetchDatafromExcel("product", 1, 0);
		cnpp.enterProductName(ProdName);
		cnpp.clickOnSave_Product();
		System.out.println("Product created");
		
		WebElement more=hp1.getMore();
		comlib.moveMousePointer(more);
		hp1.clickonQuotes();
		
		qp.NavigatetoCreateNewQuote();
		String Qname=f.fetchDatafromExcel("quote", 1, 0);
		Thread.sleep(2000);
		cnp.enterQuoteName(Qname);
		cnp.launchToOrg();
		
		comlib.naviagtetochildwindow();
		//String searchvalue=f.fetchDatafromExcel("Org", 1, 0);
		cnp.sendsearchValue(orgnameis);
		cnp.ClickonSearch();
		Thread.sleep(3000);
		cnp.selectOrgznName();
		try {
		comlib.acceptAlert();
		}
		catch(Exception e)
		{
			//Thread.sleep(5000);
		}
		comlib.naviagtetoParentwindow();
		String address=f.fetchDatafromExcel("quote", 1, 1);
		cnp.entershipaddress(address);
		cnp.copyshipaddress();
		cnp.selectProduct();
		
		comlib.naviagtetochildwindow();
		cnp.sendsearchValue(ProdName);
		cnp.ClickonSearch();
		cnp.selectProductfromtable();
		Thread.sleep(2000);
		comlib.naviagtetoParentwindow();
		double qty1 = f.fetchDatafromExcelDouble("quote", 1, 2);
		Double qty2= qty1;
		String qt3 = qty2.toString();
		cnp.enterProdQty(qt3);
		cnp.clickOnSave_Quotes();
		System.out.println("Quote created");
		
		qinfo.Clickonduplicate();
		cnp.clickOnSave_Quotes();
		System.out.println("Duplicate Quote created");
		qinfo.Clickonquoteslink();
		WebElement dd=qp.getinddselect();
		String item=qp.selectdditemvalue();
		comlib.selectItemfromlist(dd, item);
		qp.sendsearchforValue(Qname);
		qp.clickonSearchNow();
		
		int id1=Integer.parseInt(qp.quotecreated());
		int id2=Integer.parseInt(qp.duplicatequotecreated());
		//System.out.println(id1+"   "+id2);
		id1+=1;
		System.out.println(id1+"   "+id2);
		Assert.assertTrue(id1==id2);
		System.out.println("duplicate created");
		
		
	}
	
}

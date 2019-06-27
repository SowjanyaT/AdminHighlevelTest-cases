package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.UniformDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminCategoryPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

	
	public class AdminCatExcelTestUNF_064 extends AdminLoginTest{

	public WebDriver driver;
	private String baseUrl;
	private AdminCategoryPOM admincategoryPOM;
	private static Properties properties;
	private ScreenShot screenShot; 
	private AdminLoginTest adminlogintest;
    
    
	

		
@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
		public void AdminCatTest(String Name, String Description,String MetaTag,String MetaTagD) throws InterruptedException {
		{
			AdminLoginTest adminlogintest=new AdminLoginTest();
			adminlogintest.Adminlogin();
			System.out.println("Add New details");
			admincategoryPOM.clickCatalog();
			Thread.sleep(3000);
			admincategoryPOM.clickCategory();
			
			Thread.sleep(3000);
			admincategoryPOM.clickAddNew();
			Thread.sleep(3000);
			admincategoryPOM.sendname(Name);
			Thread.sleep(3000);
			screenShot.captureScreenShot(Name);
			admincategoryPOM.senddescription(Description);
			Thread.sleep(3000);
			screenShot.captureScreenShot(Description);
			admincategoryPOM.sendmetatag(MetaTag);
			Thread.sleep(3000);
			screenShot.captureScreenShot(MetaTag);
			admincategoryPOM.sendmetatagd(MetaTagD);
			screenShot.captureScreenShot(MetaTagD);
			
		}
		
		
}
}


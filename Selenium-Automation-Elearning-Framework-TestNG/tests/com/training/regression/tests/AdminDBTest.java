package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.UniformDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AdminCategoryPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminDBTest extends AdminLoginTest{
	private WebDriver driver;
	private String baseUrl;
	private AdminCategoryPOM admincategoryPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	private AdminLoginTest adminlogintest;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		admincategoryPOM = new AdminCategoryPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = UniformDataProviders.class)
	public void loginDBTest(String Name, String Description,String Metatag,String MetatagD) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
			AdminLoginTest adminlogintest=new AdminLoginTest();
			adminlogintest.Adminlogin();
			admincategoryPOM.clickCatalog();
			Thread.sleep(3000);
			admincategoryPOM.clickCategory();
			
			Thread.sleep(3000);
			admincategoryPOM.clickAddNew();
			Thread.sleep(3000);
			admincategoryPOM.sendname(Name);
		
			admincategoryPOM.senddescription(Description);
		Thread.sleep(3000);
		admincategoryPOM.sendmetatag(Metatag);
		admincategoryPOM.sendmetatagd(MetatagD);
		

	}
}

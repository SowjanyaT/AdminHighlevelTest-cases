package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminCatDataBaseTest {
	public WebDriver driver;
	private String baseUrl;
	private AdminCategoryPOM admincategoryPOM;
	private static Properties properties;
	private ScreenShot screenShot; 
    
    
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
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(1000);
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	

	@Test()
	public void testlogin() throws InterruptedException {
	admincategoryPOM.sendusername("admin");
	
	admincategoryPOM.sendPassword("admin@123");
	Thread.sleep(3000);
	admincategoryPOM.clickLoginBtn();
	screenShot.captureScreenShot();
	admincategoryPOM.clickCatalog();
	Thread.sleep(3000);
	admincategoryPOM.clickCategory();
	
	Thread.sleep(3000);
	admincategoryPOM.clickAddNew();
	Thread.sleep(3000);

	admincategoryPOM.sendname("Sports");
	Thread.sleep(3000);
	screenShot.captureScreenShot();
	admincategoryPOM.senddescription("Sports Shoe");
	Thread.sleep(3000);
	screenShot.captureScreenShot();
	admincategoryPOM.sendmetatag("Shoes");
	Thread.sleep(3000);
	screenShot.captureScreenShot();
	admincategoryPOM.sendmetatagd("Sports Shoes");
	screenShot.captureScreenShot();
	admincategoryPOM.clickSave();
	String Actual,Actual_Str;
	Actual_Str=driver.findElement(By.xpath("//*[@class='alert alert-success']")).getText();
	Actual=Actual_Str.replace("\n", "");
	Actual=Actual.replace("×", "");
	String Expected="Success: You have modified categories!";
	Assert.assertEquals(Actual,Expected);
	System.out.println(Expected);
	}
	
}

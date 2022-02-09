package Automation;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import resources.base;


public class ValidateNavigationBar extends base{
	public WebDriver driver;
	LandingPage lp;
	@BeforeTest
	public void initialise() throws IOException, InterruptedException
	{
		driver = Initialization();
		System.out.println("TEST3: Validate Navigation bar");
		
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void ValidateNavigation() throws IOException 
	{	
		lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigation1().isDisplayed());
		System.out.println("TC1-MINT NFTs module displayed successfully");
		Assert.assertTrue(lp.getNavigation2().isDisplayed());
		System.out.println("TC2-KNOW WATCH+ module displayed successfully");
		Assert.assertTrue(lp.getNavigation3().isDisplayed());
		System.out.println("TC3-MEMBERSHIP PLANS module displayed successfully");
		Assert.assertTrue(lp.getNavigation4().isDisplayed());
		System.out.println("TC4-ROADMAP module displayed successfully");
		Assert.assertTrue(lp.getNavigation5().isDisplayed());
		System.out.println("TC5-FAQs module displayed successfully");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}



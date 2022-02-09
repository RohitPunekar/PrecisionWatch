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


public class ValidateTitle extends base{
	public WebDriver driver;
	LandingPage lp;
	@BeforeTest
	public void initialise() throws IOException, InterruptedException
	{
		driver = Initialization();		
		System.out.println("TEST4: Validate title Test");

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));

		driver.get(prop.getProperty("url"));	
	}

	@Test
	public void Validate_Title() throws IOException, InterruptedException 
	{
		lp = new LandingPage(driver);
		Assert.assertTrue(lp.getTitle1().isDisplayed());
		System.out.println("Validated TestCase 1 successfully");
		Assert.assertEquals(lp.getTitle3().getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do."); 
		System.out.println("Validated TestCase 2 Successfully");
		Assert.assertTrue(lp.getTitle4().isDisplayed()); 
		System.out.println("Validated TestCase 3 Successfully");
//		Assert.assertEquals(lp.getTitle5().getText(), "Ensure the integrity and health of your timepiece in perpetuity"); 
//		System.out.println("Validated TestCase 4 Successfully");
//		Assert.assertEquals(lp.getTitle2().getText(), "IMMORTALIZE YOUR TIMEPIECE");
//		System.out.println("Validated TestCase 5 successfully");
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}



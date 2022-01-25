package Automation;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import resources.base;


public class ValidateTitle extends base{
	public WebDriver driver;
	
	@BeforeTest
	public void initialise() throws IOException, InterruptedException
	{
		driver = Initialization();		
		System.out.println("TEST4: Validate title Test");
		driver.get(prop.getProperty("url"));	
		System.out.println("URL opened successfully");
	}

	@Test
	public void Validatetitle() throws IOException 
	{
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "IMMORTALIZE YOUR TIMEPIECE"); 
		System.out.println("Validated title successfully");
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}



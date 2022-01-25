package Automation;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import resources.base;


public class ValidateNavigationBar extends base{
	public WebDriver driver;
	
	@BeforeTest
	public void initialise() throws IOException, InterruptedException
	{
		driver = Initialization();
		System.out.println("TEST3: Validate Navigation bar");
		driver.get(prop.getProperty("url"));
		System.out.println("URL opened sucessfully");
	}

	@Test
	public void ValidateNavigation() throws IOException 
	{	
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		
		System.out.println("FAQs module displayed successfully");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}



package Automation;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;


public class homepage extends base{
	public WebDriver driver;
	LandingPage lp;


	@BeforeTest
	public void initialise() throws IOException, InterruptedException
	{
		driver = Initialization();	
		System.out.println("TEST2: Login Page Test");
		
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
	}

	@Test
	public void ValidateLogin() throws IOException 
	{	
		driver.get(prop.getProperty("url"));
		System.out.println("TestCase1-URL opened successfully");

		lp = new LandingPage(driver);
		lp.getLogin().click();
		System.out.println("TestCase2-Clicked on login page button successfully");

		LoginPage Lp = new LoginPage(driver);
		Lp.getEmail().sendKeys(prop.getProperty("username1"));
		System.out.println( "username1 entered successfully");
		Lp.getPass().sendKeys(prop.getProperty("password1"));
		System.out.println("password1 entered successfully");
		Lp.clickSubmit().click();
		System.out.println("clicked on submit button successfully");
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}


}

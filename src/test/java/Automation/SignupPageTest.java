package Automation;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.SignupPage;
import pageobjects.gmailCode;
import resources.base;

public class SignupPageTest extends base {
	public WebDriver driver;

	@BeforeTest
	public void initialise() throws IOException, InterruptedException
	{
		driver = Initialization();	
		System.out.println("TEST2: Signup Page Test");
	}

	@Test(priority=1)
	public void ValidateSignup() throws InterruptedException 
	{
		//4.Verify user is able to signup

		driver.get(prop.getProperty("url"));
		System.out.println("URL opened successfully");

		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		System.out.println("clicked on login page button");
		lp.getstart().click();
		System.out.println("clicked on signup page URL");

		SignupPage sp = new SignupPage(driver);
		sp.getEmail().sendKeys(prop.getProperty("username"));
		System.out.println("entered username");
		sp.getMobile().sendKeys(prop.getProperty("mobile"));
		System.out.println("entered mobile number");
		sp.getMail().sendKeys(prop.getProperty("email"));
		System.out.println("entered email address");
//		sp.getWallet().sendKeys(prop.getProperty("wallet"));
//		System.out.println("entered wallet address");
		sp.getPassword().sendKeys(prop.getProperty("pwd"));
		System.out.println("entered password");
		sp.ConfirmPass().sendKeys(prop.getProperty("pwd"));
		System.out.println("password confirmed");
		sp.getSubmit().click();
		System.out.println("clicked on submit button");
		Thread.sleep(3000);
		
		
	
//		sp.getotp1().sendKeys(otp1);
//		sp.getotp2().sendKeys(otp2);
//		sp.getotp3().sendKeys(otp3);
//		sp.getotp4().sendKeys(otp4);
//		System.out.println("otp entered successfully");
//		sp.getSubmit2().click();
//		System.out.println("clicked on submit button");
	}
	
	
	@Test(priority = 2)
	public void GetGmailOtp() throws InterruptedException
	{
		gmailCode gc = new gmailCode(driver);
		gc.getURL();
		System.out.println("URL opened successfully");
		gc.GetUsername().sendKeys(prop.getProperty("email"));
		System.out.println("Username entered");
		gc.GetNext().click();
		System.out.println("Clicked on Next button");
		Thread.sleep(5000);
		gc.GetPass().sendKeys(prop.getProperty("password"));
		System.out.println("Password entered");
		gc.GetSubmit().click();
		System.out.println("Clicked on submit button");
		String heading = gc.GetTxt().getText();
		if(gc.GetTxt().equals(heading)) 
		{
		gc.Getid().click();
		} 
    	
		
	}


	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	 

}

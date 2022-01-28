package Automation;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@Test
	public void ValidateSignup() throws InterruptedException 
	{
		//Verify user is able to signup
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
		sp.getWallet().click();


//		sp.getPassword().sendKeys(prop.getProperty("pwd"));
//		System.out.println("entered password");
//		sp.ConfirmPass().sendKeys(prop.getProperty("pwd"));
//		System.out.println("password confirmed");
		
//		sp.getSubmit().click();
//		System.out.println("clicked on submit button");

		
//		gmailCode gc = new gmailCode(driver);
//		driver.get("https://mail.google.com/mail");
//		System.out.println("URL opened successfully");
//		gc.GetUsername().sendKeys("rohitqa20@gmail.com");
//		System.out.println("Username entered");
//		gc.GetNext().click();
//		System.out.println("Clicked on Next button");
//		Thread.sleep(3000);
//		gc.GetPass().sendKeys("Rohit@jer435");
//		System.out.println("Password entered");
//		gc.GetSubmit().click();
//		System.out.println("Clicked on submit button");
//		Thread.sleep(3000);
//
//		driver.get("https://mail.google.com/mail/u/0/#inbox/FMfcgzGmtXJFVLpswpTpNvMnScSRVplb");
//		System.out.println("reading OTP");
//		Thread.sleep(20000);
//		List<WebElement> myy11 = driver.findElements(By.cssSelector("[id] div p:nth-child(2)"));
//		// System.out.println("List "+ my.size());
//		for (WebElement amm : myy11)
//		{
//			String name111 = amm.getText();
//			System.out.println("==========" + name111);
//			char a = name111.charAt(0);
//			System.out.println("first number =" + a);
//			char b = name111.charAt(1);
//			System.out.println("Second number =" + b);
//			char c = name111.charAt(2);
//			System.out.println("Third number =" + c);
//			char d = name111.charAt(3);
//			System.out.println("Fourth number =" + d);

	}





//		@AfterTest
//		public void teardown()
//		{
//			driver.quit();
//		}


}

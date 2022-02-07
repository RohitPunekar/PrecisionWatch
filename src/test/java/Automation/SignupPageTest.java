package Automation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Enter;
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
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void ValidateSignup() throws InterruptedException 
	{
		//Verify user is able to signup
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		System.out.println("clicked on login page button");
		lp.getstart().click();
		System.out.println("clicked on signup page URL");

		SignupPage sp = new SignupPage(driver);
		sp.getEmail().sendKeys(prop.getProperty("username"));
		System.out.println("entered username");
//		sp.getMobile().sendKeys(prop.getProperty("mobile"));
//		System.out.println("entered mobile number");
		sp.getMail().sendKeys(prop.getProperty("email"));
		System.out.println("entered email address");
		sp.getWallet().click();

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(0));
		driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/notification.html");
		driver.findElement(By.xpath("//*[@class='button btn--rounded btn-primary']")).click();
		driver.findElement(By.xpath("//*[@class='button btn--rounded btn-primary page-container__footer-button']")).click();
		System.out.println("Metamask wallet connected");
		driver.switchTo().window(newTb.get(0)).close();
		
		driver.switchTo().window(newTb.get(1));
		sp.getPassword().sendKeys(prop.getProperty("pwd"));
		System.out.println("entered password");
		sp.ConfirmPass().sendKeys(prop.getProperty("pwd"));
		System.out.println("password confirmed");
		sp.getSubmit().click();
		System.out.println("clicked on submit button");


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

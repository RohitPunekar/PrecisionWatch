package Automation;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.gmailCode;
import resources.base;

public class gmailOtpReading extends base {
	@Test
	public void ReadOtp() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("debuggerAddress", "localhost:54145");
		driver = new ChromeDriver(option);

		gmailCode gc = new gmailCode(driver);
		driver.get("https://mail.google.com/mail");
		System.out.println("URL opened successfully");
		gc.GetUsername().sendKeys("rohitqa20@gmail.com");
		System.out.println("Username entered");
		gc.GetNext().click();
		System.out.println("Clicked on Next button");
		Thread.sleep(3000);
		gc.GetPass().sendKeys("Rohit@jer435");
		System.out.println("Password entered");
		gc.GetSubmit().click();
		System.out.println("Clicked on submit button");
		Thread.sleep(3000);

		driver.get("https://mail.google.com/mail/u/0/#inbox/FMfcgzGmtXJFVLpswpTpNvMnScSRVplb");
		System.out.println("reading OTP");
		Thread.sleep(20000);
		List<WebElement> myy11 = driver.findElements(By.cssSelector("[id] div p:nth-child(2)"));
		// System.out.println("List "+ my.size());
		for (WebElement amm : myy11)
		{
			String name111 = amm.getText();
			System.out.println("==========" + name111);
			char a = name111.charAt(0);
			System.out.println("first number =" + a);
			char b = name111.charAt(1);
			System.out.println("Second number =" + b);
			char c = name111.charAt(2);
			System.out.println("Third number =" + c);
			char d = name111.charAt(3);
			System.out.println("Fourth number =" + d);
		}


	}
}

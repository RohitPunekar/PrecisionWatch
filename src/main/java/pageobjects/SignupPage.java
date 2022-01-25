package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class SignupPage extends base{

	WebDriver driver;

	public SignupPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	By uname = By.xpath("//*[@name='name']");
	By mbl = By.xpath("//*[@name='mobile']");
	By mail = By.xpath("//*[@name='email']");
	By wallet = By.xpath("//*[@name='walletAddress']");
	By pass = By.xpath("//*[@name='password']");
	By cpass = By.xpath("//*[@placeholder='Both passwords must match']");
	By submit = By.xpath("//*[@type='submit']");
	By otp1 = By.xpath("//*[@name='otp1']");
	By otp2 = By.xpath("//*[@name='otp2']");
	By otp3 = By.xpath("//*[@name='otp3']");
	By otp4 = By.xpath("//*[@name='otp4']");
	By submit2 = By.xpath("//*[@type='submit']");


	public WebElement getEmail()
	{
		return driver.findElement(uname);
	}

	public WebElement getMobile()
	{
		return driver.findElement(mbl);
	}

	public WebElement getMail()
	{
		return driver.findElement(mail);
	}

	public WebElement getWallet()
	{
		return driver.findElement(wallet);
	}

	public WebElement getPassword()
	{
		return driver.findElement(pass);
	}

	public WebElement ConfirmPass()
	{
		return driver.findElement(cpass);
	}

	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
	
	public WebElement getotp1()
	{
		return driver.findElement(otp1);
	}
	
	public WebElement getotp2()
	{
		return driver.findElement(otp2);
	}
	
	public WebElement getotp3()
	{
		return driver.findElement(otp3);
	}
	
	public WebElement getotp4()
	{
		return driver.findElement(otp4);
	}
	
	public WebElement getSubmit2()
	{
		return driver.findElement(submit2);
	}

}

package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LoginPage extends base
{

	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}



	By uname = By.xpath("//*[@name='email']");
	By pass = By.xpath("//*[@name='password']");
	By getstart = By.xpath("//*[@type='submit']");



	public WebElement getEmail()
	{
		return driver.findElement(uname);
	}

	public WebElement getPass()
	{
		return driver.findElement(pass);
	}

	public WebElement clickSubmit()
	{
		return driver.findElement(getstart);
	}
}

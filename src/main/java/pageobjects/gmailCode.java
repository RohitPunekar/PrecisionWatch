package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class gmailCode extends base {

public WebDriver driver;
	
	public gmailCode(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	By uname = By.xpath("//*[@type='email']");
	By next = By.xpath("//*[@id=\"identifierNext\"]/div/button/span");
	By pwd = By.xpath("//*[@type='password']");
	By sbmit = By.xpath("//*[@id=\"passwordNext\"]/div/button/span");
	By id = By.xpath("//*[@id=':25']");
	By text = By.xpath("//*[@email='rapidinnovation376@gmail.com']");
	
	public WebElement GetUsername()
	{
		return driver.findElement(uname);
	}
	public WebElement GetNext()
	{
		return driver.findElement(next);
	}
	public WebElement GetPass()
	{
		return driver.findElement(pwd);
	}
	public WebElement GetSubmit()
	{
		return driver.findElement(sbmit);
	}
	public WebElement Getid()
	{
		return driver.findElement(id);
	}
	public WebElement GetTxt()
	{
		return driver.findElement(text);
	}
	
	

}

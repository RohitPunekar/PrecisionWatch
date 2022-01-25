package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LandingPage extends base {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	By signin = By.xpath("//*[@type='button']");
	By title = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/section[1]/div[1]/div[1]/caption");
	By FAQs = By.xpath("/html/body/div/div/div/div[1]/div[1]/div/ul/li[5]/a");
	By signup = By.xpath("//*[@href=\"/signup\"]");
	

	public WebElement getLogin()
	{
	 return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
	 return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(FAQs);
	}
	
	public WebElement getstart()
	{
	 return driver.findElement(signup);
	}

}

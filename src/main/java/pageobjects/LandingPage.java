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
	By signup = By.xpath("//*[@href=\"/signup\"]");
	
	By title1 = By.xpath("//*[@class='sc-bYoBSM khdscJ']/img");
	By title2 = By.xpath("//*[@class='sc-kTLmzF wjVan']/div/caption");
	By title3 = By.xpath("//*[@class='sc-kTLmzF wjVan']/div/p");
	By title4 = By.xpath("//*[@class='sc-kTLmzF wjVan']/div/button");
	By title5 = By.xpath("//*[@class='sc-kTLmzF wjVan']/div/h1");
	
	
	By Nav1 = By.linkText("MINT NFTs");
	By Nav2 = By.linkText("KNOW WATCH+");
	By Nav3 = By.linkText("MEMBERSHIP PLANS");
	By Nav4 = By.linkText("ROADMAP");
	By Nav5 = By.linkText("FAQs");
	
	


	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}

	public WebElement getstart()
	{
		return driver.findElement(signup);
	}

	public WebElement getTitle1()
	{
		return driver.findElement(title1);	
	}
	
	public WebElement getTitle2()
	{
		return driver.findElement(title2);
	}
	
	public WebElement getTitle3()
	{
		return driver.findElement(title3);
	}
	
	public WebElement getTitle4()
	{
		return driver.findElement(title4);
	}
	
	public WebElement getTitle5()
	{
		return driver.findElement(title5);
	}
	
	public WebElement getNavigation1()
	{
		return driver.findElement(Nav1);
	}
	
	public WebElement getNavigation2()
	{
		return driver.findElement(Nav2);
	}
	
	public WebElement getNavigation3()
	{
		return driver.findElement(Nav3);
	}
	
	public WebElement getNavigation4()
	{
		return driver.findElement(Nav4);
	}
	
	public WebElement getNavigation5()
	{
		return driver.findElement(Nav5);
	}



}

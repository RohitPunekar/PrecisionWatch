package Automation;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;


public class homepage extends base{
	public WebDriver driver;


	@BeforeTest
	public void initialise() throws IOException, InterruptedException
	{
		driver = Initialization();	
		System.out.println("TEST1: Login Page Test");
	}

	@Test(dataProvider = "getData")
	public void ValidateLogin(String username,String password, String text ) throws IOException 
	{
		//1.open url
		
		driver.get(prop.getProperty("url"));
		System.out.println("URL opened successfully");

		//2.click on login page button
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		System.out.println("Clicked on login page button successfully");

		//3.Verify user is able to login 
		
		LoginPage Lp = new LoginPage(driver);
		Lp.getEmail().sendKeys(username);
		System.out.println(text+" :username entered successfully");
		
		Lp.getPass().sendKeys(password);
		System.out.println(text+" :password entered successfully");
		
		Lp.clickSubmit().click();
		System.out.println("clicked on submit button successfully");
		
		
	}


	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];  

		//login with invalid username & password
		data[0][0] = "rohit@punekar.com";
		data[0][1] = "123";
		data[0][2] = "user 1";

		//login with valid username & password
		data[1][0] = "bhagyasri.qa25@gmail.com";
		data[1][1] = "Watch+123";
		data[1][2] = "user 2";


		return data;
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}


}

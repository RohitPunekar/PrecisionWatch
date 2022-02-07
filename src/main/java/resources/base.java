package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver Initialization() throws IOException, InterruptedException 
	{
		FileInputStream fis = new FileInputStream(new File(".//config//file.properties"));
		prop = new Properties();
		prop.load(fis);

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(".//Metamask//extension.crx"));

		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();

		}
		else if(browserName.equalsIgnoreCase("gecko"))
		{
			WebDriverManager.firefoxdriver().setup();
		}
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#initialize/welcome");
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		driver.findElement(By.xpath("//*[@role='button']")).click();
		driver.findElement(By.xpath("//*[@id='app-content']/div/div/div/div/div/div/div/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//*[@data-testid='page-container-footer-next']")).click();
		driver.findElement(By.xpath("//*[@placeholder='Paste Secret Recovery Phrase from clipboard']")).sendKeys(prop.getProperty("SecretRecoveryPhrase"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("confirm-password")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.xpath("//*[@class='first-time-flow__checkbox first-time-flow__terms']")).click();
		driver.findElement(By.xpath("//*[@class='button btn--rounded btn-primary first-time-flow__button']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@role='button']")).click();
		driver.findElement(By.xpath("//*[@data-testid='popover-close']")).click();
		return driver;
	}

	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}


}

package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver Initialization() throws IOException, InterruptedException 
	{
		FileInputStream fis = new FileInputStream(new File(".//config//file.properties"));
		prop = new Properties();
		prop.load(fis);

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

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(".//Metamask//extension.crx"));
		driver = new ChromeDriver(options);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Get Started']")).click();
		
		//		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		//		driver.switchTo().window(newTb.get(1));
		//		driver.get(prop.getProperty("url"));
		//		Thread.sleep(3000);
		//		driver.switchTo().window(newTb.get(1));
		//		driver.manage().window().maximize();
		//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

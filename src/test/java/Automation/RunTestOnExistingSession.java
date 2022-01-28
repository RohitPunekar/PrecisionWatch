package Automation;

import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunTestOnExistingSession {
	@Test
	public void f()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Capabilities cap = driver.getCapabilities();
		Map<String, Object> mycap = cap.asMap();
		System.out.println(mycap);
	}

}

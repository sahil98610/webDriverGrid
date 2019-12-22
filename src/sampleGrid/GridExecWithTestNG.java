package sampleGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExecWithTestNG {
	RemoteWebDriver driver;
	DesiredCapabilities caps;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws MalformedURLException {
		String nodeUrl = "http://192.168.50.1:4444/wd/hub";
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("start-maximized");
			driver = new RemoteWebDriver(new URL(nodeUrl), chromeOptions);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("start-maximized");
			driver = new RemoteWebDriver(new URL(nodeUrl), firefoxOptions);
		}

		else if (browser.equalsIgnoreCase("ieexplorer")) {
			EdgeOptions explorerOptions = new EdgeOptions();
			driver = new RemoteWebDriver(new URL(nodeUrl), explorerOptions);
		}
		
		//driver = new RemoteWebDriver(chromeOptions);
	
		driver.get("https://google.co.in");
	}

	@Test
	public void testLogin() {
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).submit();
		String title = driver.getTitle();
		Assert.assertTrue(title.startsWith("Selenium"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}

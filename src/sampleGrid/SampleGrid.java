package sampleGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SampleGrid {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		WebDriver driver;
		String nodeUrl = "http://192.168.50.1:4444/wd/hub";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/dependencies/chromedriver.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("download.default_directory", System.getProperty("user.dir")+"/src/dependencies/");
		capabilities.merge(chromeOptions);
		DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
		driver.get("https://google.co.in");
		driver.findElement(By.name("q")).sendKeys("Cheese");
		driver.findElement(By.name("q")).submit();
		Thread.sleep(3000);
		driver.quit();
	}

}

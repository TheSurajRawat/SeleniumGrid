package com.digitalacademy.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;

public final class WebDriverFactory {
//	private static final String CHROME = "chrome";
//	private static final String MICROSOFTEDGE = "MicrosoftEdge";
//	private static final String FIREFOX = "firefox";
	
	public WebDriverFactory() {
	}
	
	public static WebDriver getWebDriverInstance(String browserName) throws MalformedURLException {
		WebDriver webDriver = null;
		
		if(browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
//			WebDriverManager.chromedriver().setup();
//			webDriver = new ChromeDriver();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setPlatform(Platform.ANY);
			capabilities.setBrowserName("chrome");
			
			ChromeOptions options = new ChromeOptions();
			options.merge(capabilities);
			webDriver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
			
			
		} else if(browserName.equals("MicrosoftEdge")) {
//			System.setProperty("webdriver.edge.driver", "lib/edgedriver.exe");
//			WebDriverManager.edgedriver().setup();
//			webDriver = new EdgeDriver();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setPlatform(Platform.ANY);
			capabilities.setBrowserName("MicrosoftEdge");
			
			EdgeOptions options = new EdgeOptions();
			options.merge(capabilities);
			webDriver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);

			
		} else if(browserName.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
//			WebDriverManager.firefoxdriver().setup();
//			webDriver = new FirefoxDriver();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setPlatform(Platform.ANY);
			capabilities.setBrowserName("firefox");
			
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capabilities);
			webDriver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
			
		}
		return webDriver;
	}
}


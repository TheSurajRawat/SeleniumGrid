package com.digitalacademy.testpage;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.digitalacademy.browser.GetBrowser;
import com.digitalacademy.browser.WebDriverFactory;
import com.digitalacademy.page.AboutPage;
import com.digitalacademy.page.BlogPage;
import com.digitalacademy.page.HomePage;
import org.testng.Assert;

public class TestScenarioPage {
	
	private static WebDriver webDriver = null;
	private static HomePage homePage = null;
	private static BlogPage blogPage = null;
	private static AboutPage aboutPage = null;
	
	@Parameters({"browserName"})
	@BeforeClass
	public static void launch(String browserName) throws MalformedURLException {
		
		webDriver = WebDriverFactory.getWebDriverInstance(browserName);
		webDriver.navigate().to(GetBrowser.getUrl());
		webDriver.manage().window().maximize();		
		
		homePage = new HomePage(webDriver);
		blogPage = new BlogPage(webDriver);
		aboutPage = new AboutPage(webDriver);
	}
	
		
	@Test (priority = 1)
	public void verifyHomepage() {
		String expectedTitle = "David Burns - AutomatedTester";
		String actualTitle = homePage.getTitle(webDriver);
		
		Assert.assertEquals(actualTitle, expectedTitle,"Page is not available");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test (priority = 2)
	public void verifyBlogPage() {
		homePage.goToBlogPage();
		String expectedUrl = "https://www.theautomatedtester.co.uk/blog/";
		String actualUrl = blogPage.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl,"Page is not available");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test (priority = 3)
	public void verifyBlogPageHeading() {
		String expectedHeading = "Blogs";
		String actualHeading = blogPage.getPageHeading();
		
		Assert.assertEquals(actualHeading, expectedHeading,"Heading is not matched as expected");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test (priority = 4)
	public void verifyAboutPage() {
		homePage.goToAboutPage();
		String expectedUrl = "https://www.theautomatedtester.co.uk/about/";
		String actualUrl = aboutPage.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl,"Page is not available");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void windUp() {
		webDriver.close();
		webDriver.quit();
	}

}

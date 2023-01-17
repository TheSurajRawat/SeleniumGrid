package com.digitalacademy.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {
	
private WebDriver webDriver = null;

	@FindBy(xpath = "//a[text()='Blogs']")
	private WebElement pageHeading;
		
	public BlogPage() {
	}
	
	public BlogPage(WebDriver webDriver) {
		this.webDriver = webDriver;		
		PageFactory.initElements(webDriver, this);
	}
	
	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public String getPageHeading() {
		return pageHeading.getText().trim();
	}
	
	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}
	
	public void quitPage() {
		webDriver.quit();
	}
	
}

package com.digitalacademy.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	
private WebDriver webDriver = null;

    @FindBy(xpath = "/html/body/main/nav/section/a")
    private WebElement homepageHeading;
    
    @FindBy(xpath = "//a[text()='Blog']")
    private WebElement blogLink;
    
    @FindBy(xpath = "//a[text()='About']")
    private WebElement aboutLink;
    
	
	public HomePage() {
	}
	
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		
		PageFactory.initElements(webDriver, this);
	}
	
	public String getTitle(WebDriver webDriver) {
		this.webDriver = webDriver;
		return webDriver.getTitle();
	}
	
	public String getHomePageHeading() {
		return homepageHeading.getText().trim();
	}
	
		
	public void quitPage() {
		webDriver.quit();
	}
	
	public void goToBlogPage() {
	try {
			blogLink.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public void goToAboutPage() {
		try {
				aboutLink.click();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}

}

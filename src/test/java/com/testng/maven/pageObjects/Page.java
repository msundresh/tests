package com.testng.maven.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Page {
	
	protected WebDriver driver;

	protected Wait<WebDriver> fluentWait;
	protected final int WAIT_TIME = 30;
	protected final int POLL_TIME = 1;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		fluentWait = new FluentWait<WebDriver>(driver)
		 		   .withTimeout(Duration.ofSeconds(WAIT_TIME))
				   .pollingEvery(Duration.ofSeconds(POLL_TIME));
	}
}

package com.testng.maven.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Fixtures {
	
	public String baseURL = "apps//index.html";
	public WebDriver driver;
	
    @BeforeMethod
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	Path sampleFile = Paths.get(baseURL);
    	
    	driver.get(sampleFile.toUri().toString()); //Navigate to Application
    }
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
   
}

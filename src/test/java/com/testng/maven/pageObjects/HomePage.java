package com.testng.maven.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Page {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='inputEmail']")
	private WebElement emailAddressElement;

	@FindBy(xpath = "//input[@id='inputPassword']")
	private WebElement passwordElement;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signInElement;
	
	@FindBy(xpath = "//button[@id='dropdownMenuButton']")
	private WebElement dropdownButton;
	
	@FindBy(xpath = "//div[@aria-labelledby='dropdownMenuButton']")
	private WebElement dropdownMenu;
	
	@FindBy(xpath = "//div[@id='test-4-div']/button")
	private List<WebElement> allTest4Buttons; 
	
	@FindBy(xpath = "//ul[@class='list-group']/li")
	private List<WebElement> listGroupItems;
	
	@FindBy(xpath = "//div[@id='test5-alert']")
	private WebElement test5Alert;
	
	@FindBy(xpath = "//*[@id='test-5-div']/button")
	private WebElement alertButton;
	
	private String test5ButtonXpath = "//*[@id='test-5-div']/button";
	
	private String tableCellXpath = "//table/tbody/tr[%s]/td[%s]";
	
	private String optionValueXpath = "//a[text()='%s']";
	
	private WebElement getElementFor(String xpathString) {
		return driver.findElement(By.xpath(xpathString));
	}
	
	public WebElement getEmailAddressElement() {
		return emailAddressElement;
	}

	public WebElement getPasswordElement() {
		return passwordElement;
	}

	public WebElement getSignInElement() {
		return signInElement;
	}

	public List<WebElement> getAllListGroupItems() {
		return listGroupItems;
	}

	public WebElement getGroupItemBadge(int number) {
		return listGroupItems.get(number-1).findElement(By.tagName("span"));
	}

	public WebElement getListGroupItem(int number) {
		return listGroupItems.get(number-1);
	}

	public WebElement getDropDownButton() {
		return dropdownButton;
	}

	public WebElement getDropDownMenuFor(String option) {
		String optionXpath = String.format(optionValueXpath, option);
		return dropdownMenu.findElement(By.xpath(optionXpath));
	}

	public WebElement getButtonNumber(int number) {
		return allTest4Buttons.get(number-1);
	}

	public WebElement waitForButton() {
		return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(test5ButtonXpath)));
	}

	public WebElement getTest5Alert() {
		return test5Alert;
	}

	public WebElement getAlertButton() {
		return alertButton;
	}

	public String getTableCellValue(Integer x, Integer y) {
		x=x+1; //incrementing x by 1 as web-table values start from 1
		y=y+1; //incrementing y by 1 as web-table values start from 1
		
		String cellXpath = String.format(tableCellXpath, x.toString(), y.toString());
		String cellValue = getElementFor(cellXpath).getText();
		return cellValue;
	}

}

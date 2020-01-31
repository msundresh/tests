//Author: Sundresh Chettiar
//Date: 30-01-2020
//Chrome Version: 79
//TestNG eclipse: 6.14
//To run: mvn test
//Reports: target/surefire-reports
package com.testng.maven.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testng.maven.pageObjects.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class AppTest extends Fixtures{
	

    @Test(dataProvider = "Test1Data")
	public void test1(String emailId, String password) {
    	
    	//Assert that both the email address and password inputs are present as well as the login button  	
		HomePage homePage = new HomePage(driver);
    	assertTrue(homePage.getEmailAddressElement().isDisplayed(), "email address input validation failed");
    	assertTrue(homePage.getPasswordElement().isDisplayed(), "password input validation failed");
    	assertTrue(homePage.getSignInElement().isDisplayed(), "signin validation failed");
    	
    	//Enter in an email address and password combination into the respective fields
    	homePage.getEmailAddressElement().sendKeys(emailId);
    	homePage.getPasswordElement().sendKeys(password);
    }   
    @DataProvider(name = "Test1Data")
    public Object[][] test1Dataprovider(){
    return new Object[][] 
    	{
            { "admin@gmail.com", "Password" }
        };
    }
    
    
    @Test(dataProvider = "Test2Data")
    public void test2(String expectedOption, String expectedBadgeValue) {
    	
    	//In the test 2 div, assert that there are three values in the listgroup	
		HomePage homePage = new HomePage(driver);
    	assertEquals(homePage.getAllListGroupItems().size(), 3, "listgroup values validation failed");
    	
    	//Assert that the second list item's value is set to "List Item 2"
    	String observedValue = homePage.getListGroupItem(2).getText().trim();
    	assertTrue(observedValue.contains(expectedOption), "list item's validation failed");
    
    	//Assert that the second list item's badge value is 6
    	String observedBadgeValue = homePage.getGroupItemBadge(2).getText().trim();
    	assertEquals(observedBadgeValue, expectedBadgeValue, "badge value validation failed");
    }    
    @DataProvider(name="Test2Data")
    public Object[][] test2Dataprovider(){
    return new Object[][] 
    	{
            {"List Item 2",   //expected option text
            	"6"}          //expected badge value
        };
    }


	@Test(dataProvider = "Test3Data")
    public void test3(String expectedDefaultValue, String option) {	
		
    	//In the test 3 div, assert that "Option 1" is the default selected value
		HomePage homePage = new HomePage(driver);
    	assertEquals(homePage.getDropDownButton().getText().trim(), expectedDefaultValue, "default value validation failed");
    	
    	//Select "Option 3" from the select list
    	homePage.getDropDownButton().click();
    	homePage.getDropDownMenuFor(option).click();
    }	
    @DataProvider(name="Test3Data")
    public Object[][] test3Dataprovider(){
    return new Object[][] 
    	{
            {"Option 1",  //expected default seleted Value
            "Option 3"}   //select option from dropdown menu
        };
    }
    
    
    @Test
    public void test4() {
    	//In the test 4 div, assert that the first button is enabled and that the second button is disabled
		HomePage homePage = new HomePage(driver);
    	assertTrue(homePage.getButtonNumber(1).isEnabled(), "first button enabled validation failed");
    	assertFalse(homePage.getButtonNumber(2).isEnabled(), "second button disabled validation failed");
    }
    
    
    @Test(dataProvider = "Test5Data")
    public void test5(String expectedMessage) {
    	//In the test 5 div, wait for a button to be displayed (note: the delay is random) and then click it
		HomePage homePage = new HomePage(driver);
    	homePage.waitForButton().click();

    	//Once you've clicked the button, assert that a success message is displayed
    	String observedMessage = homePage.getTest5Alert().getText().trim();
    	assertEquals(observedMessage, expectedMessage, "success message validation failed");
    	
    	//Assert that the button is now disabled
    	assertFalse(homePage.getAlertButton().isEnabled());
    }    
    @DataProvider(name="Test5Data")
    public Object[][] test5Dataprovider(){
    return new Object[][] 
    	{
            {"You clicked a button!"} //expected message
        };
    }
    
    
    @Test(dataProvider = "Test6Data")
    public void test6(int x, int y, String expectedValue) {
    	
		//Write a method that allows you to find the value of any cell on the grid
	    //Use the method to find the value of the cell at coordinates 2, 2 (staring at 0 in the top left corner)
		HomePage homePage = new HomePage(driver);
		String cellValue = homePage.getTableCellValue(2, 2);

    	//Assert that the value of the cell is "Ventosanzap"
    	assertEquals(cellValue, expectedValue);
    }
    @DataProvider(name="Test6Data")
    public Object[][] test6Dataprovider(){
    return new Object[][] 
    	{
    		{2, 2,         //cell coordinates 
    		"Ventosanzap"} //expected cell Value
        };
    }
}

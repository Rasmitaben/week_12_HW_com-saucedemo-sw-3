package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    /* 1. userShouldLoginSuccessfullyWithValidCredential
     * Enter “standard_user” username
     * Enter “secret_sauce” password
     * Click on ‘LOGIN’ button
     * Verify the text “PRODUCTS”*/
    @Test
    //* Enter “standard_user” username
    public void  userShouldLoginSuccessfullyWithValidCredential (){
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");

        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");

        // Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        //Verify the text “products”
        String expectedMessage = "Products";
        String actualMessage = getTextFromElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }
    /*2. verifyThatSixProductsAreDisplayedOnPage
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify that six products are displayed on page*/

    @Test
    public void  verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");

        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");

        // Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        //Verify that six products are displayed on page
        List<WebElement> labelsListOfWebElements = driver.findElements(By.xpath("//div[@class='inventory_list']//div//div//div[@class='inventory_item_name']"));
        System.out.println(labelsListOfWebElements);

        ArrayList<String> list = new ArrayList<>();

        for (WebElement element : labelsListOfWebElements) {
            System.out.println(element.getText());
            list.add(element.getText());
        }

        System.out.println(list);

        //Actual
        int actual = list.size();
        System.out.println("Actual: " + actual);
        String actual1 = Integer.toString(actual);

        //Expect
        int expected = 6;
        String expected1 = Integer.toString(expected);

        //Assert
        Assert.assertEquals("Number of items are not matching", expected1, actual1);
    }

    @After
    public void tearDown(){
        //close the scanner
        driver.close();
    }


    }



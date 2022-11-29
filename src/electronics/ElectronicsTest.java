package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openWebBrowser(baseUrl);

    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //  1.1 Mouse Hover on “Electronics”Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        //   1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //  1.3 Verify the text “Cell phones”
        String expText = "Cell phones";
        String actText = getTextElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals(expText, actText);

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //  2.1 Mouse Hover on “Electronics”Tab
        Thread.sleep(1000);

        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        //   2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //  2.3 Verify the text “Cell phones”
        String expText = "Cell phones";
        String actText = getTextElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals(expText, actText);
        //  2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        mouseHoverToElementAndClick(By.linkText("Nokia Lumia 1020"));


        //  2.6 Verify the text “Nokia Lumia 1020”
        String expText1 = "Nokia Lumia 1020";
        String actText1 = getTextElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals(expText1, actText1);
        //  2.7 Verify the price “$349.00”
        String expText2 = "$349.00";
        String actText2 = getTextElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals(expText2, actText2);
        //   2.8 Change quantity to 2
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextOnElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        //  2.9 Click on “ADD TO CART” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green bar
        //After that close the bar clicking on the cross button
        String expText3 = "The product has been added to your shopping cart";
        String actText3 = getTextElement(By.xpath("//body/div[@id='bar-notification']/div[1]"));
        Assert.assertEquals(expText3, actText3);

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'shopping cart')]"));
        // 2.12 Verify the message "Shopping cart"
        String expText4 = "Shopping cart";
        String actText4 = getTextElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expText4, actText4);
        // 2.13 Verify the quantity is 2
        WebElement text = driver.findElement(By.xpath("//input[@class='qty-input']"));
        String expText5 = "2";
        String actText5 = text.getAttribute("value");
        Assert.assertEquals(expText3, actText3);
        //  2.14 Verify the Total $698.00
        String expText6 = "$698.00";
        String actText6 = getTextElement(By.xpath("//tr[@class='order-total']/td[2]/span"));
        Assert.assertEquals(expText6, actText6);
        Thread.sleep(1000);

        // 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);
        //  2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.17 Verify the Text “Welcome, Please Sign In!”
        String expText7 = "Welcome, Please Sign In!";
        String actText7 = getTextElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expText7, actText7);

        //   2.18 Click on “REGISTER” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //   2.19 Verify the text “Register”
        String expText8 = "REGISTER";
        String actText8 = getTextElement(By.xpath("//button[contains(text(),'Register')]"));
        Assert.assertEquals(expText8, actText8);
        //2.20 Fill the mandatory fields
        //first name
        Thread.sleep(1000);
        sendTextOnElement(By.xpath("//input[@id='FirstName']"), "jenna");
        sendTextOnElement(By.xpath("//input[@id='LastName']"), "smith");
        sendTextOnElement(By.xpath("//input[@id='Email']"), "jenna.smith0511@gmail.com");
        sendTextOnElement(By.xpath("//input[@id='Password']"), "jensmith123");
        sendTextOnElement(By.xpath("//input[@id='ConfirmPassword']"), "jensmith123");
        // 2.21 Click on “REGISTER” Button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        String expText9 = "Your registration completed";
        String actText9 = getTextElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals(expText9, actText9);
        //  2.23 Click on “CONTINUE” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //   2.24 Verify the text “Shopping cart”
        Thread.sleep(1000);
        String expText10 = "Shopping cart";
        String actText10 = getTextElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expText10, actText10);
        // 2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //  2.26 Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //   2.27 Fill the Mandatory fields
        Thread.sleep(1000);

        //country
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
        //select state
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Alaska");


        //enter city
        sendTextOnElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Naple");
        //address
        sendTextOnElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "1234 cordin view");
        //postal code
        sendTextOnElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "12376");
        //phone no
        sendTextOnElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "569847555");

        //   2.28 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        Thread.sleep(1000);
        //   2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //   2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        Thread.sleep(1000);
        //  2.32 Select “Visa” From Select credit card dropdow
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");
        //   2.33 Fill all the details

        sendTextOnElement(By.xpath("//input[@id='CardholderName']"), "jhsmith");

        sendTextOnElement(By.xpath("//input[@id='CardNumber']"), "4111111111111111");
        //month and year
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "01");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextOnElement(By.xpath("//input[@id='CardCode']"), "123");
        Thread.sleep(1000);

        //  2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //    2.35 Verify “Payment Method” is “Credit Card”
        // 2.30 Verify “Payment Method” is “Credit Card”
        String expText11 = "Credit Card";
        String actText11 = getTextElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals(expText11, actText11);
        //   2.36 Verify “Shipping Method” is “2nd Day Air”
        String expText12 = "2nd Day Air";
        String actText12 = getTextElement(By.xpath("//div[@class='order-summary-content']/div/div[2]/div[2]/ul/li/span[2]"));
        Assert.assertEquals(expText12, actText12);
        //  2.37 Verify Total is “$698.00”
        String expText13 = "$698.00";
        String actText13 = getTextElement(By.xpath("//tr[@class='order-total']/td[2]/span"));
        Assert.assertEquals(expText13, actText13);
        //  2.38 Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //   2.39 Verify the Text “Thank You”
        String expText14 = "Thank you";
        String actText14 = getTextElement(By.xpath("//h1[text()='Thank you']"));
        Assert.assertEquals(expText14, actText14);
        //   2.40 Verify the message “Your order has been successfully processed!”
        String expText15 = "Your order has been successfully processed!";
        String actText15 = getTextElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals(expText15, actText15);
        //   2.41 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //  2.42 Verify the text “Welcome to our store
        String expText16 = "Welcome to our store";
        String actText16 = getTextElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals(expText16, actText16);


        //   2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //verify url
        String expText17 = "https://demo.nopcommerce.com/";
        String actText17 = driver.getCurrentUrl();
        Assert.assertEquals(expText16, actText16);


    }
    @After
    public void closeTab(){
        closeBrowser();}

}

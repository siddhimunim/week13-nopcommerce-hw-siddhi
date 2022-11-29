package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuits extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openWebBrowser(baseUrl);

    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        Thread.sleep(1000);
        //click on computer
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //click on desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //select sort position z-a
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");



    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Thread.sleep(1000);
        //click on computer
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //click on desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //sort by a to z
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        Thread.sleep(1000);
        //click on add to cart
        mouseHoverToElementAndClick(By.xpath("//div[@data-productid='1']/div[2]/div[3]/div[2]/button[1]"));


        // 2.5 Verify the Text "Build your own computer
        String expText1 = "Build your own computer";
        String actText1 = getTextElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals(expText1, actText1);
        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //   2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        //   2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //   2.9 Select OS radio "Vista Premium [+$60.00]"

        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //2.10
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));


        // 2.11 Verify the price "$1,475.00"
        String expText2 = "$1,475.00";
        String actText2 = getTextElement(By.xpath("//span[text()='$1,475.00']"));
        Assert.assertEquals(expText2, actText2);

        //     2.12 Click on "ADD TO CARD" Button.
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 verify message
         /*  String expText3 ="The product has been added to your shopping cart";
           String actText3= getTextElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
           Assert.assertEquals(expText3,actText3);*//////
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        // mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        // 2.15 Verify the message "Shopping cart"
        String expText4 = "Shopping cart";
        String actText4 = getTextElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expText4, actText4);

        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@class='quantity']/input")).clear();
        sendTextOnElement(By.xpath("//td[@class='quantity']/input"), "2");
        //update shopping cart
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //  2.17 Verify the Total"$2,950.00
        String expText5 = "$2,950.00";
        String actText5 = getTextElement(By.xpath("//tr[@class='order-total']/td[2]/span/strong"));
        Assert.assertEquals(expText4, actText4);
        //   2.18 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //   2.19 Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //  2.20 Verify the Text “Welcome, Please Sign In!”
        String expText6 = "Welcome, Please Sign In!";
        String actText6 = getTextElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expText6, actText6);

        //   2.21Click on “CHECKOUT AS GUEST”Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //   2.22 Fill the all mandatory field
        //first name
        sendTextOnElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Jenna");
        //last name
        sendTextOnElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Lammas");
        //email
        sendTextOnElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "jlammas1204@gmail.com");
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
        Thread.sleep(1000);
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //   2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        Thread.sleep(1000);
        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //   2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        Thread.sleep(1000);

        //  2.27 Select “Master card” From Select credit card dropdow
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        //    2.28 Fill all the details
        sendTextOnElement(By.xpath("//input[@id='CardholderName']"), "j.m.lammas");
        sendTextOnElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        //month and year
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "01");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextOnElement(By.xpath("//input[@id='CardCode']"), "123");
        Thread.sleep(1000);

        // 2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        // 2.30 Verify “Payment Method” is “Credit Card”
        String expText7 = "Credit Card";
        String actText7 = getTextElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals(expText7, actText7);
        Thread.sleep(1000);

        // 2.32 Verify “Shipping Method” is “Next Day Air”
        String expText8 = "Next Day Air";
        String actText8 = getTextElement(By.xpath("//div[@class='order-summary-content']/div/div[2]/div[2]/ul/li/span[2]"));
        Assert.assertEquals(expText8, actText8);
        Thread.sleep(1000);
        //  2.33 Verify Total is “$2,920.00”
        String expText9 = "$2,950.00";
        String actText9 = getTextElement(By.xpath("//tr[@class='order-total']/td[2]/span"));
        Assert.assertEquals(expText9, actText9);
        Thread.sleep(1000);

        //  2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //  2.35 Verify the Text “Thank You”
        String expText10 = "Thank you";
        String actText10 = getTextElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals(expText10, actText10);
        Thread.sleep(1000);
        // 2.36 Verify the message “Your order has been successfully processed!”
        String expText11 = "Your order has been successfully processed!";
        String actText11 = getTextElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals(expText11, actText11);
        Thread.sleep(1000);
        //  2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //  2.37 Verify the text “Welcome to our store
        String expText12 = "Welcome to our store";
        String actText12 = getTextElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals(expText12, actText12);


    }
    @After
    public void closeTab(){
        closeBrowser();}


    }

package homepage;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.Scanner;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openWebBrowser(baseUrl);

    }


    public static void selectMenu(String menu) {
        List<WebElement> myProductList = driver.findElements(By.xpath("//div[@class = 'header-menu']/ul/li"));
        try {
            for (WebElement option1 : myProductList) {
                System.out.println(option1.getText());
                if (option1.getText().equals(menu)) {
                    option1.click();
                    break;
                }
            }

        } catch (StaleElementReferenceException e) {
            myProductList = driver.findElements(By.xpath("//div[@class = 'header-menu']/ul/li"));
        }

    }

    @Test
    public void verifyPageNevigation() throws InterruptedException {
        Thread.sleep(1000);
        selectMenu("Books");
        String expPage = "Books";

        String actualPage = getTextElement(By.xpath("//h1[contains(text(),'Books')]"));
        Assert.assertEquals(expPage,actualPage);

    }

    @After
    public void closeTab(){
        closeBrowser();}



}

package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class TC_12 extends TestBase {
    //Launch browser
    @Test
    public void test01() {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //1-Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //2-Verify that home page is visible successfully
        String expectedHomePageUrl = "https://automationexercise.com/";
        String actualHomePageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedHomePageUrl,actualHomePageUrl);
        //3-Click 'Products' button
        WebElement productsButton = driver.findElement(By.xpath("//*[@href='/products']"));
        productsButton.click();
        //4-Hover over first product and click 'Add to cart'
        WebElement firstProduct = driver.findElement(By.xpath("//*[@src='/get_product_picture/1']"));
        actions.moveToElement(firstProduct).perform();
        WebElement addToCartFirstProduct = driver.findElement(By.xpath("(//*[@data-product-id='1'])[2]"));
        addToCartFirstProduct.click();
        //5-Click 'Continue Shopping' button
        WebElement continueShoppingButton = driver.findElement(By.xpath("//*[text()='Continue Shopping']"));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
        //6-Hover over second product and click 'Add to cart'
        WebElement secondProduct = driver.findElement(By.xpath("//*[@src='/get_product_picture/2']"));
        actions.moveToElement(secondProduct).perform();
        WebElement addToCartSecondProduct = driver.findElement(By.xpath("(//*[@data-product-id='2'])[2]"));
        addToCartSecondProduct.click();
        //7-Click 'View Cart' button
        WebElement viewCartButton = driver.findElement(By.xpath("Click 'View Cart' button"));
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        viewCartButton.click();
    }
}

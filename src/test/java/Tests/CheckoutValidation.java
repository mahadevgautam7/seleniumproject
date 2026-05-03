package Tests;

import Pages.LoginPage;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class CheckoutValidation extends BaseClass {
    public void checkOutTest(){
        LoginPage lpg = new LoginPage(driver);
        lpg.enterUserName("standard_user");
        lpg.enterPassword("secret_sauce");
        lpg.clickOnLoginButton();
        List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        int items = 2;
        for(int i = 1; i<=items; i++){
            addToCart.get(i).click();
        }
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Miraj");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Gautam");
        WebElement zipCode = driver.findElement(By.id("postal-code"));
        zipCode.sendKeys("3360");
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
        WebElement thankYouPage = driver.findElement(By.id("checkout_complete_container"));
        Assert.assertTrue(thankYouPage.isDisplayed(),"Order Unsuccessful");
    }
}

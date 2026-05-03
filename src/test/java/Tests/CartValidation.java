package Tests;

import Pages.LoginPage;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartValidation extends BaseClass {
    @Test
        public void cartTest(){
            LoginPage lpg = new LoginPage(driver);
            lpg.enterUserName("standard_user");
            lpg.enterPassword("secret_sauce");
            lpg.clickOnLoginButton();
            List <WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']"));
            int items = 3;
            for(int i = 1; i<=items; i++){
                addToCart.get(i).click();
            }
            driver.findElement(By.className("shopping_cart_link")).click();
            List<WebElement> cartItems = driver.findElements(By.className("inventory_item_name"));
            int sizeOfCart = cartItems.size();
            Assert.assertEquals(sizeOfCart,items,"Items are not added to cart in correct way");
        }
}

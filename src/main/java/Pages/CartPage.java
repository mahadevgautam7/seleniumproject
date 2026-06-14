package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    private By cartItems =
            By.className("inventory_item_name");

    private By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public int getCartItemCount(){
        return driver.findElements(cartItems).size();
    }

    public void clickCheckout(){
        driver.findElement(checkoutButton).click();
    }
}
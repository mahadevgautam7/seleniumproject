package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    WebDriver driver;

    private By completeContainer = By.id("checkout_complete_container");

    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isCheckoutSuccessful(){
        return driver.findElement(completeContainer)
                .isDisplayed();
    }
}
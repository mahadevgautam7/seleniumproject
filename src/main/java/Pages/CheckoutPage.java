package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    private By firstName =
            By.id("first-name");

    private By lastName =
            By.id("last-name");

    private By postalCode =
            By.id("postal-code");

    private By continueButton =
            By.id("continue");

    private By finishButton =
            By.id("finish");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterDetails(
            String fname,
            String lname,
            String zip){

        driver.findElement(firstName)
                .sendKeys(fname);

        driver.findElement(lastName)
                .sendKeys(lname);

        driver.findElement(postalCode)
                .sendKeys(zip);
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

    public void clickFinish(){
        driver.findElement(finishButton).click();
    }
}
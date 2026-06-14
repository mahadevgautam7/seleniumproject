package Tests;

import Pages.LoginPage;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidation extends BaseClass {
    @Test
        public void errorMessageTest(){
           LoginPage lpg = new LoginPage(driver);
           lpg.login("invalid_user","secret_sauce");
        Assert.assertTrue(
                lpg.isErrorDisplayed(),
                "Error message is not displayed"
        );
        }
}

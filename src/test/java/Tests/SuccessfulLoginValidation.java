package Tests;

import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLoginValidation extends BaseClass {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                inventoryPage.isInventoryDisplayed(),
                "Not Logged In Yet"
        );
    }
}

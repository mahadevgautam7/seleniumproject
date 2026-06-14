package Tests;

import Pages.CartPage;
import Pages.CheckoutCompletePage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutValidation extends BaseClass {

    @Test
    public void checkOutTest() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutCompletePage completePage =
                new CheckoutCompletePage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        inventoryPage.addItemsToCart(2);

        inventoryPage.openCart();

        cartPage.clickCheckout();

        checkoutPage.enterDetails(
                "Miraj",
                "Gautam",
                "3360"
        );

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        Assert.assertTrue(
                completePage.isCheckoutSuccessful(),
                "Order Unsuccessful"
        );
    }
}
package Tests;

import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartValidation extends BaseClass {

    @Test
    public void cartTest() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        int items = 3;

        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addItemsToCart(items);

        inventoryPage.openCart();

        Assert.assertEquals(cartPage.getCartItemCount(), items, "Items are not added to cart correctly");
    }
}
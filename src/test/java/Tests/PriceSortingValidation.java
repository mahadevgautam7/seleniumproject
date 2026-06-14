package Tests;

import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriceSortingValidation extends BaseClass {

    @Test
    public void priceFilterTest() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.selectFilter("lohi");

        List<Double> actualPrices = inventoryPage.getProductPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);

        Collections.sort(expectedPrices);

        Assert.assertEquals(actualPrices, expectedPrices, "Price Sorting Low-High Failed");
    }
}
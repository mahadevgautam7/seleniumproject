package Tests;

import Pages.InventoryPage;
import Pages.LoginPage;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DescendingOrderValidation extends BaseClass {

    @Test
    public void descendingOrderTest() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.selectFilter("za");

        List<String> actualNames = inventoryPage.getProductNames();

        List<String> expectedNames = new ArrayList<>(actualNames);
        expectedNames.sort(Collections.reverseOrder());

        Assert.assertEquals(
                actualNames,
                expectedNames,
                "Descending Filter for Name Failed"
        );
    }
}
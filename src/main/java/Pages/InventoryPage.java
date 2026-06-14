package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {

    WebDriver driver;

    private By addToCartButtons = By.xpath("//button[text()='Add to cart']");

    private By cartButton = By.className("shopping_cart_link");

    private By inventoryContainer = By.id("inventory_container");

    private By productNames = By.className("inventory_item_name");

    private By productPrices = By.className("inventory_item_price");

    private By sortDropdown = By.className("product_sort_container");

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isInventoryDisplayed(){
        return driver.findElement(inventoryContainer)
                .isDisplayed();
    }

    public void addItemsToCart(int count){
        List<WebElement> items =
                driver.findElements(addToCartButtons);

        for(int i=0;i<count;i++){
            items.get(i).click();
        }
    }

    public void openCart(){
        driver.findElement(cartButton).click();
    }

    public void selectFilter(String value){
        Select select =
                new Select(driver.findElement(sortDropdown));

        select.selectByValue(value);
    }

    public List<String> getProductNames(){

        List<String> names = new ArrayList<>();

        for(WebElement element :
                driver.findElements(productNames)){

            names.add(element.getText());
        }

        return names;
    }

    public List<Double> getProductPrices(){

        List<Double> prices = new ArrayList<>();

        for(WebElement price :
                driver.findElements(productPrices)){

            prices.add(
                    Double.parseDouble(
                            price.getText().replace("$","")
                    )
            );
        }

        return prices;
    }
}
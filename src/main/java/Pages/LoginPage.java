package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class LoginPage {

        private WebDriver driver;

        private By userNameField = By.id("user-name");
        private By passwordField = By.id("password");
        private By loginButton = By.id("login-button");
        private By errorMessage = By.cssSelector("h3[data-test='error']");

        public LoginPage(WebDriver driver){
            this.driver = driver;
        }

        public void login(String username,String password){
            driver.findElement(userNameField).sendKeys(username);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(loginButton).click();
        }

        public boolean isErrorDisplayed(){
            return driver.findElement(errorMessage).isDisplayed();
        }
    }

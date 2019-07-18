package nopcommerce.pages;

import nopcommerce.modules.RightTop;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLogin(){
        driver.findElement(rightTop.loginBtn).click();
        return new LoginPage(driver);
    }
}

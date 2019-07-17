package nopcommerce.pages;

import nopcommerce.modules.RightTop;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLogin(){
        driver.findElement(rightTop.loginBtn).click();
    }
}

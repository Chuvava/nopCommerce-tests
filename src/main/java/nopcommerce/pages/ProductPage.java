package nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By h1 = By.tagName("h1");
    public By shortDescription = By.className("short-description");

    public String getProductName(){
        return driver.findElement(h1).getText();
    }
}

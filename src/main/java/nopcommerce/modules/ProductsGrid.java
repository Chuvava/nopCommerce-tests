package nopcommerce.modules;

import nopcommerce.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsGrid extends BaseModule {

    public ProductsGrid(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickOnProductByExactName(String exactProductName) {
        By genericXpath = By.xpath(String.format("//div[@class='item-box']//a[text()='%s']", exactProductName));
        driver.findElement(genericXpath).click();
        return new ProductPage(driver);
    }

    public boolean isProductPresentInGrid(String exactProductName){
        By genericXpath = By.xpath(String.format("//div[@class='item-box']//a[text()='%s']", exactProductName));
        int count = driver.findElements(genericXpath).size();
        return count == 1;
    }
}

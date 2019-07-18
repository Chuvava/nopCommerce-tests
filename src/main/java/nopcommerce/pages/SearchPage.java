package nopcommerce.pages;

import nopcommerce.modules.ProductsGrid;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
        productsGrid = new ProductsGrid(driver);
    }

    public ProductsGrid productsGrid;
}

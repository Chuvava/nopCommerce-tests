package nopcommerce.modules;

import nopcommerce.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BaseModule {

    public SearchBox(WebDriver driver) {
        super(driver);
    }
    private By searchTextBox = By.id("small-searchterms");
    private By searchBtn = By.xpath("//form/input[@value='Search']");


    public SearchPage typeValueIntoSearchFieldAndClickOnSearch(String productName) {
        driver.findElement(searchTextBox).sendKeys(productName);
        driver.findElement(searchBtn).click();

        return new SearchPage(driver);
    }
}

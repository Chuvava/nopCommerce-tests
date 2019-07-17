package nopcommerce.pages;

import nopcommerce.modules.RightTop;
import nopcommerce.modules.TopCategoryMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BasePage {

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.rightTop = new RightTop();
        this.topCategoryMenu = new TopCategoryMenu();
    }

    public RightTop rightTop;
    public WebDriver driver;
    public TopCategoryMenu topCategoryMenu;

    public void clickOn(By locator){

        driver.findElement(locator).click();
    }

    public void selectCurrency(String currency){
        Select currencyDropdown = new Select(driver.findElement(By.id("customerCurrency")));
        switch (currency.toUpperCase()){
            case "USD":
                currencyDropdown.selectByVisibleText("US Dollar");
                break;
            case "EUR":
                currencyDropdown.selectByVisibleText("Euro");
                break;
        }
    }

    public boolean arePricesDisplayedInCurrency(String currency){
        List<WebElement> allPrices = driver.findElements(By.cssSelector(".actual-price"));
        List<String> allPricesText = allPrices.stream().map(WebElement::getText).collect(Collectors.toList());
        boolean result = allPricesText.stream().allMatch(price -> price.startsWith(currency));
        return result;
    }
}

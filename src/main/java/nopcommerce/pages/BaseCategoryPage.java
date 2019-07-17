package nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BaseCategoryPage extends BasePage {

    private By breadcrumbItem = By.className("current-item");
    private By categoryTitle = By.tagName("h1");

    public BaseCategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getBreadcrumbItem(){
        String actualBreadCrumbItem = driver.findElement(breadcrumbItem).getText();
        return actualBreadCrumbItem;
    }

    public String getCategoryTitle(){
        String actualCategoryTitle = driver.findElement(categoryTitle).getText();
        return actualCategoryTitle;
    }

    public List<String> getExpandedSubCategoriesFromLeftMenu(){
        List<WebElement> subCategories = driver.findElements(By.xpath("//ul[@class='sublist']//a"));
        List<String> subCategoryNames = subCategories.stream().map(WebElement::getText).collect(Collectors.toList());
        return subCategoryNames;
    }

    public List<String> getSubCategoryNamesFromGrid(){
        List<WebElement> subCategories = driver.findElements(By.xpath("//div[@class='sub-category-item']/h2[@class='title']/a"));
        List<String> subCategoryNames = subCategories.stream().map(WebElement::getText).collect(Collectors.toList());
        return subCategoryNames;
    }
}

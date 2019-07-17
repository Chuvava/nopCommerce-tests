import nopcommerce.BaseTest;
import nopcommerce.pages.BaseCategoryPage;
import nopcommerce.pages.MainPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckMainCategories extends BaseTest {

    private String expectedCategory;
    private List<String> expectedSubProducts;

    @Test
    public void computersPageShouldOpenCorrectly(){

        expectedCategory = "Computers";
        expectedSubProducts = Arrays.asList("Desktops", "Notebooks", "Software");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOn(mainPage.topCategoryMenu.computers);
        BaseCategoryPage computersPage = new BaseCategoryPage(driver);

        assertEquals(expectedCategory, computersPage.getBreadcrumbItem());
        assertEquals(expectedCategory, computersPage.getCategoryTitle());

        assertEquals(computersPage.getExpandedSubCategoriesFromLeftMenu(), expectedSubProducts);
        assertEquals(computersPage.getSubCategoryNamesFromGrid(), expectedSubProducts);
    }

    @Test
    public void electronicsPageShouldOpenCorrectly(){

        expectedCategory = "Electronics";
        expectedSubProducts = Arrays.asList("Camera & photo", "Cell phones", "Others");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOn(mainPage.topCategoryMenu.electronics);
        BaseCategoryPage electronicsPage = new BaseCategoryPage(driver);

        assertEquals(expectedCategory, electronicsPage.getBreadcrumbItem());
        assertEquals(expectedCategory, electronicsPage.getCategoryTitle());

        assertEquals(electronicsPage.getExpandedSubCategoriesFromLeftMenu(), expectedSubProducts);
        assertEquals(electronicsPage.getSubCategoryNamesFromGrid(), expectedSubProducts);
    }

    @Test
    public void apparelPageShouldOpenCorrectly(){

        expectedCategory = "Apparel";
        expectedSubProducts = Arrays.asList("Shoes", "Clothing", "Accessories");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOn(mainPage.topCategoryMenu.apparel);
        BaseCategoryPage apparelPage = new BaseCategoryPage(driver);

        assertEquals(expectedCategory, apparelPage.getBreadcrumbItem());
        assertEquals(expectedCategory, apparelPage.getCategoryTitle());

        assertEquals(apparelPage.getExpandedSubCategoriesFromLeftMenu(), expectedSubProducts);
        assertEquals(apparelPage.getSubCategoryNamesFromGrid(), expectedSubProducts);
    }

    @Test
    public void digitalDownloadsPageShouldOpenCorrectly(){

        expectedCategory = "Digital downloads";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOn(mainPage.topCategoryMenu.digitalDownloads);
        BaseCategoryPage digitalDownloadsPage = new BaseCategoryPage(driver);

        assertEquals(expectedCategory, digitalDownloadsPage.getBreadcrumbItem());
        assertEquals(expectedCategory, digitalDownloadsPage.getCategoryTitle());

        assertEquals(digitalDownloadsPage.getExpandedSubCategoriesFromLeftMenu().size(), 0);
        assertEquals(digitalDownloadsPage.getSubCategoryNamesFromGrid().size(), 0);
    }

    @Test
    public void booksPageShouldOpenCorrectly(){

        expectedCategory = "Books";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOn(mainPage.topCategoryMenu.books);
        BaseCategoryPage booksPage = new BaseCategoryPage(driver);

        assertEquals(expectedCategory, booksPage.getBreadcrumbItem());
        assertEquals(expectedCategory, booksPage.getCategoryTitle());

        assertEquals(booksPage.getExpandedSubCategoriesFromLeftMenu().size(), 0);
        assertEquals(booksPage.getSubCategoryNamesFromGrid().size(), 0);
    }

    @Test
    public void jewerlyPageShouldOpenCorrectly(){

        expectedCategory = "Jewelry";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOn(mainPage.topCategoryMenu.jewelry);
        BaseCategoryPage jewelryPage = new BaseCategoryPage(driver);

        assertEquals(expectedCategory, jewelryPage.getBreadcrumbItem());
        assertEquals(expectedCategory, jewelryPage.getCategoryTitle());

        assertEquals(jewelryPage.getExpandedSubCategoriesFromLeftMenu().size(), 0);
        assertEquals(jewelryPage.getSubCategoryNamesFromGrid().size(), 0);
    }

    @Test
    public void giftCardsPageShouldOpenCorrectly(){

        expectedCategory = "Gift Cards";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOn(mainPage.topCategoryMenu.giftCards);
        BaseCategoryPage giftCardsPage = new BaseCategoryPage(driver);

        assertEquals(expectedCategory, giftCardsPage.getBreadcrumbItem());
        assertEquals(expectedCategory, giftCardsPage.getCategoryTitle());

        assertEquals(giftCardsPage.getExpandedSubCategoriesFromLeftMenu().size(), 0);
        assertEquals(giftCardsPage.getSubCategoryNamesFromGrid().size(), 0);
    }
}

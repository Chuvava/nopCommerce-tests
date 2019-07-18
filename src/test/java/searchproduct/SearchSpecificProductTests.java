package searchproduct;

import nopcommerce.BaseTest;
import nopcommerce.pages.MainPage;
import nopcommerce.pages.ProductPage;
import nopcommerce.pages.SearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchSpecificProductTests extends BaseTest {

    @Test(dataProvider = "getData")
    public void userCanFindSpecificProductAndSeeCorrectData(String productName) {

        MainPage mainPage = new MainPage(driver);
        SearchPage searchPage = mainPage.searchBox.typeValueIntoSearchFieldAndClickOnSearch(productName);
        assertTrue(searchPage.productsGrid.isProductPresentInGrid(productName), productName + " should BE present in the products grid");
        ProductPage productPage = searchPage.productsGrid.clickOnProductByExactName(productName);
        assertEquals(productPage.getBreadcrumbItem(), productName);
        assertEquals(productPage.getProductName(), productName);
    }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[7][1];

        data[0][0] = "Build your own computer";
        data[1][0] = "Digital Storm VANQUISH 3 Custom Performance PC";
        data[2][0] = "Lenovo IdeaCentre 600 All-in-One PC";
        data[3][0] = "Nikon D5500 DSLR";
        data[4][0] = "Apple MacBook Pro 13-inch";
        data[5][0] = "Asus N551JK-XO076H Laptop";
        data[6][0] = "HP Envy 6-1180ca 15.6-Inch Sleekbook";

        return data;
    }
}

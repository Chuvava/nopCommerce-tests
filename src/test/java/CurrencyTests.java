import nopcommerce.BaseTest;
import nopcommerce.pages.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CurrencyTests extends BaseTest {

    @Test
    public void ifSelectUsDollarInUpperLeftPricesDisplayedAccordingly(){

        MainPage mainPage = new MainPage(driver);
        mainPage.selectCurrency("USD");
        assertTrue(mainPage.arePricesDisplayedInCurrency("$"), "All prices on the page should be displayed in the 'USD' format with '$' char");
    }

    @Test
    public void ifSelectEuroInUpperLeftPricesDisplayedAccordingly(){

        MainPage mainPage = new MainPage(driver);
        mainPage.selectCurrency("EUR");
        assertTrue(mainPage.arePricesDisplayedInCurrency("Ђ"), "All prices on the page should be displayed in the 'EUR' format with 'Ђ' char");
    }
}

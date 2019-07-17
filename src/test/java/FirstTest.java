import nopcommerce.BaseTest;
import nopcommerce.pages.MainPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.lang.Thread.*;

public class FirstTest extends BaseTest {

    @Test
    public void test() throws IOException, InterruptedException {

        driver = initializeDriver();
        driver.get("http://demo.nopcommerce.com/");
        MainPage mainPage = new MainPage(driver);

        mainPage.clickOnLogin();
        sleep(3000);
    }
}

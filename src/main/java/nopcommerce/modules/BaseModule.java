package nopcommerce.modules;

import org.openqa.selenium.WebDriver;

public class BaseModule {

    public BaseModule(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver;
}

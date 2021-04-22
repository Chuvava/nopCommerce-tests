package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//just comment
public class BaseTest {

    protected Configuration configuration;

    @BeforeMethod
    public void setup() throws IOException {
        configuration = new Configuration();
        driver = initializeDriver();
        openApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        String browserName = configuration.getBrowser();
//        System.out.println(prop.getProperty("browser"));

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "//chromedriver.exe");
            driver = new ChromeDriver();
        }

//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public void openApp(){
        driver.get(configuration.getBaseUrl());
    }

    public boolean isElementPresent(By locator) {
        int count = driver.findElements(locator).size();
        return count > 0;
    }


}

package nopcommerce;

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

public class BaseTest {

    @BeforeMethod
    public void setup() throws IOException {
        driver = initializeDriver();
        openApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        String root = new File("").getAbsolutePath();

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(root + "//src//main//java//nopcommerce//properties//data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");
//        System.out.println(prop.getProperty("browser"));

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", root + "//chromedriver.exe");
            driver = new ChromeDriver();
        }

//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public void openApp(){
        driver.get("http://demo.nopcommerce.com/");
    }


}

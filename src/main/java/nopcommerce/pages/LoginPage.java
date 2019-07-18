package nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By welcomeMessage = By.tagName("h1");
    private By errorMessage = By.xpath("//div[contains(@class, 'message-error')]");
    private By errorDetailsMessage = By.xpath("//div[contains(@class, 'message-error')]//li");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By loginBtn = By.xpath("//input[@value='Log in']");

    public void loginWithCredentials(String username, String password) {

        driver.findElement(email).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(loginBtn).submit();
    }

    public String getWelcomeMessage(){
        String welcomeMessageTxt = driver.findElement(welcomeMessage).getText();
        return welcomeMessageTxt;
    }

    public String getErrorMessage(){
        String errorMessageTxt = driver.findElement(errorMessage).getText();
        return errorMessageTxt;
    }

    public String getErrorDetailsMessage(){
        String errorDetailsMessageTxt = driver.findElement(errorDetailsMessage).getText();
        return errorDetailsMessageTxt;
    }
}

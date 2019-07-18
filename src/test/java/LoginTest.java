import nopcommerce.BaseTest;
import nopcommerce.pages.LoginPage;
import nopcommerce.pages.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    private String expectedWelcomeMessage = "Welcome, Please Sign In!";
    private String expectedErrorMessage;

    @Test
    public void userCanLoginSuccessfullyUsingRamomCredentials() {

        String username = configuration.getUsername();
        String password = configuration.getPassword();

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnLogin();
        assertEquals(loginPage.getWelcomeMessage(), expectedWelcomeMessage);

        loginPage.loginWithCredentials(username, password);

        assertFalse(isElementPresent(mainPage.rightTop.loginBtn), "'Log in' button should NOT be present on the page");
        assertFalse(isElementPresent(mainPage.rightTop.registerBtn), "'Register' button should NOT be present on the page");
        assertTrue(isElementPresent(mainPage.rightTop.myAccount), "'My Account' button should BE present on the page");
        assertTrue(isElementPresent(mainPage.rightTop.logOut), "'Log out' button should BE present on the page");
    }

    @Test
    public void tryingLoginWithWrongPasswordShouldAppropriateMessage(){

        expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect";
//        expectedErrorMessageDetails = "The credentials provided are incorrect";

        String username = configuration.getUsername();
        String password = configuration.getPassword() + "wrong";

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnLogin();
        assertEquals(loginPage.getWelcomeMessage(), expectedWelcomeMessage);

        loginPage.loginWithCredentials(username, password);
        assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
    }

    @Test
    public void tryingLoginWithNotRegisteredEmailShouldSeeAppropriateMeasssage(){

        expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found";

        String username = configuration.getUsername() + "wrong";
        String password = configuration.getPassword();

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnLogin();
        assertEquals(loginPage.getWelcomeMessage(), expectedWelcomeMessage);

        loginPage.loginWithCredentials(username, password);
        assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
    }
}

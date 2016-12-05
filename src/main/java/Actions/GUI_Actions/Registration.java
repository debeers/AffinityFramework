package Actions.GUI_Actions;

import Entities.User;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RegistrationPage;
import PageObjects.UserAccountPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static Actions.GUI_Actions.WindowsHandler.switchToFacebookPopupPageLoginAndSwitchBack;
import static Actions.GUI_Actions.WindowsHandler.switchToGooglePlusPopupPageLoginAndSwitchBack;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class Registration {

    public static UserAccountPage registerNewUser(WebDriver driver, User user) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = (LoginPage) mainPage.clickOnUserAccountLink(user.getEmail());

        RegistrationPage registrationPage = loginPage.clickOnRegistrationLink(driver);
        return registrationPage.enterRegistrationData(user.getUserPhone(), user.getEmail(), user.getPassword());
    }

    public static UserAccountPage registerNewUserUsingEmail(WebDriver driver, User user) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnUserAccountLinkEmail(user.getEmail());
        RegistrationPage registrationPage = loginPage.clickOnRegistrationLink(driver);
        return registrationPage.enterRegistrationDataUsingEmail(user.getEmail() , user.getPassword());
    }

    public static UserAccountPage registerNewUserUsingPhone(WebDriver driver, User user) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnUserAccountLinkPhone(user.getUserPhone());

        RegistrationPage registrationPage = loginPage.clickOnRegistrationLink(driver);
        return registrationPage.enterRegistrationDataShort(user.getUserPhone(), user.getPassword());
    }

    public static UserAccountPage registerNewUserWithoutFillingPassword(WebDriver driver, User user) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnUserAccountLinkEmail(user.getEmail());
        RegistrationPage registrationPage = loginPage.clickOnRegistrationLink(driver);
        return registrationPage.enterConfirmPassword(user.getPassword());
    }

    public static UserAccountPage registerUserThroughFacebook(WebDriver driver, User user) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnUserAccountUnAutorizedLink();
        loginPage
                .clickOnFacebookLoginButton(driver);
        System.out.println("CURRENT URL IS ====> " + driver.getCurrentUrl() + "\n WINDOW HANDLE " + driver.getWindowHandle());
        switchToFacebookPopupPageLoginAndSwitchBack(driver , user);
        return new UserAccountPage(driver);
    }

    public static UserAccountPage registerUserThroughGooglePlus(WebDriver driver, User user, String cityName) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickOnUserAccountUnAutorizedLink();
        Thread.sleep(2000);
        loginPage
                .clickOnGooglePlusLoginButton(driver);
        try {
            loginPage.clickOnGooglePlusLoginButton(driver);
        } catch (NoSuchElementException e) {
            System.out.println("Already pressed and performed login");
        }
        switchToGooglePlusPopupPageLoginAndSwitchBack(driver , user , cityName);
        return new UserAccountPage(driver);
    }

}

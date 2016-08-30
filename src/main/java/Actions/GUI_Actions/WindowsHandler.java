package Actions.GUI_Actions;

import Entities.User;
import PageObjects.FacebookLoginPage;
import PageObjects.GooglePlusLoginPage;
import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by Dem on 20.06.2016.
 */
public class WindowsHandler {

    public static FacebookLoginPage switchToFacebookPopupPageLoginAndSwitchBack(WebDriver driver , User user) throws InterruptedException {
        String oldPage = driver.getWindowHandle();
        String popupPage = null;
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            popupPage = handle;
        }
        driver.switchTo().window(popupPage);
        Thread.sleep(2000);
        facebookLoginPage
                .enterUsername(user.getUserPhone())
                .enterUserPassword(user.getPassword())
                .clickOnLoginButton()
                .clickOnContinueButton()
                .closeFacebookLoginPage();
        driver.switchTo().window(oldPage);
        return new FacebookLoginPage(driver);
    }

    public static GooglePlusLoginPage switchToGooglePlusPopupPageLoginAndSwitchBack(WebDriver driver , User user, String cityName) throws InterruptedException {
        String oldPage = driver.getWindowHandle();
        String popupPage = null;
        GooglePlusLoginPage googlePlusLoginPage = new GooglePlusLoginPage(driver);
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            popupPage = handle;
        }
        driver.switchTo().window(popupPage);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        googlePlusLoginPage
                .enterGoogleEmail(user.getUserPhone())
                .enterGoogleEmailPassword(user.getPassword())
                .pressOnTheApproveButton();
        driver.switchTo().window(oldPage);
        return new GooglePlusLoginPage(driver);
    }
}
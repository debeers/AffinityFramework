package Actions;

import Entities.User;
import PageObjects.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class Registration {

    public static UserAccountPage registerNewUser(WebDriver driver, User user) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = (LoginPage) mainPage.clickOnUserAccountLink(user.getEmail());

        RegistrationPage registrationPage = loginPage.clickOnRegistrationLink();
        return registrationPage.enterRegistrationData(user.getPhoneNumber(), user.getEmail(), user.getPassword());
    }

}

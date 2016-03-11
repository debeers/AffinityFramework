package Actions;

import Entities.LoginObject;
import Entities.User;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.UserAccountPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class Login {

    public static UserAccountPage loginAs(WebDriver driver, User user){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = (LoginPage) mainPage.clickOnUserAccountLink(user.getEmail());
        return loginPage.loginAs(user.getEmail(), user.getPassword());
    }

    public static UserAccountPage loginAs(WebDriver driver, LoginObject clientLogin){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = (LoginPage) mainPage.clickOnUserAccountLink(clientLogin.getLogin());
        return loginPage.loginAs(clientLogin.getLogin(), clientLogin.getPassword());
    }

}

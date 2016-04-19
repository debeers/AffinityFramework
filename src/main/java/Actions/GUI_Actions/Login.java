package Actions.GUI_Actions;

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
        return loginPage.loginAs(driver, user.getEmail(), user.getPassword());
    }


    public static UserAccountPage loginAs(WebDriver driver, ApiWorker.model.users.User user){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = (LoginPage) mainPage.clickOnUserAccountLink(user.getUserName());
        return loginPage.loginAs(driver, user.getUserName(), user.getPassword());
    }


    public static UserAccountPage loginAs(WebDriver driver, LoginObject clientLogin){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = (LoginPage) mainPage.clickOnUserAccountLink(clientLogin.getLogin());
        return loginPage.loginAs(driver, clientLogin.getLogin(), clientLogin.getPassword());
    }

    public static UserAccountPage loginViaPhone(WebDriver driver, User user) {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = (LoginPage) mainPage.clickOnUserAccountLink(user.getUserPhone());
        return loginPage.loginViaPhone(driver, user.getUserPhone(), user.getPassword());
    }

}

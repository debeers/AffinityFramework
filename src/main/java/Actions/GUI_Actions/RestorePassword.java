package Actions.GUI_Actions;

import PageObjects.MainPage;
import PageObjects.PasswordRecoveryPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dem on 19.06.2016.
 */
public class RestorePassword {
    public static PasswordRecoveryPage restorePassword(WebDriver driver, String username) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = mainPage.clickOnUserAccountUnAutorizedLink().clickOnForgotPasswordLink(driver);
        passwordRecoveryPage
                .enterUsernameToRecoverPassword(username);
                //.clickOnSubmitButtonToRestorePassword();
    return new PasswordRecoveryPage(driver);
    }

}

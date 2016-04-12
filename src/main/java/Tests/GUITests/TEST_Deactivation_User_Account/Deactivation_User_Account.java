package Tests.GUITests.TEST_Deactivation_User_Account;

import ApiWorker.model.users.User;
import PageObjects.UserAccountPage;
import Tests.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Actions.API_Actions.Registration_Login.registerNewUserViaAPI;
import static Actions.GUI_Actions.Login.loginAs;

/**
 * Created by DeBeers on 12.04.2016.
 */
public class Deactivation_User_Account extends BaseTest {


    @Test
    public void Deactivation_User_Account_TEST() throws IOException {

        String userPhone = "+994-" + RandomStringUtils.randomNumeric(9);
        String userLogin = "TEST_USER_" + RandomStringUtils.randomNumeric(7) + "_@gmail.com";

        User user = registerNewUserViaAPI(userPhone, userLogin, false, true);

        loginAs(driver, user)
                .clickOnUserSettingsTopMenuLink()
                .deleteAccount();

        Assert.assertEquals(driver.getCurrentUrl(), "http://lalafo.az/ru/");

    }
}

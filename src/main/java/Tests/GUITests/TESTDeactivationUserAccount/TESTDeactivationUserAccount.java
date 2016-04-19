package Tests.GUITests.TESTDeactivationUserAccount;

import Entities.User;
import Tests.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Actions.GUI_Actions.Registration.registerNewUser;

/**
 * Created by DeBeers on 12.04.2016.
 */
public class TESTDeactivationUserAccount extends BaseTest {

    @Test
    public void DeactivationUserAccount() throws IOException, InterruptedException {
        //Properties props = propertyXMLoader(System.getProperty("user.dir") +
        //        "/src/main/java/Tests/GUITests/TESTRegistration/TEST_RegistrationData.xml");

        String userPhone    = "70" + RandomStringUtils.randomNumeric(7);
        String email        = "GUI_TEST_" + RandomStringUtils.randomAlphabetic(9) + "@mail.com";//props.getProperty("emailDomain");
        String password     = "TEST_USER_" + RandomStringUtils.randomNumeric(7) + "_@gmail.com";

        User user = new User(userPhone , email , password);
        registerNewUser(driver, user)
                .clickOnUserSettingsTopMenuLink()
                .deleteAccount();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);

    }
}

package Tests.GUITests.TEST_Login;

import PageObjects.UserAccountPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;

import static Actions.GUI_Actions.Login.loginAs;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class TEST_PositiveLogin extends BaseTest{

    @Test
    public void Login_Positive_Test() throws InterruptedException, IOException, AWTException, SQLException {

        String emailSubSequence = (String) clientLogin.getLogin().subSequence(0, 11); // user account link (email subsequence) for assertion
        //
        // Login with existing user
        //
        UserAccountPage userAccountPage = loginAs(driver, clientLogin);

        // Does not login
        // Check user page for consistance and that user email is displaing in user account menu link
        //
        Assert.assertTrue(userAccountPage.messagesCounter.isDisplayed(), "Message counter is not displaing on user account page");
        Assert.assertTrue(userAccountPage.myMessagesUserNav.isDisplayed(), "My messages tab is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.myPostsUserNav).isDisplayed(), "Posts tab is not displaing on user account page");
        Assert.assertTrue($(userAccountPage.mySettingsUserNav).isDisplayed(), "Settings tab is not displaing on user account page");
        String tmp = new String($(userAccountPage.userAccountTopMenuLink).getText().getBytes(Charset.forName("utf-8")));
                Assert.assertTrue(tmp.contains(emailSubSequence), "User email is not contains in user account menu link!");
    }

}

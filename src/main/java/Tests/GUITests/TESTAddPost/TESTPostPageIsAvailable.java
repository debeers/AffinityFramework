package Tests.GUITests.TESTAddPost;

import PageObjects.MainPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Dem on 21.03.2016.
 */
public class TESTPostPageIsAvailable extends BaseTest{

    @Test
        public void CheckPostPage() throws InterruptedException, IOException {
        new MainPage(driver).clickOnAddNewPostButton();
        log.info("We are on the main page");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "ad/post");
    }

}

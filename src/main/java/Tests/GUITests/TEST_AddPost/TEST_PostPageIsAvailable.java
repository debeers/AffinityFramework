package Tests.GUITests.TEST_AddPost;

import PageObjects.MainPage;
import PageObjects.PostPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Dem on 21.03.2016.
 */
public class TEST_PostPageIsAvailable extends BaseTest{

    @Test(dependsOnGroups="PRECONDITION")
        public void Check_Post_Page() throws InterruptedException, IOException {
        new MainPage(driver).clickOnAddNewPostButton();
        log.info("We are on the main page");

        Assert.assertEquals(driver.getCurrentUrl(), "http://lalafo.az/ru/ad/post/");
    }

}

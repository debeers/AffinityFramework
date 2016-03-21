package Tests.AddPost;

import PageObjects.MainPage;
import PageObjects.PostPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Dem on 21.03.2016.
 */
public class PostPageIsOn extends BaseTest{
    @Test
        public void Check_Post_Page() throws InterruptedException, IOException {
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        PostPage postPage = mainPage.clickOnAddNewPostButton();
        Assert.assertEquals(driver.getCurrentUrl(), "http://lalafo.az/ru/ad/post/");
    }

}

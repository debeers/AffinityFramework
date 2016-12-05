package Tests.Smoke;

import PageObjects.MainPage;
import PageObjects.PostPage;
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
        MainPage mainPage = new MainPage(driver);
        PostPage postPage = mainPage.clickOnAddNewPostButtonLatest();
        Thread.sleep(3000);

        log.info("We are on the main page");

        System.out.println("CURRENT URL IS =>>>>>>>>>>>>>> " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/ad/post");
    }

}

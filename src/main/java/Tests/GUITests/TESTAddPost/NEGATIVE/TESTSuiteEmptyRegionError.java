package Tests.GUITests.TESTAddPost.NEGATIVE;

import PageObjects.MainPage;
import PageObjects.PostPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import java.sql.SQLException;
import java.util.Properties;


/**
 * Created by DeBeers on 02.04.2016.
 */
public class TESTSuiteEmptyRegionError extends BaseTest {


    @Test
    public void EmptyRegion() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = new ResourcesFactory().getResources("EmptyRegion");

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //
        //Go to compose new post
        //
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        log.info("We are on the composing new post page");

        //
        //Create new post
        //
        postPage.setCategory(props.getProperty("RegionIndex"));
        postPage.clickOnPreviewButton();
        Assert.assertTrue(postPage.getAllFieldsErrors().contains(props.getProperty("AssertRegionErrorMessage")), "No error was found");
    }

}

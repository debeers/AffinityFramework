package Tests.GUITests.TEST_AddPost.NEGATIVE;

import PageObjects.MainPage;
import PageObjects.PostPage;
import TEST_RESOURCES.ResourcesFactory;
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
public class TEST_SUITE_Empty_Select_Check extends BaseTest {

    @Test
    public void Add_Post_CategoryError() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = new ResourcesFactory().getResources("TEST_EmptyUnderCategory_AZ_RU");

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
        postPage.setCategory(props.getProperty("CategoryIndex"));
        postPage.clickOnPreviewButton();

        Assert.assertTrue(postPage.getAllFieldsErrors().contains(props.getProperty("AssertCategoryErrorMessage")), "No error was found");

    }


    @Test
    public void Add_Post_UnderCategoryError() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = new ResourcesFactory().getResources("TEST_EmptyUnderCategory_AZ_RU");

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
        postPage.setCategory(props.getProperty("CategoryIndex"));
        postPage.setUnderCategory(props.getProperty("UnderCategoryIndex"));
        postPage.clickOnPreviewButton();

        Assert.assertTrue(postPage.getAllFieldsErrors().contains(props.getProperty("AssertUnderCategoryErrorMessage")), "No error was found");

    }


    @Test
    public void Add_Post_RegionError() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = new ResourcesFactory().getResources("TEST_EmptyUnderCategory_AZ_RU");

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

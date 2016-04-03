package Tests.GUITests.TEST_AddPost.NEGATIVE;

import PageObjects.ErrorHandler;
import PageObjects.MainPage;
import PageObjects.PostPage;
import Tests.BaseTest;
import Tests.GUITests.TEST_AddPost.DATA.DataProviderSourceNegative;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TEST_SUITE_IncorrectDataFillin extends BaseTest {


    @Test(dataProvider = "negativePostTitle", dataProviderClass = DataProviderSourceNegative.class)
    public void NegativeFillIn(String title, String expectedError) throws IOException, InterruptedException {

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //
        //Go to compose new post
        //
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        log.info("We are on the composing new post page");

        postPage.fillinNegativeDataInTheFieldAndSubmit(title, postPage.titleField, postPage.previewButton);
        Assert.assertTrue(ErrorHandler.compareErrors(postPage.getFieldError(postPage.titleErrorBlock), expectedError), "No matches in error block!");

    }


    @Test(dataProvider = "negativeDescription", dataProviderClass = DataProviderSourceNegative.class)
    public void NegativeFillInDescription(String description, String expectedError) throws IOException, InterruptedException {

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //
        //Go to compose new post
        //
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        log.info("We are on the composing new post page");

        postPage.fillinNegativeDataInTheFieldAndSubmit(description, postPage.descriptionField, postPage.previewButton);
        Assert.assertTrue(ErrorHandler.compareErrors(postPage.getFieldError(postPage.descriptionErrorBlock), expectedError), "No matches in error block!");

    }


    @Test(dataProvider = "negativeName", dataProviderClass = DataProviderSourceNegative.class)
    public void NegativeFillInName(String name, String expectedError) throws IOException, InterruptedException {

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //
        //Go to compose new post
        //
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        log.info("We are on the composing new post page");

        postPage.fillinNegativeDataInTheFieldAndSubmit(name, postPage.nameField, postPage.previewButton);
        Assert.assertTrue(ErrorHandler.compareErrors(postPage.getFieldError(postPage.nameErrorBlock), expectedError), "No matches in error block!");

    }


    @Test(dataProvider = "negativePostEmail", dataProviderClass = DataProviderSourceNegative.class)
    public void NegativeFillInEmail(String email, String expectedError) throws IOException, InterruptedException {

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //
        //Go to compose new post
        //
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        log.info("We are on the composing new post page");

        postPage.fillinNegativeDataInTheFieldAndSubmit(email, postPage.emailField, postPage.previewButton);
        Assert.assertTrue(ErrorHandler.compareErrors(postPage.getFieldError(postPage.emailErrorBlock), expectedError), "No matches in error block!");

    }


    @Test(dataProvider = "negativePostPhone", dataProviderClass = DataProviderSourceNegative.class)
    public void NegativeFillInPhone(String email, String expectedError) throws IOException, InterruptedException {

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //
        //Go to compose new post
        //
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        log.info("We are on the composing new post page");

        postPage.fillinNegativeDataInTheFieldAndSubmit(email, postPage.phoneField, postPage.previewButton);
        Assert.assertTrue(ErrorHandler.compareErrors(postPage.getFieldError(postPage.phoneErrorBlock), expectedError), "No matches in error block!");

    }

    @Test(dataProvider = "negativePostPrice", dataProviderClass = DataProviderSourceNegative.class)
    public void NegativeFillInPrice(String price, String expectedError) throws IOException, InterruptedException {

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //
        //Go to compose new post
        //
        PostPage postPage = mainPage.clickOnAddNewPostButton();
        log.info("We are on the composing new post page");

        postPage.fillinNegativeDataInTheFieldAndSubmit(price, postPage.priceField, postPage.previewButton);
        Assert.assertTrue(ErrorHandler.compareErrors(postPage.getFieldError(postPage.priceErrorBlock), expectedError), "No matches in error block!");

    }


}

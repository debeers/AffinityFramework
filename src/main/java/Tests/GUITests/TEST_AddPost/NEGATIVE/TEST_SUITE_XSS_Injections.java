package Tests.GUITests.TEST_AddPost.NEGATIVE;

import PageObjects.MainPage;
import PageObjects.PostPage;
import Tests.BaseTest;
import Tests.GUITests.TEST_AddPost.DATA.DataProviderSourceNegative;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Actions.GUI_Actions.PostAdd.compareErrors;
import static Actions.GUI_Actions.PostAdd.compeareAllertMessage;

/**
 * Created by DeBeers on 01.04.2016.
 */
public class TEST_SUITE_XSS_Injections extends BaseTest{

    @Test(dataProvider="Injections", dataProviderClass=DataProviderSourceNegative.class)
    public void Negative_Post_Title_Injections(String title, String allertMessage) throws IOException, InterruptedException {

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
            Assert.assertFalse(compeareAllertMessage(driver, allertMessage), "Allert appear! XSS injection was successfull!");

        }

    @Test(dataProvider="Injections", dataProviderClass=DataProviderSourceNegative.class)
    public void Negative_Post_Name_Injections(String name, String allertMessage) throws IOException, InterruptedException {

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
        Assert.assertFalse(compeareAllertMessage(driver, allertMessage), "Allert appear! XSS injection was successfull!");

    }

    @Test(dataProvider="Injections", dataProviderClass=DataProviderSourceNegative.class)
    public void Negative_Post_Description_Injections(String description, String allertMessage) throws IOException, InterruptedException {

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
        Assert.assertFalse(compeareAllertMessage(driver, allertMessage), "Allert appear! XSS injection was successfull!");

    }

}

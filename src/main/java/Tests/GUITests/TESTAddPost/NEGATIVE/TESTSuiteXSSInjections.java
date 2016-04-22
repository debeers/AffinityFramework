package Tests.GUITests.TESTAddPost.NEGATIVE;

import PageObjects.MainPage;
import PageObjects.PostPage;
import TESTResources.DataSources.AZ_AZ.DataProviders.DataProviderInjections;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Actions.GUI_Actions.PostAdd.compeareAllertMessage;

/**
 * Created by DeBeers on 01.04.2016.
 */
public class TESTSuiteXSSInjections extends BaseTest {


    @Test(dataProvider="Injections", dataProviderClass= DataProviderInjections.class)
    public void negativePostTitleInjections(String title, String allertMessage) throws IOException, InterruptedException, ClassNotFoundException {

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

    @Test(dataProvider="Injections", dataProviderClass=DataProviderInjections.class)
    public void negativePostNameInjections(String name, String allertMessage) throws IOException, InterruptedException {

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

    @Test(dataProvider="Injections", dataProviderClass=DataProviderInjections.class)
    public void negativePostDescriptionInjections(String description, String allertMessage) throws IOException, InterruptedException {

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

package Tests.GUITests.TEST_AddPost;

import Entities.Post;
import PageObjects.MainPage;
import PageObjects.PostPage;
import Tests.BaseTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static UtilsGUI.PropertiesLoader.propertyXMLoader;


public class NegativeDataFillin extends BaseTest{


@Test
        public void NegativeFillIn() throws IOException {
    Properties props = propertyXMLoader(System.getProperty("user.dir") +
            "/src/main/java/Tests/GUITests/TEST_AddPost/DATA/TEST_AddNewPost.xml");

    Post post = new Post(props);
    int countForPhotoUploads = 0;

    //lets go hello motorolla
    //Go to main page
    //
    MainPage mainPage = new MainPage(driver);
    log.info("We are on the main page");

    //
    //Go to compose new post
    //
    PostPage postPage = mainPage.clickOnAddNewPostButton();
    log.info("We are on the composing new post page");

    postPage.titleField.sendKeys();
    postPage.clickOnPreviewButton();
    List<String> errors = postPage.getFieldsErrors();


}

}

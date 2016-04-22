package Tests.GUITests.TESTAddPost;

import PageObjects.MainPage;
import GeneralHelpers.ListContainer;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by DeBeers on 06.04.2016.
 */
public class TESTCitiesValidation extends BaseTest {

    @Test
    public void CitiesValidation() throws IOException, SQLException {

        Properties props = new ResourcesFactory().getResources("CitiesValidation");

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //Go to compose new post
        //
        Assert.assertTrue(
                mainPage
                        .clickOnAddNewPostButton()
                        .getListCitiesFromGUI()
                        .containsAll(new ListContainer(props.getProperty("getCities")).getList())
        );

        log.info("Test passed, categories equals");
    }

}

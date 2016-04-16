package Tests.SMOKE;

import PageObjects.MainPage;
import SQLRepository.ListContainer;
import TEST_RESOURCES.ResourcesFactory;
import Tests.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static UtilsGUI.PropertiesLoader.propertyXMLoader;

/**
 * Created by DeBeers on 06.04.2016.
 */
public class TEST_Cities_Validation extends BaseTest {

    @Test
    public void TEST_Cities_Validation() throws IOException, SQLException {

        Properties props = new ResourcesFactory().getResources("TEST_Cities_Validation");

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

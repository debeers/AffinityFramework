package Tests.GUITests.SMOKE;

import PageObjects.MainPage;
import SQLRepository.CitiesList;
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
public class TEST_CitiesValidation extends BaseTest {

    @Test
    public void Cities_Validation_Test() throws IOException, SQLException {

        Properties sql = propertyXMLoader(System.getProperty("user.dir") +
                "/src/main/java/SQLRepository/AZ_RU_Lalafo_SQL.xml");

        //Go to main page
        //
        MainPage mainPage = new MainPage(driver);
        log.info("We are on the main page");

        //
        //Go to compose new post
        //
        Assert.assertTrue(
                mainPage
                        .clickOnAddNewPostButton()
                        .getListCitiesFromGUI()
                        .containsAll(new CitiesList(sql).getCities())
        );

        log.info("Test passed, categories equals");
    }

}

package Tests.GUITests.SMOKE;

import PageObjects.MainPage;
import SQLRepository.CategoriesList;
import Tests.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static UtilsGUI.PropertiesLoader.propertyXMLoader;

/**
 * Created by DeBeers on 05.04.2016.
 */
public class TEST_CategoriesValidation extends BaseTest {


    @Test
    public void Validate_categories_in_post() throws IOException, SQLException {

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
                .getListCategoriesFromGUI()
                .containsAll(new CategoriesList(sql).getCategories())
        );

        log.info("Test passed, categories equals");
    }

}

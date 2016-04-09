package Tests.GUITests.SMOKE;

import PageObjects.PostPage;
import SQLRepository.ListContainer;
import Tests.BaseTest;
import org.testng.Assert;
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

        driver.get("http://lalafo.az/ru/ad/post/");
        PostPage postPage = new PostPage(driver);

        //
        //Go to compose new post
        //
        Assert.assertTrue(
                postPage
                        .getListCategoriesFromGUI()
                        .containsAll(new ListContainer(sql.getProperty("getCategories")).getList())
        );

        log.info("Test passed, categories equals");
    }

}

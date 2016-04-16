package Tests.SMOKE;

import PageObjects.PostPage;
import SQLRepository.ListContainer;
import TEST_RESOURCES.ResourcesFactory;
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
public class TEST_Categories_Validation extends BaseTest {


    @Test
    public void TEST_Categories_Validation() throws IOException, SQLException {

        Properties props = new ResourcesFactory().getResources("TEST_Categories_Validation");

        driver.get("http://lalafo.az/ru/ad/post/");
        PostPage postPage = new PostPage(driver);

        //Go to compose new post
        //
        Assert.assertTrue(
                postPage
                        .getListCategoriesFromGUI()
                        .containsAll(new ListContainer(props.getProperty("getCategories")).getList())
        );

        log.info("Test passed, categories equals");
    }

}

package Tests.Smoke;

import PageObjects.PostPage;
import SQLRepository.ListContainer;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by DeBeers on 05.04.2016.
 */
public class TESTCategoriesValidation extends BaseTest {


    @Test
    public void CategoriesValidation() throws IOException, SQLException {

        Properties props = new ResourcesFactory().getResources("CategoriesValidation");

        driver.get(baseUrl + "ad/post/");
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

package Tests.GUITests.TESTAddPost;

import PageObjects.PostPage;
import GeneralHelpers.ListContainer;
import TESTResources.DataSources.AZ_AZ.DataProviders.DataProviderSelector;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.Collator;
import java.util.List;

/**
 * Created by DeBeers on 09.04.2016.
 */
public class TESTUndercategoryValidation extends BaseTest {


    @Test(dataProvider = "underCategory_validation", dataProviderClass = DataProviderSelector.class)
    public void underCategory_validation(String categoryIndex, String sqlQuery) throws IOException, InterruptedException, SQLException {

        //
        //Go to compose new post
        //
        driver.get(baseUrl + "ad/post/");
        PostPage postPage = new PostPage(driver);
        postPage.setCategory(categoryIndex);

        List<String> undercategoriesGUI = postPage.getListUnderCategoriesFromGUI();
        List<String> undercategoriesDB  = new ListContainer(sqlQuery).getList();
        undercategoriesGUI.sort(Collator.getInstance());
        undercategoriesDB.sort(Collator.getInstance());

        Assert.assertEquals(undercategoriesGUI, undercategoriesDB);
    }

}

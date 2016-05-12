package Tests.GUITests.TESTAddPost;

import GeneralHelpers.ListContainer;
import PageObjects.PostPage;
import TESTResources.DataSources.AZ_AZ.DataProviders.DataProviderSelector;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.Collator;
import java.util.List;

/**
 * Created by Dem on 12.05.2016.
 */
public class TESTPropertyParametersCheck extends BaseTest {

    @Test(dataProvider = "propertyParametersCheck", dataProviderClass = DataProviderSelector.class)
    public void propertyParametersCheck(String categoryIndex, String subcategoryIndex, String sqlQuery) throws InterruptedException, IOException, SQLException {
        driver.get(baseUrl + "ad/post/");
        PostPage postPage = new PostPage(driver);
        postPage.setCategory(categoryIndex);
        postPage.setUnderCategoryForCertainPages(subcategoryIndex);

        List<String> propertyParametersGUI = postPage.getPropertyParametersList();
        List<String> propertyParametersDB  = new ListContainer(sqlQuery).getList();
        propertyParametersGUI.sort(Collator.getInstance());
        propertyParametersDB.sort(Collator.getInstance());

        Assert.assertEquals(propertyParametersGUI , propertyParametersDB , "Property parameters are not equal");
    }
}

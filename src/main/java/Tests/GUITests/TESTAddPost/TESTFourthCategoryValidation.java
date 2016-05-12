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
 * Created by DeBeers on 16.04.2016.
 */
public class TESTFourthCategoryValidation extends BaseTest {

    @Test(dataProvider = "fourthCategory_validation", dataProviderClass = DataProviderSelector.class)
    public void fourthCategory_validation(String categoryIndex, String subcategoryIndex, String sqlQuery) throws IOException, InterruptedException, SQLException {
        //
        //Go to compose new post
        //
        driver.get(baseUrl + "ad/post/");
        PostPage postPage = new PostPage(driver);
        postPage.setCategory(categoryIndex);
        postPage.setUnderCategory(subcategoryIndex);

        List<String> fourthSubcategoriesGUI = postPage.getFourthLvlSubCategoryFromGUI();
        List <String> fourthSubcategoriesDB  = new ListContainer(sqlQuery).getList();
        fourthSubcategoriesGUI.sort(Collator.getInstance());
        fourthSubcategoriesDB.sort(Collator.getInstance());

        Assert.assertEquals(fourthSubcategoriesGUI , fourthSubcategoriesDB, "Subcategories are not equal");
    }
}

package Tests.GUITests.TESTAddPost;

import PageObjects.PostPage;
import GeneralHelpers.ListContainer;
import TESTResources.DataSources.AZ_AZ.DataProviders.DataProviderCategoriesBD;
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
public class TESTThirdSubcategoryValidation extends BaseTest{

    @Test(dataProvider = "thirdSubcategory_validation", dataProviderClass = DataProviderCategoriesBD.class)
    public void thirdSubcategory_validation(String categoryIndex, String subcategoryIndex, String sqlQuery) throws IOException, InterruptedException, SQLException {
        //
        // Go to compose new post
        //
        driver.get(baseUrl + "ad/post/");
        PostPage postPage = new PostPage(driver);
        postPage.setCategory(categoryIndex);
        postPage.setUnderCategory(subcategoryIndex);

        List<String> thirdSubcategoriesGui = postPage.getThirdLvlSubCategoryFromGUI();
        List<String> thirdSubcategoriesDB  = new ListContainer(sqlQuery).getList();
        thirdSubcategoriesGui.sort(Collator.getInstance());
        thirdSubcategoriesDB.sort(Collator.getInstance());

        Assert.assertEquals(thirdSubcategoriesGui , thirdSubcategoriesDB, "Subcategories are not equal");
    }
}

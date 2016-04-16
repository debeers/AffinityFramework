package Tests.SMOKE;

import PageObjects.PostPage;
import SQLRepository.ListContainer;
import TEST_RESOURCES.DATA_SOURCES.AZ_RU.DATA_PROVIDERS.DataProvider_Categories_BD;
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
public class TEST_ThirdSubcategory_Validation extends BaseTest{

    @Test(dataProvider = "thirdSubcategory_validation", dataProviderClass = DataProvider_Categories_BD.class)
    public void thirdSubcategory_validation(String categoryIndex, String subcategoryIndex, String sqlQuery) throws IOException, InterruptedException, SQLException {
        //
        // Go to compose new post
        //
        driver.get("http://lalafo.az/ru/ad/post/");
        PostPage postPage = new PostPage(driver);
        postPage.setCategory(categoryIndex).setUnderCategory(subcategoryIndex);

        List<String> thirdSubcategoriesGui = postPage.getThirdLvlSubCategoryFromGUI();
        List<String> thirdSubcategoriesDB  = new ListContainer(sqlQuery).getList();
        thirdSubcategoriesGui.sort(Collator.getInstance());
        thirdSubcategoriesDB.sort(Collator.getInstance());

        Assert.assertEquals(thirdSubcategoriesGui , thirdSubcategoriesDB, "Subcategories are not equal");
    }
}

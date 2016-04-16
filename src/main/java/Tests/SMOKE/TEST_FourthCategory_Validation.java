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
public class TEST_FourthCategory_Validation extends BaseTest {

    @Test(dataProvider = "fourthCategory_validation", dataProviderClass = DataProvider_Categories_BD.class)
    public void fourthCategory_validation(String categoryIndex, String subcategoryIndex, String sqlQuery) throws IOException, InterruptedException, SQLException {
        //
        //Go to compose new post
        //
        driver.get("http://lalafo.az/ru/ad/post/");
        PostPage postPage = new PostPage(driver);
        postPage.setCategory(categoryIndex).setUnderCategory(subcategoryIndex);

        List<String> fourthSubcategoriesGUI = postPage.getFourthLvlSubCategoryFromGUI();
        List <String> fourthSubcategoriesDB  = new ListContainer(sqlQuery).getList();
        fourthSubcategoriesGUI.sort(Collator.getInstance());
        fourthSubcategoriesDB.sort(Collator.getInstance());

        Assert.assertEquals(fourthSubcategoriesGUI , fourthSubcategoriesDB, "Subcategories are not equal");
    }
}

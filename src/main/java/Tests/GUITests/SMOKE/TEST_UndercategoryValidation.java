package Tests.GUITests.SMOKE;

import PageObjects.PostPage;
import SQLRepository.ListContainer;
import Tests.BaseTest;
import Tests.GUITests.TEST_AddPost.DATA.DataProvider_Categories_BD;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.Collator;
import java.util.List;

/**
 * Created by DeBeers on 09.04.2016.
 */
public class TEST_UndercategoryValidation extends BaseTest {

    @Test(dataProvider = "Undercategory", dataProviderClass = DataProvider_Categories_BD.class)
    public void underCategory_validation(String categoryIndex, String sqlQuery) throws IOException, InterruptedException, SQLException {

        //
        //Go to compose new post
        //
        driver.get("http://lalafo.az/ru/ad/post/");
        PostPage postPage = new PostPage(driver);
        postPage.setCategory(categoryIndex);

        List<String> undercategoriesGUI = postPage.getListUnderCategoriesFromGUI();
        List<String> undercategoriesDB  = new ListContainer(sqlQuery).getList();
        undercategoriesGUI.sort(Collator.getInstance());
        undercategoriesDB.sort(Collator.getInstance());

        Assert.assertEquals(undercategoriesGUI, undercategoriesDB);
    }

    @Test(dataProvider = "ThirdSubCategory", dataProviderClass = DataProvider_Categories_BD.class)
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

    @Test(dataProvider = "FourthCategory", dataProviderClass = DataProvider_Categories_BD.class)
    public void fourthCategory_validation(String categoryIndex, String subcategoryIndex, String sqlQuery) throws IOException, InterruptedException, SQLException {
        //
        //Go to compose new post
        //
        driver.get("http://lalafo.az/ru/ad/post/");
        PostPage postPage = new PostPage(driver);
        postPage.setCategory(categoryIndex).setUnderCategory(subcategoryIndex);

        List <String> fourthSubcategoriesGUI = postPage.getFourthLvlSubCategoryFromGUI();
        List <String> fourthSubcategoriesDB  = new ListContainer(sqlQuery).getList();

        Assert.assertEquals(fourthSubcategoriesGUI , fourthSubcategoriesDB, "Subcategories are not equal");
    }
}

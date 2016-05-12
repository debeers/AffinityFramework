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
public class TESTMotorcyclesYearsOfManufacture extends BaseTest {

    @Test(dataProvider = "motorcyclesYearsOfManufacture", dataProviderClass = DataProviderSelector.class)
    public void motorcyclesYearsOfManufacture(String categoryIndex, String subcategoryIndex, String sqlQuery) throws IOException, InterruptedException, SQLException {
        driver.get(baseUrl + "ad/post/");
        PostPage postPage = new PostPage(driver);
        postPage.setCategory(categoryIndex);
        postPage.setUnderCategory(subcategoryIndex);

        List<String> yearsOfManufactureGUI = postPage.getYearOfManufactureForMotorcyclesCategory();
        List<String> yearsOfManufactureDB  = new ListContainer(sqlQuery).getList();
        yearsOfManufactureGUI.sort(Collator.getInstance());
        yearsOfManufactureDB.sort(Collator.getInstance());

        Assert.assertEquals(yearsOfManufactureGUI , yearsOfManufactureDB , "Years of Manufacture are not equal");
    }
}

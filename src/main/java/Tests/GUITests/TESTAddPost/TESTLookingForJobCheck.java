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
public class TESTLookingForJobCheck extends BaseTest {

    @Test(dataProvider = "lookingForJobCheck" , dataProviderClass = DataProviderSelector.class)
    public void lookingForJobCheck(String categoryIndex, String subcategoryIndex, String sqlQuery) throws InterruptedException, IOException, SQLException {
        driver.get(baseUrl + "ad/post/");
        PostPage postPage = new PostPage(driver);
        postPage.setCategory(categoryIndex);
        postPage.setUnderCategory(subcategoryIndex);

        List<String> workingScheduleGUI = postPage.getWorkingScheduleList();
        List<String> workingScheduleDB  = new ListContainer(sqlQuery).getList();
        workingScheduleGUI.sort(Collator.getInstance());
        workingScheduleDB.sort(Collator.getInstance());

        Assert.assertEquals(workingScheduleGUI , workingScheduleDB , "Working schedules are not equal");
    }
}

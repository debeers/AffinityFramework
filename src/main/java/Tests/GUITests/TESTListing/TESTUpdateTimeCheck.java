package Tests.GUITests.TESTListing;

import PageObjects.ListingPage;
import PageObjects.MainPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static Actions.GENERAL.TrimAdvertsInformation.trimSlashFromUpdateTimeListFromTheThumb;
import static Actions.GUI_Actions.ConcatCategoryAndSubcategoryFromSQL.getUpdateTimeForEachAdvertOutOfTheList;

/**
 * Created by Dem on 13.05.2016.
 */
public class TESTUpdateTimeCheck extends BaseTest {

    @Test
    public void UpdateTimeCheck() throws IOException, SQLException {
        Properties props        = new ResourcesFactory().getResources("UpdateTimeCheck");
        MainPage mainPage       = new MainPage(driver);
        ListingPage listingPage = mainPage.clickOnSearchButton();
        System.out.println(getUpdateTimeForEachAdvertOutOfTheList(props, listingPage.getTitlesOfAdvert()));
        Assert.assertEquals(getUpdateTimeForEachAdvertOutOfTheList(props, listingPage.getTitlesOfAdvert()) , trimSlashFromUpdateTimeListFromTheThumb(listingPage.getUpdateTimeListOfAdverts()));
    }
}

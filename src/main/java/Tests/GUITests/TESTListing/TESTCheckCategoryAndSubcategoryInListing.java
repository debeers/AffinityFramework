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

import static Actions.GENERAL.TrimAdvertsInformation.trimAdvertsInfo;
import static Actions.GUI_Actions.ConcatCategoryAndSubcategoryFromSQL.concatenateCategoryWthSubcategory;

/**
 * Created by Dem on 28.04.2016.
 */
public class TESTCheckCategoryAndSubcategoryInListing extends BaseTest {

    @Test
    public void CheckCategoryAndSubcategoryInListing() throws IOException, SQLException {
        Properties props = new ResourcesFactory().getResources("CheckCategoryAndSubcategoryInListing");
        MainPage mainPage = new MainPage(driver);
        ListingPage listingPage = mainPage.clickOnSearchButton();
        Assert.assertEquals(trimAdvertsInfo(listingPage.getAdvertsInformation()),
                concatenateCategoryWthSubcategory(props, listingPage.getTitlesOfAdvert()));

    }
}

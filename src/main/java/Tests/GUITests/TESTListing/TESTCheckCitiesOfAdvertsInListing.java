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

import static Actions.GENERAL.TrimAdvertsInformation.trimCitiesFromTheThumb;
import static Actions.GUI_Actions.ConcatCategoryAndSubcategoryFromSQL.getCitiesNamesUsingTheirIDs;

/**
 * Created by Dem on 13.05.2016.
 */
public class TESTCheckCitiesOfAdvertsInListing extends BaseTest {

    @Test
    public void CheckCitiesOfAdvertsInListing() throws IOException, SQLException {
        Properties props = new ResourcesFactory().getResources("CheckCitiesOfAdvertsInListing");
        MainPage mainPage = new MainPage(driver);
        ListingPage listingPage = mainPage.clickOnSearchButton();
        Assert.assertEquals(getCitiesNamesUsingTheirIDs(props, listingPage.getTitlesOfAdvert()), trimCitiesFromTheThumb(listingPage.getAdvertsInformation()));
    }
}

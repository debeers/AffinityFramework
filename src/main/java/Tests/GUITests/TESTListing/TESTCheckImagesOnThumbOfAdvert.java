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

import static Actions.GUI_Actions.ConcatCategoryAndSubcategoryFromSQL.getAmountOfImagesForEachAdvertFromDB;

/**
 * Created by Dem on 28.05.2016.
 */
public class TESTCheckImagesOnThumbOfAdvert extends BaseTest {

    @Test
    public void CheckImagesOnThumbOfAdvert() throws InterruptedException, IOException, SQLException {
        Properties props = new ResourcesFactory().getResources("CheckImagesOnThumbOfAdvert");
        MainPage mainPage = new MainPage(driver);
        ListingPage listingPage = mainPage.clickOnSearchButton();
        Assert.assertEquals(listingPage.getExactNumberOfImagesFromCounter(), getAmountOfImagesForEachAdvertFromDB(props, listingPage.getTitlesOfAdvert()));
    }
}

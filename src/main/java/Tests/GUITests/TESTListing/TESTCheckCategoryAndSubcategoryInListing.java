package Tests.GUITests.TESTListing;

import PageObjects.ListingPage;
import PageObjects.MainPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static Actions.GUI_Actions.ConcatCategoryAndSubcategoryFromSQL.*;

/**
 * Created by Dem on 28.04.2016.
 */
public class TESTCheckCategoryAndSubcategoryInListing extends BaseTest {

    @Test
    public void CheckCategoryAndSubcategoryInListing() throws IOException, SQLException {
        Properties props = new ResourcesFactory().getResources("CheckCategoryAndSubcategoryInListing");
        MainPage mainPage = new MainPage(driver);
        ListingPage listingPage = mainPage.clickOnSearchButton();
        getSubcategoryIDForEachAdvertOutOfTheList(props, listingPage.getTitlesOfAdvert());
        getCategoryIDsForEachSubcategory(props, listingPage.getTitlesOfAdvert());
        getSubcategoryNamesUsingItsId(props, listingPage.getTitlesOfAdvert());
        getCategoryNameUsingItsId(props, listingPage.getTitlesOfAdvert());
        concatenateCategoryWthSubcategory(props, listingPage.getTitlesOfAdvert());
    }
}

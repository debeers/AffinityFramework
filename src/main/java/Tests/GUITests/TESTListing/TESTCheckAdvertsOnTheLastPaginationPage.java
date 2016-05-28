package Tests.GUITests.TESTListing;

import PageObjects.ListingPage;
import PageObjects.MainPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dem on 28.05.2016.
 */
public class TESTCheckAdvertsOnTheLastPaginationPage extends BaseTest {

    @Test
    public void CheckAdvertsOnTheLastPaginationPage() {
        MainPage mainPage = new MainPage(driver);
        ListingPage listingPage = mainPage.clickOnSearchButton();
        Assert.assertTrue(!listingPage.clickOnLastPaginationPage().getTitlesOfSimpleAdverts().isEmpty());
    }
}

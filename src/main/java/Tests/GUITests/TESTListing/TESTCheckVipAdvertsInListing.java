package Tests.GUITests.TESTListing;

import PageObjects.ListingPage;
import PageObjects.MainPage;
import Tests.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Dem on 26.04.2016.
 */
public class TESTCheckVipAdvertsInListing extends BaseTest {

    @Test
    public void CheckVipAdvertsInListing() throws IOException, InterruptedException {
        MainPage mainPage = new MainPage(driver);
        ListingPage listingPage = mainPage.clickOnSearchButton();

        Assert.assertEquals(listingPage.pullAllVipAdverts().size(), listingPage.pullVipAdvertsAmount());
    }
}

package Tests.GUITests.TESTListing;

import PageObjects.ListingPage;
import PageObjects.MainPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Dem on 27.04.2016.
 */
public class TESTCheckPriceFormat extends BaseTest {

    @Test
    public void CheckPriceFormat() throws IOException, InterruptedException {
        Properties props = new ResourcesFactory().getResources("CheckPriceFormat");
        MainPage mainPage = new MainPage(driver);
        ListingPage listingPage = mainPage.clickOnSearchButton();

        Assert.assertEquals(listingPage.pullSimpleAdvertsWithCorrectPriceFormat(props).size(), listingPage.pullSimpleAdvertsAmount().size());
    }
}

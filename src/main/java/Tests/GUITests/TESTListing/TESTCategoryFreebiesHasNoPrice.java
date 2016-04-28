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
 * Created by Dem on 28.04.2016.
 */
public class TESTCategoryFreebiesHasNoPrice extends BaseTest {

    @Test
    public void CategoryFreebiesHasNoPrice() throws IOException, InterruptedException {
        Properties props = new ResourcesFactory().getResources("CategoryFreebiesHasNoPrice");
        MainPage mainPage = new MainPage(driver);
        ListingPage listingPage = mainPage.clickOnFreebiesCategory();

        Assert.assertEquals(listingPage.pullSimpleAdvertsAmount().size(), listingPage.pullSimpleAdvertsWithCorrectPriceFormat(props).size());
    }
}

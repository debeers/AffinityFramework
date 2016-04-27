package Tests.GUITests.TESTCounter;

import PageObjects.MainPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static Actions.GENERAL.PullAdsAmount.pullAdsAmount;

/**
 * Created by Dem on 26.04.2016.
 */
public class TESTCounterOnTheMainPage extends BaseTest {

    @Test
    public void CounterOnTheMainPage() throws InterruptedException, IOException, SQLException {
        Properties props = new ResourcesFactory().getResources("CounterOnTheMainPage");
        MainPage mainPage = new MainPage(driver);

        Assert.assertEquals(mainPage.pullAdvertsCount(), pullAdsAmount(props));

    }
}

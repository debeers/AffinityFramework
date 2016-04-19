package Tests.GUITests.TESTSearch;
import PageObjects.MainPage;
import TESTResources.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import static Actions.GUI_Actions.Search.search;

/**
 * Created by DeBeers on 13.03.2016.
 */
public class TESTSearch extends BaseTest {

    @Test
    public void Search() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = new ResourcesFactory().getResources("Search");

        MainPage mainPage = new MainPage(driver);
        List<String> searchResults = search(mainPage.clickOnSearchButton(), props);
        Assert.assertTrue(searchResults.contains("iPod"), "No matches found!!!");
        searchResults.stream().forEach(System.out::println);
    }
}

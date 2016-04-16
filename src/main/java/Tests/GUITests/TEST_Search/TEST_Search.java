package Tests.GUITests.TEST_Search;
import PageObjects.MainPage;
import TEST_RESOURCES.ResourcesFactory;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import static Actions.GUI_Actions.Search.search;
import static UtilsGUI.PropertiesLoader.propertyXMLoader;

/**
 * Created by DeBeers on 13.03.2016.
 */
public class TEST_Search extends BaseTest {

    @Test
    public void TEST_Search() throws InterruptedException, IOException, AWTException, SQLException {

        Properties props = new ResourcesFactory().getResources("TEST_Search");

        MainPage mainPage = new MainPage(driver);
        List<String> searchResults = search(mainPage.clickOnSearchButton(), props);
        Assert.assertTrue(searchResults.contains("iPod"), "No matches found!!!");
        searchResults.stream().forEach(System.out::println);
    }
}

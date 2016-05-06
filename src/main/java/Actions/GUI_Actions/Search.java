package Actions.GUI_Actions;

import PageObjects.ListingPage;

import java.util.List;
import java.util.Properties;

/**
 * Created by DeBeers on 13.03.2016.
 */
public class Search {

    public static List<String> search(ListingPage listingPage, Properties props) throws InterruptedException {

        listingPage.selectCategories(props.getProperty("Category"));
        listingPage.selectUnderCategories(props.getProperty("UnderCategory"));
        listingPage.enterSearchRequest(props.getProperty("SearchRequest"));
        listingPage.clickOnSearchButton();

        return listingPage.foundEqualsTitlesInSearchResults(props.getProperty("SearchRequest"));
    }
}

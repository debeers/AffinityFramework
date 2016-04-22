package Actions.GUI_Actions;

import PageObjects.SecondSearchPage;

import java.util.List;
import java.util.Properties;

/**
 * Created by DeBeers on 13.03.2016.
 */
public class Search {

    public static List<String> search(SecondSearchPage secondSearchPage, Properties props) throws InterruptedException {

        //secondSearchPage.selectCityForSearch(props.getProperty("City"));
        secondSearchPage.selectCategorie(props.getProperty("Category"));
        secondSearchPage.selectUnderCategorie(props.getProperty("UnderCategory"));
        secondSearchPage.enterSearchRequest(props.getProperty("SearchRequest"));
        secondSearchPage.clickOnSeaqrchButton();

        return secondSearchPage.foundEqualsTitlesInSearchResults(props.getProperty("SearchRequest"));
    }
}

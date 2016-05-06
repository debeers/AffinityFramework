package Actions.GUI_Actions;

import GeneralHelpers.ListContainer;
import com.codeborne.selenide.ElementsCollection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static Actions.GUI_Actions.TrimAdvertIDFromTitle.stackAllIDsToTheList;


/**
 * Created by Dem on 28.04.2016.
 */
public class ConcatCategoryAndSubcategoryFromSQL {

    public static ListContainer getSubcategoryIDForEachAdvertOutOfTheList(Properties props, ElementsCollection elements) throws IOException, SQLException {
        ListContainer getCategoriesNamesFromSQL = new ListContainer();
        if (!stackAllIDsToTheList(elements, props).isEmpty()) {
            for (String temp : stackAllIDsToTheList(elements, props)) {
                getCategoriesNamesFromSQL.init((props.getProperty("getIdForEachSubCategory") + temp));
            }
        }
        System.out.println(getCategoriesNamesFromSQL.getList());
        return getCategoriesNamesFromSQL;
    }

    public static ListContainer getCategoryIDsForEachSubcategory(Properties props, ElementsCollection elements) throws IOException, SQLException {
        ListContainer getCategoryNamesFromSQLUsingID = new ListContainer();
        if (!getSubcategoryIDForEachAdvertOutOfTheList(props , elements).getList().isEmpty()) {
            for ( String temp: getSubcategoryIDForEachAdvertOutOfTheList(props, elements).getList()){
                getCategoryNamesFromSQLUsingID.init(props.getProperty("getParenIdForEachSubCategory") + temp);
            }
        }
        System.out.println(getCategoryNamesFromSQLUsingID.getList());
        return getCategoryNamesFromSQLUsingID;
    }

    public static ListContainer getSubcategoryNamesUsingItsId(Properties props, ElementsCollection elements) throws IOException, SQLException {
        ListContainer getSubcategoryNamesUsingItsIdFromSQL = new ListContainer();
        if (!getSubcategoryIDForEachAdvertOutOfTheList(props, elements).getList().isEmpty()) {
            for (String temp : getSubcategoryIDForEachAdvertOutOfTheList(props, elements).getList()) {
                getSubcategoryNamesUsingItsIdFromSQL.init(props.getProperty("getSubcategoryName") + temp);
            }
        }
        System.out.println(getSubcategoryNamesUsingItsIdFromSQL.getList());
        return getSubcategoryNamesUsingItsIdFromSQL;
    }

    public static ListContainer getCategoryNameUsingItsId(Properties props, ElementsCollection elements) throws IOException, SQLException {
        ListContainer getCategoryNameUsingItsIdFromSQL = new ListContainer();
        if (!getCategoryIDsForEachSubcategory(props, elements).getList().isEmpty()) {
            for ( String temp: getCategoryIDsForEachSubcategory(props, elements).getList()) {
                getCategoryNameUsingItsIdFromSQL.init(props.getProperty("getCategoryName") + temp);
            }
        }
        System.out.println(getCategoryNameUsingItsIdFromSQL.getList());
        return getCategoryNameUsingItsIdFromSQL;
    }

    public static List<String> concatenateCategoryWthSubcategory(Properties props, ElementsCollection category) throws IOException, SQLException {
        List<String> getConcatenatedCategoriesWithSubcategories = new ArrayList<>();
        if (!getCategoryNameUsingItsId(props, category).getList().isEmpty() && !getSubcategoryNamesUsingItsId(props, category).getList().isEmpty()) {
            for (String temp : getCategoryNameUsingItsId(props, category).getList()) {
                getConcatenatedCategoriesWithSubcategories.addAll(getSubcategoryNamesUsingItsId(props, category).getList().stream().map(temp2 -> temp + " > " + temp2).collect(Collectors.toList()));
            }
            System.out.println(getConcatenatedCategoriesWithSubcategories);
        }
        return getConcatenatedCategoriesWithSubcategories;
    }
}

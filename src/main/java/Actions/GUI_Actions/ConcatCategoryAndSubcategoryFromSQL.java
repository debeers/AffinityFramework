package Actions.GUI_Actions;

import DBUtils.DBUtill;
import com.codeborne.selenide.ElementsCollection;
import org.apache.commons.lang3.StringUtils;

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


    public static List<String> getSubcategoryIDForEachAdvertOutOfTheList(Properties props, ElementsCollection elements) throws IOException, SQLException {
        List<String> getCategoriesNamesFromSQL = new ArrayList<>();
        List<String> advertsIds                = stackAllIDsToTheList(elements, props);
        if (!advertsIds.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < advertsIds.size(); i++)
            getCategoriesNamesFromSQL.add(dbUtill.getColumn((props.getProperty("getIdForEachSubCategory") + advertsIds.get(i)), "category_id"));
        }

        return getCategoriesNamesFromSQL;
    }

    public static List<String> getCategoryIDsForEachSubcategory(Properties props, ElementsCollection elements) throws IOException, SQLException {
        List<String> getCategoryNamesFromSQLUsingID = new ArrayList<>();
        List<String> subcategoriesIds               = getSubcategoryIDForEachAdvertOutOfTheList(props, elements);
        if (!subcategoriesIds.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < subcategoriesIds.size(); i++) {
                getCategoryNamesFromSQLUsingID.add(dbUtill.getColumn((props.getProperty("getParenIdForEachSubCategory") + subcategoriesIds.get(i)), "parent_id"));
            }
        }

        return getCategoryNamesFromSQLUsingID;
    }

    public static List<String> getSubcategoryNamesUsingItsId(Properties props, ElementsCollection elements) throws IOException, SQLException {
        List<String> getSubcategoryNamesUsingItsIdFromSQL = new ArrayList<>();
        List<String> subcategoriesIds                     = getSubcategoryIDForEachAdvertOutOfTheList(props, elements);
        if (!subcategoriesIds.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < subcategoriesIds.size(); i++) {
                getSubcategoryNamesUsingItsIdFromSQL.add(dbUtill.getColumn((props.getProperty("getSubcategoryName") + subcategoriesIds.get(i) + props.getProperty("endPartOfQuery")), props.getProperty("columnName")));
            }
        }

        return getSubcategoryNamesUsingItsIdFromSQL;
    }

    public static List<String> getCategoryNameUsingItsId(Properties props, ElementsCollection elements) throws IOException, SQLException {
        List<String> getCategoryNameUsingItsIdFromSQL = new ArrayList<>();
        List<String> categoriesIds                    = getCategoryIDsForEachSubcategory(props, elements);
        if (!categoriesIds.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < categoriesIds.size(); i++) {
                getCategoryNameUsingItsIdFromSQL.add(dbUtill.getColumn((props.getProperty("getCategoryName") + categoriesIds.get(i) + props.getProperty("endPartOfQuery")), props.getProperty("columnName")));
            }
        }

        return getCategoryNameUsingItsIdFromSQL;
    }

    public static List<String> concatenateCategoryWthSubcategory(Properties props, ElementsCollection category) throws IOException, SQLException {
        List<String> getConcatenatedCategoriesWithSubcategories = new ArrayList<>();
        List<String> advertsIds                                 = stackAllIDsToTheList(category, props);
        List<String> categoriesNames                            = getCategoryNameUsingItsId(props, category);
        List<String> subcategoriesNames                         = getSubcategoryNamesUsingItsId(props, category);
            if (!categoriesNames.isEmpty() && !subcategoriesNames.isEmpty()) {
                for (int i = 0; i < getCategoryNameUsingItsId(props,category).size(); i++) {
                    getConcatenatedCategoriesWithSubcategories.add(categoriesNames.get(i).toLowerCase() + " > " + subcategoriesNames.get(i).toLowerCase());
                }
                System.out.println(getConcatenatedCategoriesWithSubcategories);
            }
        System.out.println("IDs of the Adverts that will be used in the test::: " + advertsIds);
        return getConcatenatedCategoriesWithSubcategories;
    }

    public static List<String> getCitiesIDsForEachAdvertOutOfTheList(Properties props, ElementsCollection elements) throws IOException, SQLException {
        List<String> getCitiesIDs   = new ArrayList<>();
        List<String> advertIDs      = stackAllIDsToTheList(elements, props);
        if (!advertIDs.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < advertIDs.size(); i++) {
                getCitiesIDs.add(dbUtill.getColumn((props.getProperty("sqlQueryToGetCitiesIds") + advertIDs.get(i)), "city_id"));
            }
        }
        return getCitiesIDs;
    }

    public static List<String> getCitiesNamesUsingTheirIDs(Properties props, ElementsCollection cities) throws  IOException, SQLException {
        List<String> getCitiesNames = new ArrayList<>();
        List<String> advertIDs      = stackAllIDsToTheList(cities, props);
        List<String> citiesIds      = getCitiesIDsForEachAdvertOutOfTheList(props, cities);
        if (!citiesIds.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < citiesIds.size(); i++) {
                getCitiesNames.add(dbUtill.getColumn((props.getProperty("sqlQueryToGetCitiesNames") + citiesIds.get(i)), "name").toLowerCase());
            }
        }
        System.out.println("IDs of Adverts that will be used in the test::: " + advertIDs);
        return getCitiesNames;
    }

    public static List<String> getUpdateTimeForEachAdvertOutOfTheList(Properties props, ElementsCollection advertsTitles) throws IOException, SQLException {
        List<String> getUpdateTime      = new ArrayList<>();
        List<String> getUpdateTimeFinal = new ArrayList<>();
        List<String> advertIDs          = stackAllIDsToTheList(advertsTitles, props);
        if (!advertIDs.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < advertIDs.size(); i++) {
                getUpdateTime.add(dbUtill.getColumn((props.getProperty("sqlQueryToGetUpdateTime") + advertIDs.get(i)), "update_time"));
            }
        }
        if (!getUpdateTime.isEmpty()) {
            getUpdateTimeFinal.addAll(getUpdateTime.stream().map(temp -> StringUtils.substringBeforeLast(temp, ":").trim()).collect(Collectors.toList()));
            return getUpdateTimeFinal;
        }
        System.out.println("IDs of Adverts that will be used in the test::: " + advertIDs);
        //return getUpdateTimeFinal;
    return getUpdateTime;
    }

    public static List<String> getAmountOfImagesForEachAdvertFromDB(Properties props, ElementsCollection advertTitles) throws IOException, SQLException {
        List<String> advertIDs = stackAllIDsToTheList(advertTitles, props);
        List<String> amountOfImagesForEachAdvert = new ArrayList<>();
        if (!advertIDs.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < advertIDs.size(); i++) {
                amountOfImagesForEachAdvert.add(dbUtill.getColumn((props.getProperty("sqlQueryToGetTheAmountOfImages") + advertIDs.get(i)), "COUNT(id)"));
            }
        }
        System.out.println(amountOfImagesForEachAdvert);
        return amountOfImagesForEachAdvert;
    }
}

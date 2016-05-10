package Actions.GUI_Actions;

import DBUtils.DBUtill;
import com.codeborne.selenide.ElementsCollection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static Actions.GUI_Actions.TrimAdvertIDFromTitle.stackAllIDsToTheList;


/**
 * Created by Dem on 28.04.2016.
 */
public class ConcatCategoryAndSubcategoryFromSQL {


    public static List<String> getSubcategoryIDForEachAdvertOutOfTheList(Properties props, ElementsCollection elements) throws IOException, SQLException {
        List<String> getCategoriesNamesFromSQL = new ArrayList<>();
        //DBUtill dbUtill = new DBUtill();
        List<String> advertsIds = stackAllIDsToTheList(elements, props);
        if (!advertsIds.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < advertsIds.size(); i++)
            getCategoriesNamesFromSQL.add(dbUtill.getColumn((props.getProperty("getIdForEachSubCategory") + advertsIds.get(i)), "category_id"));
        }

        return getCategoriesNamesFromSQL;
    }

    public static List<String> getCategoryIDsForEachSubcategory(Properties props, ElementsCollection elements) throws IOException, SQLException {
        List<String> getCategoryNamesFromSQLUsingID = new ArrayList<>();
        //DBUtill dbUtill = new DBUtill();
        List<String> subcategoriesIds = getSubcategoryIDForEachAdvertOutOfTheList(props, elements);
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

        List<String> subcategoriesIds = getSubcategoryIDForEachAdvertOutOfTheList(props, elements);
        if (!subcategoriesIds.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < subcategoriesIds.size(); i++) {
                getSubcategoryNamesUsingItsIdFromSQL.add(dbUtill.getColumn((props.getProperty("getSubcategoryName") + subcategoriesIds.get(i)), "name"));
            }
        }

        return getSubcategoryNamesUsingItsIdFromSQL;
    }

    public static List<String> getCategoryNameUsingItsId(Properties props, ElementsCollection elements) throws IOException, SQLException {
        List<String> getCategoryNameUsingItsIdFromSQL = new ArrayList<>();

        List<String> categoriesIds = getCategoryIDsForEachSubcategory(props, elements);
        if (!categoriesIds.isEmpty()) {
            DBUtill dbUtill = new DBUtill();
            for (int i = 0; i < categoriesIds.size(); i++) {
                getCategoryNameUsingItsIdFromSQL.add(dbUtill.getColumn((props.getProperty("getCategoryName") + categoriesIds.get(i)), "name"));
            }
        }

        return getCategoryNameUsingItsIdFromSQL;
    }

    public static List<String> concatenateCategoryWthSubcategory(Properties props, ElementsCollection category) throws IOException, SQLException {
        List<String> getConcatenatedCategoriesWithSubcategories = new ArrayList<>();
        List<String> advertsIds = stackAllIDsToTheList(category, props);
        List<String> categoriesNames = getCategoryNameUsingItsId(props, category);
        List<String> subcategoriesNames = getSubcategoryNamesUsingItsId(props, category);
            if (!categoriesNames.isEmpty() && !subcategoriesNames.isEmpty()) {
                for (int i = 0; i < getCategoryNameUsingItsId(props,category).size(); i++) {
                    getConcatenatedCategoriesWithSubcategories.add(categoriesNames.get(i).toLowerCase() + " > " + subcategoriesNames.get(i).toLowerCase());
                }
                System.out.println(getConcatenatedCategoriesWithSubcategories);
            }
        System.out.println("IDs of the Adverts that will be used in the test::: " + advertsIds);
        return getConcatenatedCategoriesWithSubcategories;
    }
}

package Actions.GUI_Actions;

import GeneralHelpers.ListContainer;
import com.codeborne.selenide.ElementsCollection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static Actions.GUI_Actions.TrimAdvertIDFromTitle.stackAllIDsToTheList;


/**
 * Created by Dem on 28.04.2016.
 */
public class ConcatCategoryAndSubcategoryFromSQL {

    public static ListContainer executeSQLquery(Properties props, ElementsCollection elements) {

        ListContainer getCategoriesNamesFromSQL = new ListContainer();
        if (!stackAllIDsToTheList(elements, props).isEmpty()) {
            stackAllIDsToTheList(elements, props).stream().forEach((el) -> {
                try {
                    getCategoriesNamesFromSQL.init((props.getProperty("firstPartOfSQLQuery") + el));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println(getCategoriesNamesFromSQL.getList());
        return getCategoriesNamesFromSQL;
    }
}

package SQLRepository;

import DBUtils.DBUtill;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by DeBeers on 05.04.2016.
 */
public class CategoriesList {

    private List<String> categories;

    public CategoriesList(Properties props) throws IOException, SQLException {
        init(props);
    }

    public CategoriesList(Properties props, List<String> categories) {}
    public CategoriesList(List<String> categories) {
       this.categories = categories;
    }

    public List<String> init(Properties props) throws IOException, SQLException {
        DBUtill db = new DBUtill();
        ResultSet result = db.getResultSet(props.getProperty("getCategories"));
        List categories = new LinkedList<>();
        while (result.next()) {

            categories.add(result.getString("l_name"));

        }
        System.out.println(categories);
        return categories;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories)  {
        this.categories = categories;
    }


}

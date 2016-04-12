package SQLRepository;

import DBUtils.DBUtill;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DeBeers on 05.04.2016.
 */
public class ListContainer {

    private List<String> cities = new ArrayList<>();
    private String city;

    public ListContainer(String sqlQuery) throws IOException, SQLException {
        init(sqlQuery);
    }
    public ListContainer(List<String> cities) {
        this.cities = cities;
    }

    public void init(String sqlQuery) throws IOException, SQLException {
        DBUtill db = new DBUtill();
        ResultSet result = db.getResultSet(sqlQuery);

        while (result.next()) {
            cities.add(result.getString(1).trim());
        }
    }

    public String getCity () { return city; }
    public void setCity(String city) { this.city = city; }

    public List<String> getList() {
        return cities;
    }

    public void setList(List<String> cities) {
        this.cities = cities;
    }

}

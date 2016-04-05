package SQLRepository;

import DBUtils.DBUtill;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created by DeBeers on 05.04.2016.
 */
public class CitiesList {

    private List<String> cities;

    public CitiesList(Properties props) throws IOException, SQLException {
        this.init(props);
    }
    public CitiesList(List<String> cities) {
        this.cities = cities;
    }

    public void init(Properties props) throws IOException, SQLException {
        DBUtill db = new DBUtill();
        ResultSet result = db.getResultSet(props.getProperty("getCities"));

        if (result.next()) {
            this.cities.add(result.getString("l_name"));
        }
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

}

package SQLRepository;

import DBUtils.DBUtill;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DeBeers on 29.03.2016.
 */
public class PostRepo {


// PRIMER::::::::
    public static ResultSet getOrderCategories() throws IOException, SQLException {
        DBUtill db = new DBUtill();
        return db.getResultSet("SELECT NAME FROM writing_category");
    }



}

package Tests.SQLTests;

import DBUtils.DBUtill;
import Tests.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dem on 28.03.2016.
 */
public class TESTConnectSQL extends BaseTest {

    @Test
    public void DBConnectionTest() throws SQLException, IOException {

        DBUtill db = new DBUtill();
        ResultSet result = db.getResultSet("SELECT * FROM user WHERE username LIKE '%asan%'");
        while (result.next()) {
            System.out.println(
                    result.getString(1) + " " +
                    result.getString(2) + " " +
                    result.getString(3));
        }
    }
}

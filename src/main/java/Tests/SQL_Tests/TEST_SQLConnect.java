package Tests.SQL_Tests;

import DBUtils.DBUtill;
import Tests.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Dem on 28.03.2016.
 */
public class TEST_SQLConnect extends BaseTest {

    @Test
    public void DBConnectionTest() throws SQLException, IOException {
        
        DBUtill db = new DBUtill();
        db.getColumn("SELECT id FROM user WHERE id=5", "id");
    }
}

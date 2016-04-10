package DBUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by DeBeers on 29.03.2016.
 */


    public class DBConnection {

        public Connection connection;
        private Properties properties;

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        public DBConnection(){}

        public Connection initDBConnection(String DB_CONNECTION, String DB_USER, String DB_PASSWORD) throws SQLException, IOException, ClassNotFoundException {

            connection = DriverManager.getConnection(
                    DB_CONNECTION,
                    DB_USER,
                    DB_PASSWORD
            );

            System.out.println("xml found=======================================");
            return connection;
        }
    }


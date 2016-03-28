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

        public Connection initDBConnection(Properties properties) throws SQLException, IOException, ClassNotFoundException {

            connection = DriverManager.getConnection(
                    properties.getProperty("DB_CONNECTION"),
                    properties.getProperty("DB_USER"),
                    properties.getProperty("DB_PASSWORD")
            );

            System.out.println("xml found=======================================");
            return connection;
        }
    }


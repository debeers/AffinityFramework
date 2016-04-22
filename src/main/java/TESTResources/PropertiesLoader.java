package TESTResources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by DeBeers on 26.11.2015.
 */
public class PropertiesLoader {

    public static Properties propertyXMLoader(String testName) throws IOException {
        Properties props = new Properties();
        props.loadFromXML(new FileInputStream(testName));
        return props;
    }
}
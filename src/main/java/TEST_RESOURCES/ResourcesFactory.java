package TEST_RESOURCES;

import java.io.IOException;
import java.util.Properties;

import static TEST_RESOURCES.FileSearch.searchResources;
import static TEST_RESOURCES.LOCAL.*;
import static Tests.BaseTest.DATA_SOURCE_DIR;
import static Tests.BaseTest.baseUrl;
import static UtilsGUI.PropertiesLoader.propertyXMLoader;

/**
 * Created by DeBeers on 13.04.2016.
 */
public class ResourcesFactory {

    public Properties getResources(String testName) throws IOException {

        Properties props = new Properties();

        if (baseUrl.equals(AZ_RU.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + AZ_RU, testName));
            return props;
        }
        else if (baseUrl.equals(AZ_AZ.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + AZ_AZ, testName));
            return props;
        }
        else if (baseUrl.equals(KG_RU.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + KG_RU, testName));
            return props;
        }
        else if (baseUrl.equals(KG_KY.getURL())){
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + KG_KY, testName));
        return props;
        }
        else if(baseUrl.equals(TJ_RU.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + TJ_RU, testName));
            return props;
        }
        else if(baseUrl.equals(TJ_TG.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + TJ_TG, testName));
            return props;
        }
        else if(baseUrl.equals(AF_Dari.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + AF_Dari, testName));
            return props;
        }
        else if(baseUrl.equals(AF_PS.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + AF_PS, testName));
            return props;
        }
        else if(baseUrl.equals(AF_EN.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + AF_EN, testName));
            return props;
        }
        else if(baseUrl.equals(NP_EN.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + NP_EN, testName));
            return props;
        }
        else if(baseUrl.equals(NP_NE.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + NP_NE, testName));
            return props;
        }
        else if(baseUrl.equals(RS_RS.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + RS_RS, testName));
            return props;
        }
        else if(baseUrl.equals(RS_EN.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + RS_EN, testName));
            return props;
        }
        else if(baseUrl.equals(GR_GR.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + GR_GR, testName));
            return props;
        }
        else if(baseUrl.equals(GR_EN.getURL())) {
            props = propertyXMLoader(searchResources(DATA_SOURCE_DIR + GR_EN, testName));
            return props;
        }else System.out.println(">>>>>>>> NO LOCALIZATION FOUND! <<<<<<<<" );
              System.out.println("........PLEASE RECHECK BASE URL!");
            return null;
    }
}

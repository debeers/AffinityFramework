package Actions.GENERAL;

import GeneralHelpers.ListContainer;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Dem on 27.04.2016.
 */
public class PullAdsAmount {

    public static String pullAdsAmount(Properties props) throws IOException, SQLException {
        String adsCountFromDB = StringUtils
                .substringBefore((new ListContainer(props.getProperty("sqlQuery"))
                        .getList()
                        .toString()), "]")
                .substring(1);
        return adsCountFromDB;
    }
}

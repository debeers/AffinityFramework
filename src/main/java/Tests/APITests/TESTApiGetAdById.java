package Tests.APITests;


import ApiWorker.model.ads.Ad;
import DBUtils.DBUtill;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static Actions.API_Actions.PostWorker.createNewPostViaAPI;
import static Actions.API_Actions.PostWorker.getPostByIdViaAPI;
import static TESTResources.PropertiesLoader.propertyXMLoader;

public class TESTApiGetAdById extends BaseTest {

    @Test
    public void API_Post_Test() throws InterruptedException, IOException, SQLException {

        Properties props = propertyXMLoader(System.getProperty("user.dir") +
                "/src/main/java/Tests/APITests/DATA/AddPost.xml");
        DBUtill db = new DBUtill();

        String postId  = createNewPostViaAPI(props);
        Ad myAd = getPostByIdViaAPI(postId);
        long categoryId = Long.parseLong(props.getProperty("category_id"));
        String city = db.getColumn(props.getProperty("resultSet") + props.getProperty("city_id") , props.getProperty("cityName"));

        Assert.assertEquals(myAd.getCategoryId(), categoryId);
        Assert.assertEquals(myAd.getCity(), city);
        //Assert.assertEquals(myAd.getCurrency(), props.getProperty("CurrencyType"));
        Assert.assertEquals(myAd.getDesc(), props.getProperty("description"));
        Assert.assertEquals(myAd.getId(), Long.parseLong(postId));
        //Assert.assertEquals(myAd.getPrice(), props.getProperty("Price"));
        Assert.assertEquals(myAd.getTitle(), props.getProperty("title"));
        Assert.assertEquals(myAd.getUsername(), props.getProperty("username"));

    }
}

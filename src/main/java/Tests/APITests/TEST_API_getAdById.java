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
import static UtilsGUI.PropertiesLoader.propertyXMLoader;

public class TEST_API_getAdById extends BaseTest {

    @Test(groups="API", dependsOnGroups="PRECONDITION")
    public void API_Post_Test() throws InterruptedException, IOException, SQLException {

        Properties props = propertyXMLoader(System.getProperty("user.dir") +
                "/src/main/java/Tests/APITests/DATA/AddPost.xml");
        DBUtill db = new DBUtill();

        String postId  = createNewPostViaAPI(props);
        //Thread.sleep(5000);
        //Ad myAds = getAdsViaAPI(props , postId);
        Ad myAd = getPostByIdViaAPI(postId);
        long categoryId = Long.parseLong(props.getProperty("category_id"));
        String city = db.getColumn(props.getProperty("resultSet") + props.getProperty("city_id") , props.getProperty("cityName"));
        //List<String> resultSet = new ListContainer(props.getProperty("resultSet") + props.getProperty("city_id")).getList();
        //String city = "";
        //for (String s : resultSet) {
        //    city += s;
        //}
        Assert.assertEquals(myAd.getCategoryId(), categoryId);
        Assert.assertEquals(myAd.getCity(), city);
        //Assert.assertEquals(myAd.getCurrency(), props.getProperty("CurrencyType"));
        Assert.assertEquals(myAd.getDesc(), props.getProperty("description"));
        Assert.assertEquals(myAd.getId(), Long.parseLong(postId));
        //Assert.assertEquals(myAd.getPrice(), props.getProperty("Price"));
        Assert.assertEquals(myAd.getTitle(), props.getProperty("title"));
        Assert.assertEquals(myAd.getUsername(), props.getProperty("username"));

        //long myAdsId = myAds.getId();
        //long myAdsCategoryId = myAds.getCategoryId();
       // System.out.println(myAdsId);
        //System.out.println(myAdsCategoryId);
        /*Ad pulledAd = myAds.getAd(postId);
        long categoryId = pulledAd.getCategoryId();
        String title = pulledAd.getTitle();
        String description = pulledAd.getDesc();


        Assert.assertEquals(pulledAd.getId(), postId);
        Assert.assertEquals(categoryId, Long.parseLong(props.getProperty("category_id")) );
        Assert.assertEquals(description, props.getProperty("description") );
        //Assert.assertEquals(myAd.getMobile(), props.getProperty("mobile") ); //format missmatch
        Assert.assertEquals(title, props.getProperty("title") );
        //Assert.assertEquals(myAd.getUsername(), props.getProperty("username") );*/
    }
}


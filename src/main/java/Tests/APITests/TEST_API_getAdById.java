package Tests.APITests;


import ApiWorker.model.ads.Ad;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static Actions.API_Actions.PostWorker.createNewPostViaAPI;
import static Actions.API_Actions.PostWorker.getPostByIdViaAPI;
import static UtilsGUI.PropertiesLoader.propertyXMLoader;

public class TEST_API_getAdById extends BaseTest {

    @Test
    public void API_Post_Test() throws InterruptedException, IOException {

        Properties props = propertyXMLoader(System.getProperty("user.dir") +
                "/src/main/java/Tests/APITests/DATA/AddPost.xml");

        String postId = createNewPostViaAPI(props);
        Ad myAd       = getPostByIdViaAPI(postId);

        Assert.assertEquals(String.valueOf(myAd.getId()).trim(), postId.trim());
        Assert.assertEquals(myAd.getCategoryId(), Long.parseLong(props.getProperty("category_id")) );
        Assert.assertEquals(myAd.getDesc(), props.getProperty("description") );
       // Assert.assertEquals(myAd.getMobile(), props.getProperty("mobile") ); //format missmatch
        Assert.assertEquals(myAd.getTitle(), props.getProperty("title") );
        Assert.assertEquals(myAd.getUsername(), props.getProperty("username") );
    }
}


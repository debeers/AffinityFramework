package Tests.APITests;

import ApiWorker.APIManager;
import ApiWorker.model.PostField;
import ApiWorker.model.ads.Ad;
import ApiWorker.model.ads.getadbyid.GetAdByIdResponse;
import ApiWorker.model.ads.postad.PostAdBody;
import ApiWorker.model.ads.postad.PostAdResponse;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static UtilsGUI.PropertiesLoader.propertyXMLoader;

/**
 * Created by Dem on 24.03.2016.
 */
public class APITest extends BaseTest {

    @Test
    public void API_Post_Test() throws InterruptedException, IOException {


        Properties props = propertyXMLoader(System.getProperty("user.dir") +
                "/src/main/java/Tests/APITests/DATA/AddPost.xml");


        PostAdBody postAdBody = new PostAdBody();


        postAdBody.addParamField(new PostField());
        postAdBody.addField(new PostField("category_id", 39 + ""));
        postAdBody.addField(new PostField("city_id", 32 + ""));
        postAdBody.addField(new PostField("description", "War... War never changesWar..."));
        postAdBody.addField(new PostField("type", "private"));
        postAdBody.addField(new PostField("title", "Pronto-pronto"));

        postAdBody.addUserInfoField(new PostField("mobile", "+996-778888888"));
        postAdBody.addUserInfoField(new PostField("username", "GUI_TEST_USER"));
        postAdBody.addUserInfoField(new PostField("testAPI", "1"));


//        postAdBody.addParamField(new PostField());
//        postAdBody.addField(new PostField("category_id", props.getProperty("category_id")));
//        postAdBody.addField(new PostField("city_id", props.getProperty("city_id")));
//        postAdBody.addField(new PostField("description", props.getProperty("description")));
//        postAdBody.addField(new PostField("type", props.getProperty("username")));
//        postAdBody.addField(new PostField("title", props.getProperty("title")));
//
//        postAdBody.addUserInfoField(new PostField("mobile", props.getProperty("mobile")));
//        postAdBody.addUserInfoField(new PostField("username", props.getProperty("username")));
//        postAdBody.addUserInfoField(new PostField("testAPI", props.getProperty("testAPI")));
        String userId = "9346";

        Call<PostAdResponse> res = APIManager.getInstance().postAd(postAdBody, userId);
        String executor = res.execute().body().getData().getId();
        System.out.println("ID IS:::   " + executor);

        Call<GetAdByIdResponse> getAdById = APIManager.getInstance().getAdById(executor);

        Ad myAd = getAdById.execute().body().getAdList().get(0);

        Assert.assertEquals(String.valueOf(myAd.getId()).trim(), executor.trim());
        Assert.assertEquals(myAd.getCategoryId(), Long.parseLong(props.getProperty("category_id")) );
        Assert.assertEquals(myAd.getDesc(), props.getProperty("description") );
       // Assert.assertEquals(myAd.getMobile(), props.getProperty("mobile") ); //format missmatch
        Assert.assertEquals(myAd.getTitle(), props.getProperty("title") );
        Assert.assertEquals(myAd.getUsername(), props.getProperty("username") );

    }
}


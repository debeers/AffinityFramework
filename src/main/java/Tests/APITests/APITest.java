package Tests.APITests;

import ApiWorker.APIManager;
import ApiWorker.model.PostField;
import ApiWorker.model.ads.postad.PostAdBody;
import ApiWorker.model.ads.postad.PostAdResponse;
import Tests.BaseTest;
import org.testng.annotations.Test;
import retrofit2.Call;

import java.io.IOException;

/**
 * Created by Dem on 24.03.2016.
 */
public class APITest extends BaseTest {

    @Test
    public void API_Post_Test() throws InterruptedException, IOException {

        PostAdBody postAdBody = new PostAdBody();

        postAdBody.addParamField(new PostField());
        postAdBody.addField(new PostField("category_id", 39 + ""));
        postAdBody.addField(new PostField("city_id", 32 + ""));
        postAdBody.addField(new PostField("description", "War... War never changesWar..."));
        postAdBody.addField(new PostField("type", "private"));
        postAdBody.addField(new PostField("title", "Pronto-pronto"));

        postAdBody.addUserInfoField(new PostField("mobile", "+996-778888888"));
        postAdBody.addUserInfoField(new PostField("username", "Ya_Krevedko"));
        postAdBody.addUserInfoField(new PostField("testAPI", "1"));
        String userId = "9346";


            Call<PostAdResponse> res = APIManager.getInstance().postAd(postAdBody, userId);
            System.out.println("ID IS:::   " + res.execute().body().getData().getId());

    }
}


package Tests.APITests;

import ApiWorker.APIManager;
import ApiWorker.model.PostField;
import ApiWorker.model.ads.getpostfields.UserInfoField;
import ApiWorker.model.ads.postad.PostAdBody;
import Tests.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by DeBeers on 24.03.2016.
 */
public class AddPostTest extends BaseTest {


    @Test
    public void Add_Post_API() throws IOException {

//        String userId = "9346";
//
//        PostAdBody postAdBody = new PostAdBody();
//        postAdBody.addField(new PostField("category_id", 39 + ""));
//        postAdBody.addField(new PostField("city_id", 33 + ""));
//        postAdBody.addField(new PostField("description", "Hello Java 8!"));
//        postAdBody.addField(new PostField("type", "private"));
//        postAdBody.addField(new PostField("title", "Maverick Cronos"));
//
//        postAdBody.addUserInfoField(new PostField("mobile", "+996-778888888"));
//        postAdBody.addUserInfoField(new PostField("username", "Julius Ceasar"));
//
//        APIManager.getInstance().postAd(null, postAdBody, userId);


        String res = APIManager.getInstance().signUp(false, true, "", "debeers19yyydfghgjgh89@gmail.com");
        System.out.println(res);

    }

}

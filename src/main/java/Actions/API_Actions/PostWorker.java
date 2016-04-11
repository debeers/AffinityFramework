package Actions.API_Actions;

import ApiWorker.APIManager;
import ApiWorker.model.PostField;
import ApiWorker.model.ads.Ad;
import ApiWorker.model.ads.getads.GetAdsData;
import ApiWorker.model.ads.getads.GetAdsResponse;
import ApiWorker.model.ads.postad.PostAdBody;
import ApiWorker.model.ads.postad.PostAdResponse;
import ApiWorker.model.filter.AdFilter;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by DeBeers on 30.03.2016.
 */
public class PostWorker {



    public static long createNewPostViaAPI(Properties props) throws IOException {

        PostAdBody postAdBody = new PostAdBody();

        postAdBody.addParamField(new PostField());
        postAdBody.addField(new PostField("category_id", props.getProperty("category_id")));
        postAdBody.addField(new PostField("city_id", props.getProperty("city_id")));
        postAdBody.addField(new PostField("description", props.getProperty("description")));
        postAdBody.addField(new PostField("type", props.getProperty("type")));
        postAdBody.addField(new PostField("title", props.getProperty("title")));

        postAdBody.addUserInfoField(new PostField("mobile", props.getProperty("mobile")));
        postAdBody.addUserInfoField(new PostField("username", props.getProperty("username")));
        postAdBody.addUserInfoField(new PostField("testAPI", props.getProperty("testAPI")));

        Call<PostAdResponse> res = APIManager.getInstance().postAd(postAdBody, props.getProperty("userId"));
        long postId = Long.parseLong(res.execute().body().getData().getId());
        System.out.println("POST ID IS::: " + postId);

        return postId;
    }

    //public static Ad getPostByIdViaAPI(String postId) throws IOException {

     //   Call<GetAdByIdResponse> getAdById = APIManager.getInstance().getAdById(postId);
     //   return getAdById.execute().body().getAdList().get(0);
    //}


    public static List<Ad> getAdsViaAPI() throws IOException {
        AdFilter filter = new AdFilter();
        //filter.setCategoryId(80);
        //filter.setLocationId(1);
        Call<GetAdsResponse> getAdsList = APIManager.getInstance().getAdList(filter,2);

        return getAdsList.execute().body().getData().getAdList();
    }

    public static Ad getAdFromList(long postId) throws IOException {
        GetAdsData pullMyAd = (GetAdsData) getAdsViaAPI();
        Ad pullAdsData = pullMyAd.getAd(postId);
        return pullAdsData;
    }

}

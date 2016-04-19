package ApiWorker.model.ads.postAd;


import ApiWorker.model.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 4/9/15.
 */
public class PostAdResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private PostAdData data;

    public PostAdResponse() {
    }

    public PostAdResponse(PostAdData data) {
        this.data = data;
    }

    public PostAdData getData() {
        return data;
    }

    public void setData(PostAdData data) {
        this.data = data;
    }
}

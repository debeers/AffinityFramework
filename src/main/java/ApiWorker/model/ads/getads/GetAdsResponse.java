package ApiWorker.model.ads.getAds;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.BaseResponse;


/**
 * Created by artem on 2/18/15.
 */
public class GetAdsResponse extends BaseResponse  {

    @SerializedName("data")
    @Expose
    private GetAdsData data;

    public GetAdsResponse() {
    }

    public GetAdsResponse(GetAdsData data) {

        this.data = data;
    }

    public GetAdsData getData() {

        return data;
    }

    public void setData(GetAdsData data) {

        this.data = data;
    }
}

package ApiWorker.model.ads.getadbyid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ApiWorker.model.BaseResponse;
import ApiWorker.model.ads.Ad;

/**
 * Created by artem on 4/2/15.
 */
public class GetAdByIdResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private List<Ad> adList;

    public GetAdByIdResponse() {

    }

    public GetAdByIdResponse(List<Ad> adList) {

        this.adList = adList;
    }

    public List<Ad> getAdList() {

        return adList;
    }

    public void setAdList(List<Ad> adList) {

        this.adList = adList;
    }
}

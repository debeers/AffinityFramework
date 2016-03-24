package ApiWorker.model.ads.getadurl;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.BaseResponse;


/**
 * Created by artem on 9/24/15.
 */
public class GetAdURLByIdResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private GetAdURLByIdData data;

    public GetAdURLByIdData getData() {

        return data;
    }

}

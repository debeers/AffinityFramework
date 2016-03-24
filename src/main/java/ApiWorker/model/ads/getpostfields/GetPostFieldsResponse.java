package ApiWorker.model.ads.getpostfields;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 4/5/15.
 */
public class GetPostFieldsResponse extends ApiWorker.model.BaseResponse {

    @SerializedName("data")
    @Expose
    private GetPostFieldsData data;

    public GetPostFieldsResponse() {

    }

    public GetPostFieldsResponse(GetPostFieldsData data) {

        this.data = data;
    }

    public GetPostFieldsData getData() {

        return data;
    }

    public void setData(GetPostFieldsData data) {

        this.data = data;
    }
}

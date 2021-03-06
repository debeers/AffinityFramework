package ApiWorker.model.filter.getlocation;

import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseResponse;

/**
 * Created by artem on 4/2/15.
 */
public class GetLocationResponse extends BaseResponse {

    @SerializedName("data")
    private GetLocationData data;

    public GetLocationResponse() {

    }

    public GetLocationResponse(GetLocationData data) {

        this.data = data;
    }

    public GetLocationData getData() {

        return data;
    }

    public void setData(GetLocationData data) {

        this.data = data;
    }
}
package ApiWorker.model.filter.getparams;

import ApiWorker.model.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 8/27/15.
 */
public class GetParamsResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private GetParamsData getParamsData;

    public GetParamsResponse() {

    }

    public String getPhoneMask() {

        return getParamsData != null ? getParamsData.getPhoneMask() : "";
    }
    
    public List<Currency> getCurrencies() {

        return getParamsData != null ? getParamsData.getCurrencies() : null;
    }
}

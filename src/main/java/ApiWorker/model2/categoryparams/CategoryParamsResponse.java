package ApiWorker.model2.categoryParams;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import ApiWorker.model2.BaseResponse;
import ApiWorker.model2.filter.Param;

/**
 * Created by artem on 3/17/16.
 */
public class CategoryParamsResponse extends BaseResponse {

    @SerializedName("data")
    private List<Param> params;

    public CategoryParamsResponse() {

    }

    public List<Param> getParams() {

        return params;
    }

    public boolean isParamsExists() {

        return params != null && !params.isEmpty();
    }
}

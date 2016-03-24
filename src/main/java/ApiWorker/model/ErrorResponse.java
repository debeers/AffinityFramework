package ApiWorker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 8/30/15.
 */
public class ErrorResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    ErrorData data;

    public ErrorResponse() {

    }

    public ErrorData getData() {

        return data;
    }
}

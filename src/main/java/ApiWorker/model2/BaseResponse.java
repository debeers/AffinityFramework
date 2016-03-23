package ApiWorker.model2;

import com.google.gson.annotations.SerializedName;

import retrofit2.Response;

/**
 * Created by artem on 3/17/16.
 */
public class BaseResponse   {

    public static final int OK = 200;
    public static final int CREATED = 201;

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public boolean isStatusOK() {

        return code == OK || code == CREATED;
    }

    public static <T extends BaseResponse> boolean isStatusOK(Response<T> response) {

        return response != null && response.isSuccessful() && response.errorBody() == null &&
                response.body() != null && response.body().isStatusOK();
    }

    public BaseResponse() {

    }
}

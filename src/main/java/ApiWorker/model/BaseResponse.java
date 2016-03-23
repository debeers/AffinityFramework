package ApiWorker.model;


import com.google.gson.annotations.SerializedName;

import retrofit2.Response;

/**
 * Created by artem on 7/26/15.
 */
public class BaseResponse {

    @SerializedName("status")
    private Status status;

    public Status getStatus() {

        return status;
    }

    public boolean isStatusOK() {

        return status != null && status.getCode() == Status.OK;
    }

    public static <T extends BaseResponse> boolean isStatusOK(Response<T> response) {

        return response != null && response.isSuccessful() && response.errorBody() == null &&
                response.body() != null && response.body().isStatusOK();
    }

    public int getCode() {

        return status != null ? status.getCode() : 0;
    }

    public BaseResponse() {

    }

}
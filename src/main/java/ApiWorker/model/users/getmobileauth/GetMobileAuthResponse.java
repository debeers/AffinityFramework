package ApiWorker.model.users.getmobileauth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseResponse;
import ApiWorker.model.users.User;

/**
 * Created by artem on 7/26/15.
 */
public class GetMobileAuthResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private User user;

    public GetMobileAuthResponse() {

    }

    public GetMobileAuthResponse(User user) {

        this.user = user;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }
}
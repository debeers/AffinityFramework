package ApiWorker.model.users.signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.BaseResponse;
import ApiWorker.model.users.User;

/**
 * Created by artem on 7/26/15.
 */
public class SignUpResponse extends BaseResponse {

    public SignUpResponse(User user) {
        this.user = user;
    }

    @SerializedName("data")
    @Expose
    private User user;

    public SignUpResponse() {

    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }
}

package ApiWorker.model.users.checkuser;

import ApiWorker.model.BaseResponse;
import ApiWorker.model.users.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 9/8/15.
 */
public class CheckUserResponse extends BaseResponse {

    public static final String USER_NOT_FOUND_ERROR = "User not found";

    @SerializedName("data")
    @Expose
    private User user;

    public User getUser() {

        return user;
    }

    public CheckUserResponse() {

    }

    public CheckUserResponse(User user) {
        this.user = user;
    }
}

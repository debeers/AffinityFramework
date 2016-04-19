package ApiWorker.model.users.signUp;

import ApiWorker.model.BaseModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 8/25/15.
 */
public class SignUpData extends BaseModel {

    @SerializedName("user_id")
    private long userId;

    @SerializedName("hash")
    private String hash;

    public SignUpData() {

    }

    public SignUpData(long userId, String hash) {
        this.userId = userId;
        this.hash = hash;
    }

    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    public String getHash() {

        return hash;
    }

    public void setHash(String hash) {

        this.hash = hash;
    }
}

package ApiWorker.model.users.checkuser;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseResponse;
import classifieds.yalla.model.users.User;

/**
 * Created by artem on 9/8/15.
 */
public class CheckUserResponse extends BaseResponse implements Parcelable {

    public static final String USER_NOT_FOUND_ERROR = "User not found";

    @SerializedName("data")
    @Expose
    private User user;

    public User getUser() {

        return user;
    }

    public CheckUserResponse() {

    }

    protected CheckUserResponse(Parcel in) {
        super(in);
        user = in.readParcelable(User.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(user, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CheckUserResponse> CREATOR = new Creator<CheckUserResponse>() {
        @Override
        public CheckUserResponse createFromParcel(Parcel in) {
            return new CheckUserResponse(in);
        }

        @Override
        public CheckUserResponse[] newArray(int size) {
            return new CheckUserResponse[size];
        }
    };
}

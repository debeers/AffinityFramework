package ApiWorker.model.users.signup;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseModel;

/**
 * Created by artem on 8/25/15.
 */
public class SignUpData extends BaseModel implements Parcelable {

    @SerializedName("user_id")
    private long userId;

    @SerializedName("hash")
    private String hash;

    public SignUpData() {

    }

    protected SignUpData(Parcel in) {
        super(in);

        userId = in.readLong();
        hash = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeLong(userId);
        dest.writeString(hash);
    }

    @Override
    public int describeContents() {

        return 0;
    }

    public static final Creator<SignUpData> CREATOR = new Creator<SignUpData>() {

        @Override
        public SignUpData createFromParcel(Parcel in) {
            
            return new SignUpData(in);
        }

        @Override
        public SignUpData[] newArray(int size) {

            return new SignUpData[size];
        }
    };

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

package ApiWorker.model.chats;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseModel;

/**
 * Created by artem on 8/18/15.
 */
public class Member extends BaseModel implements Parcelable {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("last_view")
    @Expose
    private long lastView;

    @SerializedName("username")
    @Expose
    private String userName;

    public long getId() {

        return id;
    }

    protected Member(Parcel in) {
        super(in);

        type = in.readString();
        id = in.readLong();
        lastView = in.readLong();
        userName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(type);
        dest.writeLong(id);
        dest.writeLong(lastView);
        dest.writeString(userName);
    }

    @Override
    public int describeContents() {

        return 0;
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {

        @Override
        public Member createFromParcel(Parcel in) {

            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {

            return new Member[size];
        }
    };
}

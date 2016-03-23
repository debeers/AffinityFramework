package ApiWorker.model.chats.getunreadcount;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseResponse;

/**
 * Created by artem on 9/24/15.
 */
public class GetUnreadCountResponse extends BaseResponse implements Parcelable {

    @SerializedName("unreadCount")
    @Expose
    private int unreadCount;

    public int getUnreadCount() {

        return unreadCount;
    }

    protected GetUnreadCountResponse(Parcel in) {
        super(in);
        unreadCount = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(unreadCount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GetUnreadCountResponse> CREATOR = new Creator<GetUnreadCountResponse>() {
        @Override
        public GetUnreadCountResponse createFromParcel(Parcel in) {
            return new GetUnreadCountResponse(in);
        }

        @Override
        public GetUnreadCountResponse[] newArray(int size) {
            return new GetUnreadCountResponse[size];
        }
    };
}

package ApiWorker.model.chats.getmessages;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import classifieds.yalla.model.BaseResponse;
import classifieds.yalla.model.chats.Message;

/**
 * Created by artem on 9/24/15.
 */
public class GetMessagesResponse extends BaseResponse implements Parcelable {

    @SerializedName("data")
    @Expose
    private List<Message> messageList;

    public List<Message> getMessageList() {

        return messageList;
    }

    protected GetMessagesResponse(Parcel in) {
        super(in);

        messageList = in.createTypedArrayList(Message.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeTypedList(messageList);
    }

    @Override
    public int describeContents() {

        return 0;
    }

    public static final Creator<GetMessagesResponse> CREATOR = new Creator<GetMessagesResponse>() {
        @Override
        public GetMessagesResponse createFromParcel(Parcel in) {

            return new GetMessagesResponse(in);
        }

        @Override
        public GetMessagesResponse[] newArray(int size) {

            return new GetMessagesResponse[size];
        }
    };
}

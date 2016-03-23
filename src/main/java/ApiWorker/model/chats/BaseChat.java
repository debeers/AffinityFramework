package ApiWorker.model.chats;

import android.os.Parcel;
import android.os.Parcelable;

import classifieds.yalla.model.BaseModel;

/**
 * Created by artem on 9/21/15.
 */
public class BaseChat extends BaseModel implements Parcelable {

    private String title;

    public BaseChat(String title) {

        this.title = title;
    }

    protected BaseChat(Parcel in) {
        super(in);
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(title);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BaseChat> CREATOR = new Creator<BaseChat>() {
        @Override
        public BaseChat createFromParcel(Parcel in) {
            return new BaseChat(in);
        }

        @Override
        public BaseChat[] newArray(int size) {
            return new BaseChat[size];
        }
    };

    public String getTitle() {

        return title;
    }
}

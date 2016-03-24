package ApiWorker.model.ads.uploadimage;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseModel;

/**
 * Created by artem on 12/28/15.
 */
public class UploadImageData extends BaseModel implements Parcelable {

    @SerializedName("fileName")
    private String fileName;

    @SerializedName("id")
    private String id;

    @SerializedName("removeKey")
    private String removeKey;

    public String getId() {

        return id;
    }

    protected UploadImageData(Parcel in) {
        super(in);

        fileName = in.readString();
        id = in.readString();
        removeKey = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(fileName);
        dest.writeString(id);
        dest.writeString(removeKey);
    }

    @Override
    public int describeContents() {

        return 0;
    }

    public static final Creator<UploadImageData> CREATOR = new Creator<UploadImageData>() {
        @Override
        public UploadImageData createFromParcel(Parcel in) {

            return new UploadImageData(in);
        }

        @Override
        public UploadImageData[] newArray(int size) {

            return new UploadImageData[size];
        }
    };
}

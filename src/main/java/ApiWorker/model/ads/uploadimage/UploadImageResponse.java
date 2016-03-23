package ApiWorker.model.ads.uploadimage;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseResponse;

/**
 * Created by artem on 12/28/15.
 */
public class UploadImageResponse extends BaseResponse implements Parcelable{

    @SerializedName("data")
    private UploadImageData data;

    public UploadImageData getData() {

        return data;
    }

    public UploadImageResponse() {

    }

    protected UploadImageResponse(Parcel in) {
        super(in);

        data = in.readParcelable(UploadImageData.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeParcelable(data, flags);
    }

    @Override
    public int describeContents() {

        return 0;
    }

    public static final Creator<UploadImageResponse> CREATOR = new Creator<UploadImageResponse>() {

        @Override
        public UploadImageResponse createFromParcel(Parcel in) {

            return new UploadImageResponse(in);
        }

        @Override
        public UploadImageResponse[] newArray(int size) {

            return new UploadImageResponse[size];
        }
    };
}

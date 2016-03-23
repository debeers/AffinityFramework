package ApiWorker.model.ads.getpostfields;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseResponse;

/**
 * Created by artem on 4/5/15.
 */
public class GetPostFieldsResponse extends BaseResponse implements Parcelable {

    @SerializedName("data")
    @Expose
    private GetPostFieldsData data;

    public GetPostFieldsResponse() {

    }

    public GetPostFieldsResponse(GetPostFieldsData data) {

        this.data = data;
    }

    protected GetPostFieldsResponse(Parcel in) {
        super(in);

        data = in.readParcelable(GetPostFieldsData.class.getClassLoader());
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

    public static final Creator<GetPostFieldsResponse> CREATOR = new Creator<GetPostFieldsResponse>() {

        @Override
        public GetPostFieldsResponse createFromParcel(Parcel in) {

            return new GetPostFieldsResponse(in);
        }

        @Override
        public GetPostFieldsResponse[] newArray(int size) {

            return new GetPostFieldsResponse[size];
        }
    };

    public GetPostFieldsData getData() {

        return data;
    }

    public void setData(GetPostFieldsData data) {

        this.data = data;
    }
}

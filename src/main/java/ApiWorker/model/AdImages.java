package ApiWorker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 2/12/15.
 */
public class AdImages extends BaseModel implements Parcelable {

    @SerializedName("original")
    @Expose
    private List<Image> thumbnailImages;

    @SerializedName("fullsize")
    @Expose
    private List<Image> originalImages;

    public AdImages() {

    }

    protected AdImages(Parcel in) {
        super(in);

        thumbnailImages = in.createTypedArrayList(Image.CREATOR);
        originalImages = in.createTypedArrayList(Image.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeTypedList(thumbnailImages);
        dest.writeTypedList(originalImages);
    }

    @Override
    public int describeContents() {

        return 0;
    }

    public static final Creator<AdImages> CREATOR = new Creator<AdImages>() {

        @Override
        public AdImages createFromParcel(Parcel in) {

            return new AdImages(in);
        }

        @Override
        public AdImages[] newArray(int size) {

            return new AdImages[size];
        }
    };

    public List<Image> getThumbnailImages() {

        return thumbnailImages;
    }

    public List<Image> getOriginalImages() {

        return originalImages;
    }
}
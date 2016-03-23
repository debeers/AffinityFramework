package ApiWorker.model2;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 3/17/16.
 */
public class KeyValue extends BaseModel implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("value")
    @Expose
    private String value;

    public KeyValue(String id) {

        this.id = id;
    }

    public KeyValue(String id, String value) {

        this.id = id;
        this.value = value;
    }

    public String getId() {

        return id;
    }

    public String getValue() {

        return value;
    }

    @Override
    public int hashCode() {

        int result = 7;
        result = 31 * result + id.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof KeyValue))
            return false;

        if (this == o)
            return true;

        return this.id.equalsIgnoreCase(((KeyValue) o).getId());
    }

    public KeyValue() {

    }

    protected KeyValue(Parcel in) {
        super(in);

        id = in.readString();
        value = in.readString();
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(id);
        dest.writeString(value);
    }

    public static final Parcelable.Creator<KeyValue> CREATOR = new Parcelable.Creator<KeyValue>() {

        @Override
        public KeyValue createFromParcel(Parcel in) {

            return new KeyValue(in);
        }

        @Override
        public KeyValue[] newArray(int size) {

            return new KeyValue[size];
        }
    };
}

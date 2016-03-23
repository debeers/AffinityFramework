package ApiWorker.model.filter.getparams;

import android.os.Parcel;
import android.os.Parcelable;

import classifieds.yalla.model.BaseModel;

/**
 * Created by artem on 2/12/16.
 */
public class Currency extends BaseModel implements Parcelable {

    private String key;
    private String name;

    public Currency() {

    }

    public Currency(Parcel in) {
        super(in);

        key = in.readString();
        name = in.readString();
    }

    public Currency(String key, String name) {

        this.key = key;
        this.name = name;
    }

    public String getKey() {

        return key;
    }

    public String getName() {

        return name;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(key);
        dest.writeString(name);
    }

    public static final Creator<Currency> CREATOR = new Creator<Currency>() {

        @Override
        public Currency createFromParcel(Parcel in) {

            return new Currency(in);
        }

        @Override
        public Currency[] newArray(int size) {

            return new Currency[size];
        }
    };

    @Override
    public int hashCode() {

        return key.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Currency))
            return false;

        if (this == o)
            return true;

        return this.key.equalsIgnoreCase(((Currency) o).getKey());
    }
}

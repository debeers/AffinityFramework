package ApiWorker.model.filter.getlocation;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ApiWorker.model.filter.Filter;

/**
 * Created by artem on 4/2/15.
 */
public class Location extends Filter implements Parcelable {

    @SerializedName("children")
    private List<Location> childrenList;

    public Location() {

    }

    public Location(long id, String name) {

        this.id = id;
        this.name = name;
    }

    public Location(long id, String name, List<Location> childrenList) {

        this.id = id;
        this.name = name;
        this.childrenList = childrenList;
    }

    public Location(long id) {
        super(id);

    }

    public Location(Parcel in) {
        super(in);

        childrenList = in.createTypedArrayList(Location.CREATOR);
    }

    public List<Location> getChildrenList() {

        return childrenList;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeTypedList(childrenList);
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {

        @Override
        public Location createFromParcel(Parcel in) {

            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {

            return new Location[size];
        }
    };
}

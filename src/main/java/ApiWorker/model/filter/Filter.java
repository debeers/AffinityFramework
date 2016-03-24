package ApiWorker.model.filter;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseModel;

/**
 * Created by artem on 4/2/15.
 */
public class Filter extends BaseModel implements Parcelable {

    @SerializedName("id")
    protected long id;

    @SerializedName("name")
    protected String name;

    @SerializedName("has_children")
    protected long children;

    protected long parentId;

    public Filter(long id) {

        this.id = id;
    }

    public Filter(Parcel in) {
        super(in);

        id = in.readLong();
        name = in.readString();
        children = in.readLong();
        parentId = in.readLong();
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getParent() {

        return parentId;
    }

    public void setParent(long parentId) {

        this.parentId = parentId;
    }

    public String getName() {

        return name;
    }

    public boolean hasChildren() {

        return children > 0;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Filter() {

    }

    public Filter(String name) {

        this.name = name;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public int hashCode() {

        int result = 7;
        result = (31 * result + (int) id);

        return result;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Filter))
            return false;

        if (this == o)
            return true;

        return this.id == ((Filter) o).getId();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeLong(id);
        dest.writeString(name);
        dest.writeLong(children);
        dest.writeLong(parentId);
    }

    public static final Creator<Filter> CREATOR = new Creator<Filter>() {

        @Override
        public Filter createFromParcel(Parcel in) {

            return new Filter(in);
        }

        @Override
        public Filter[] newArray(int size) {

            return new Filter[size];
        }
    };
}

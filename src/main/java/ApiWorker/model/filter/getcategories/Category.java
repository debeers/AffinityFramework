package ApiWorker.model.filter.getcategories;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ApiWorker.model.ads.Ad;
import ApiWorker.model.filter.Filter;

/**
 * Created by artem on 4/2/15.
 */
public class Category extends Filter implements Parcelable {

    private static final String LINEAR_LIST_TYPE = "table";

    @SerializedName("children")
    private List<Category> childrenList;

    @SerializedName("ad")
    private List<Ad> adList;

    @SerializedName("api_list_type")
    private String listType;

    @SerializedName("alias")
    private String alias;

    public Category() {

    }

    public Category(long id) {
        super(id);

    }

    public Category(long id, String name) {

        this.id = id;
        this.name = name;
    }

    public Category(Parcel in) {
        super(in);

        childrenList = in.createTypedArrayList(Category.CREATOR);
        adList = in.createTypedArrayList(Ad.CREATOR);
        listType = in.readString();
        alias = in.readString();
    }

    public Category(long id, String name, List<Category> mChildrenList) {
        this.id = id;
        this.name = name;
        this.childrenList = mChildrenList;
    }

    public String getListType() {

        return listType;
    }

    public void setListType(String listType) {

        this.listType = listType;
    }

    public String getAlias() {

        return alias;
    }

    public List<Ad> getAdList() {

        return adList;
    }

    public void setAdList(List<Ad> adList) {

        this.adList = adList;
    }

    public boolean isAdListEmpty() {

        return adList == null || adList.isEmpty();
    }

    public boolean isLinearListType() {

        return LINEAR_LIST_TYPE.equals(listType);
    }

    public boolean hasChildren() {

        return childrenList != null && childrenList.size() > 0;
    }

    public List<Category> getChildrenList() {

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
        dest.writeTypedList(adList);
        dest.writeString(listType);
        dest.writeString(alias);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {

        @Override
        public Category createFromParcel(Parcel in) {

            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {

            return new Category[size];
        }
    };
}
